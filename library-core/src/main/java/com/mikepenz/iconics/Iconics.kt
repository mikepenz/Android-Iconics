/*
 * Copyright 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikepenz.iconics

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.CharacterStyle
import android.util.Log.ERROR
import android.widget.Button
import android.widget.TextView
import com.mikepenz.iconics.animation.IconicsAnimationProcessor
import com.mikepenz.iconics.context.ReflectionUtils
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.utils.GenericsUtil
import com.mikepenz.iconics.utils.IconicsLogger
import com.mikepenz.iconics.utils.IconicsPreconditions
import com.mikepenz.iconics.utils.InternalIconicsUtils
import com.mikepenz.iconics.utils.clearedIconName
import com.mikepenz.iconics.utils.iconPrefix
import java.util.LinkedList

@SuppressLint("StaticFieldLeak")
object Iconics {

    private var INIT_DONE = false
    private val FONTS = HashMap<String, ITypeface>()
    private val PROCESSORS = HashMap<String, Class<out IconicsAnimationProcessor>>()

    @JvmField internal val TAG = Iconics::class.java.simpleName
    @JvmStatic lateinit var applicationContext: Context
        internal set

    @JvmField var logger: IconicsLogger = IconicsLogger.DEFAULT

    /**
     * Initializes the FONTS. This also tries to find all founds automatically via their font file
     */
    @JvmStatic fun init(context: Context? = null) {
        if (context != null) {
            if (!::applicationContext.isInitialized) {
                this.applicationContext = context.applicationContext
            }
        }

        if (!INIT_DONE) {
            if (!::applicationContext.isInitialized) {
                throw RuntimeException("A 'Iconics.init(context)' has to happen first. Call from your application. Usually this happens via an 'IconicsDrawable' usage.")
            }

            GenericsUtil.getDefinedFonts(applicationContext).forEach {
                try {
                    registerFont(ReflectionUtils.getInstanceForName(it))
                } catch (e: Exception) {
                    logger.log(ERROR, TAG, "Can't init font: $it", e)
                }
            }
            GenericsUtil.getDefinedProcessors(applicationContext).forEach {
                try {
                    registerProcessor(ReflectionUtils.getInstanceForName(it))
                } catch (e: Exception) {
                    logger.log(ERROR, TAG, "Can't init processor: $it", e)
                }
            }
            INIT_DONE = true
        }
    }

    /**
     * This makes sure the FONTS are initialized. If the given fonts Map is empty we set the
     * initialized FONTS on it
     */
    @JvmStatic private fun init(fonts: Map<String, ITypeface>?): Map<String, ITypeface> {
        init()
        return if (fonts.isNullOrEmpty()) FONTS else fonts
    }

    /**
     * This allows to mark the initialization as done, even if `init(ctx: Context)` was not called
     * prior.
     * It requires at least one font to be registered manually in the
     * [android.app.Application.onCreate] via [registerFont].
     */
    @JvmStatic fun markInitDone() {
        if (FONTS.isEmpty()) {
            throw IllegalArgumentException(
                "At least one font needs to be registered first\n" +
                        "    via ${javaClass.canonicalName}.registerFont(Iconics.kt:117)"
            )
        } else {
            INIT_DONE = true
        }
    }

    /**
     * Test if the icon exists in the currently loaded fonts
     *
     * @param icon    The icon to verify
     * @return true if the icon is available
     */
    @JvmStatic fun isIconExists(icon: String): Boolean {
        return runCatching { findFont(icon.iconPrefix)!!.getIcon(icon.clearedIconName) }.isSuccess
    }

    /** Registers a fonts into the FONTS array for performance */
    @JvmStatic fun registerFont(font: ITypeface): Boolean {
        FONTS[font.mappingPrefix] = font.validate()
        return true
    }

    /** Registers a processor into the PROCESSORS array for performance */
    @JvmStatic fun registerProcessor(processor: IconicsAnimationProcessor) {
        PROCESSORS[processor.animationTag] = processor.javaClass
    }

    /** Tries to find a processor by its key in all registered PROCESSORS */
    @JvmStatic fun findProcessor(animationTag: String): IconicsAnimationProcessor? {
        init()

        PROCESSORS[animationTag]?.also {
            try {
                return ReflectionUtils.getInstanceOf(it)
            } catch (e: IllegalAccessException) {
                logger.log(ERROR, TAG, "Can't create processor for animation tag $animationTag", e)
            } catch (e: InstantiationException) {
                logger.log(ERROR, TAG, "Can't create processor for animation tag $animationTag", e)
            }
        }
        return null
    }

    /** Perform a basic sanity check for a font. */
    @JvmStatic private fun ITypeface.validate(): ITypeface {
        IconicsPreconditions.checkMappingPrefix(mappingPrefix)
        return this
    }

    /** Return all registered FONTS */
    private val registeredFonts: List<ITypeface>
        get() {
            return FONTS.values.toList()
        }

    /** Return all registered FONTS */
    @JvmStatic fun getRegisteredFonts(context: Context? = null): List<ITypeface> {
        init(context)
        return registeredFonts
    }

    /** Return all registered PROCESSORS */
    @JvmStatic val registeredProcessors: List<Class<out IconicsAnimationProcessor>>
        get() {
            init()
            return PROCESSORS.values.toList()
        }

    /** Return all registered PROCESSORS */
    @JvmStatic fun getRegisteredProcessors(context: Context? = null): List<Class<out IconicsAnimationProcessor>> {
        init(context)
        return registeredProcessors
    }

    /** Tries to find a font by its key in all registered FONTS */
    @JvmStatic fun findFont(key: String, context: Context? = null): ITypeface? {
        init(context)
        return FONTS[key]
    }

    /** Fetches the font from the Typeface of an IIcon */
    @JvmStatic fun findFont(icon: IIcon): ITypeface {
        return icon.typeface
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct
     * mapping. Afterwards it will apply the styles
     */
    @JvmStatic fun style(textSpanned: Spanned): Spanned {
        return style(null, textSpanned, null, null)
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct
     * mapping. Afterwards it will apply the styles
     */
    @JvmStatic fun style(
        fonts: Map<String, ITypeface>?,
        textSpanned: Spanned,
        styles: List<CharacterStyle>?,
        stylesFor: Map<String, MutableList<CharacterStyle>>?
    ): Spanned {

        //find all icons which should be replaced with the iconFont
        val textStyleContainer = init(fonts).let {
            InternalIconicsUtils.findIcons(textSpanned, it)
        }

        //create spannableString to set the spans on
        val sb = SpannableString.valueOf(textStyleContainer.spannableStringBuilder)

        //set all the icons and styles
        InternalIconicsUtils.applyStyles(sb, textStyleContainer.styleContainers, styles, stylesFor)

        return sb
    }

    /**
     * Iterates over the editable once and replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     */
    @JvmStatic fun styleEditable(editable: Editable) {
        styleEditable(null, editable, null, null)
    }

    /**
     * Iterates over the editable once and replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     */
    @JvmStatic fun styleEditable(
        fonts: Map<String, ITypeface>?,
        textSpanned: Editable,
        styles: List<CharacterStyle>?,
        stylesFor: Map<String, MutableList<CharacterStyle>>?
    ) {

        //find all icons which should be replaced with the iconFont
        val styleContainers = init(fonts).let {
            InternalIconicsUtils.findIconsFromEditable(textSpanned, it)
        }

        //set all the icons and styles
        InternalIconicsUtils.applyStyles(textSpanned, styleContainers, styles, stylesFor)
    }

    class BuilderString(
        private val fonts: List<ITypeface>,
        private val text: Spanned,
        private val withStyles: List<CharacterStyle>,
        private val withStylesFor: HashMap<String, MutableList<CharacterStyle>>
    ) {

        fun build(): Spanned {
            val mappedFonts = fonts.associateBy { it.mappingPrefix }
            return style(mappedFonts, text, withStyles, withStylesFor)
        }
    }

    class BuilderView(
        private val fonts: List<ITypeface>,
        private val view: TextView,
        private val withStyles: List<CharacterStyle>,
        private val withStylesFor: HashMap<String, MutableList<CharacterStyle>>
    ) {

        fun build() {
            val mappedFonts = HashMap<String, ITypeface>()
            fonts.associateTo(mappedFonts) { it.mappingPrefix to it }

            //DO NOT STYLE EDITABLE (comes from EditText) as this causes bad issues with the cursor!
            if (view.text is Spanned) {
                view.text = style(mappedFonts, view.text as Spanned, withStyles, withStylesFor)
            } else {
                view.text = style(
                    mappedFonts,
                    SpannableString(view.text),
                    withStyles,
                    withStylesFor
                )
            }

            if (view is Button) {
                view.setAllCaps(false)
            }
        }
    }

    class Builder {
        private val styles = LinkedList<CharacterStyle>()
        private val stylesFor = HashMap<String, MutableList<CharacterStyle>>()
        private val fonts = LinkedList<ITypeface>()

        fun style(vararg styles: CharacterStyle): Builder {
            this.styles.addAll(styles)
            return this
        }

        /**
         * This method allows you to apply additional styles on icons , just provide all
         * CharacterStyles you want to apply on the given IIcon
         */
        fun styleFor(styleFor: IIcon, vararg styles: CharacterStyle): Builder {
            return styleFor(styleFor.name, *styles)
        }

        /**
         * This method allows you to apply additional styles on icons , just provide all
         * CharacterStyles you want to apply on the given icon (by it's name faw-android)
         */
        fun styleFor(styleFor: String, vararg styles: CharacterStyle): Builder {
            val clearedStyleFor = styleFor.clearedIconName

            styles.forEach { stylesFor.getOrPut(clearedStyleFor) { LinkedList() }.add(it) }
            return this
        }

        /** Adds additional fonts which should be used to apply the icons */
        fun font(font: ITypeface): Builder {
            fonts.add(font)
            return this
        }

        /** Defines where the icons should be applied to */
        fun on(on: Spanned): BuilderString = BuilderString(fonts, on, styles, stylesFor)

        /** Defines where the icons should be applied to */
        fun on(on: String): BuilderString = on(SpannableString(on))

        /** Defines where the icons should be applied to */
        fun on(on: CharSequence): BuilderString = on(on.toString())

        /** Defines where the icons should be applied to */
        fun on(on: StringBuilder): BuilderString = on(on.toString())

        /** Defines where the icons should be applied to */
        fun on(on: TextView): BuilderView = BuilderView(fonts, on, styles, stylesFor)

        /** Defines where the icons should be applied to */
        fun on(on: Button): BuilderView = BuilderView(fonts, on, styles, stylesFor)
    }
}
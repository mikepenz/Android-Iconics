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
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.mikepenz.iconics.animation.IconicsAnimationProcessor
import com.mikepenz.iconics.context.ReflectionUtils
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.utils.GenericsUtil
import com.mikepenz.iconics.utils.InternalIconicsUtils
import java.util.HashMap
import java.util.LinkedList

@SuppressLint("StaticFieldLeak")
object Iconics {
    internal val TAG = Iconics::class.java.simpleName

    private var INIT_DONE = false
    private val FONTS = HashMap<String, ITypeface>()
    private val PROCESSORS = HashMap<String, Class<out IconicsAnimationProcessor>>()
    lateinit var applicationContext: Context
        internal set

    /**
     * Initializes the FONTS. This also tries to find all founds automatically via their font file
     */
    fun init() {
        if (!INIT_DONE) {
            GenericsUtil.getDefinedFonts(applicationContext).forEach {
                try {
                    val typeface: ITypeface = ReflectionUtils.classForName(it)
                    validateFont(typeface)
                    FONTS[typeface.mappingPrefix] = typeface
                } catch (e: Exception) {
                    Log.e(TAG, "Can't init font: $it")
                }
            }
            GenericsUtil.getDefinedProcessors(applicationContext).forEach {
                try {
                    registerProcessor(ReflectionUtils.classForName(it))
                } catch (e: Exception) {
                    Log.e(TAG, "Can't init processor: $it")
                }
            }
            INIT_DONE = true
        }
    }

    /**
     * This makes sure the FONTS are initialized. If the given fonts Map is empty we set the
     * initialized FONTS on it
     */
    private fun init(fonts: Map<String, ITypeface>?): Map<String, ITypeface> {
        init()
        return if (fonts == null || fonts.isEmpty()) FONTS else fonts
    }

    /**
     * This allows to mark the initialization as done, even if `init(Context ctx)` was not called
     * prior.
     * It requires at least one font to be registered manually in the
     * [android.app.Application.onCreate] via [registerFont].
     */
    fun markInitDone() {
        if (FONTS.size == 0) {
            throw IllegalArgumentException(
                "At least one font needs to be registered first\n" +
                        "    via ${javaClass.canonicalName}.registerFont(Iconics.kt:110)"
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
    fun isIconExists(icon: String): Boolean {
        return try {
            findFont(icon.substring(0, 3))?.getIcon(icon.replace("-", "_"))
            true
        } catch (ignore: Exception) {
            false
        }
    }

    /** Registers a fonts into the FONTS array for performance */
    fun registerFont(font: ITypeface): Boolean {
        validateFont(font)

        FONTS[font.mappingPrefix] = font
        return true
    }

    /** Registers a processor into the PROCESSORS array for performance */
    fun registerProcessor(processor: IconicsAnimationProcessor) {
        PROCESSORS[processor.animationTag] = processor.javaClass
    }

    /** Tries to find a processor by its key in all registered PROCESSORS */
    fun findProcessor(animationTag: String): IconicsAnimationProcessor? {
        init()

        PROCESSORS[animationTag]?.also {
            try {
                return it.newInstance()
            } catch (e: IllegalAccessException) {
                Log.e(TAG, "Can't create processor for animation tag $animationTag", e)
            } catch (e: InstantiationException) {
                Log.e(TAG, "Can't create processor for animation tag $animationTag", e)
            }
        }
        return null
    }

    /** Perform a basic sanity check for a font. */
    private fun validateFont(font: ITypeface) {
        if (font.mappingPrefix.length == 3) return
        throw IllegalArgumentException("The mapping prefix of a font must be 3 characters long.")
    }

    /** Return all registered FONTS */
    val registeredFonts: Collection<ITypeface>
        get() {
            init()
            return FONTS.values
        }

    /** Return all registered PROCESSORS */
    val registeredProcessors: Collection<Class<out IconicsAnimationProcessor>>
        get() {
            init()
            return PROCESSORS.values
        }

    /** Tries to find a font by its key in all registered FONTS */
    fun findFont(key: String): ITypeface? {
        init()
        return FONTS[key]
    }

    /** Fetches the font from the Typeface of an IIcon */
    fun findFont(icon: IIcon): ITypeface {
        return icon.typeface
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct
     * mapping. Afterwards it will apply the styles
     */
    fun style(textSpanned: Spanned): Spanned {
        return style(null, textSpanned, null, null)
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct
     * mapping. Afterwards it will apply the styles
     */
    fun style(
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
    fun styleEditable(editable: Editable) {
        styleEditable(null, editable, null, null)
    }

    /**
     * Iterates over the editable once and replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     */
    fun styleEditable(
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
            fonts.forEach { mappedFonts[it.mappingPrefix] = it }

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
            val clearedStyleFor = styleFor.replace("-", "_")

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
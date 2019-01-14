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

package com.mikepenz.iconics.ver_four.utils

import android.content.Context
import android.text.Editable
import android.text.ParcelableSpan
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.CharacterStyle
import android.util.Log
import com.mikepenz.iconics.ver_four.Iconics
import com.mikepenz.iconics.ver_four.typeface.ITypeface
import java.util.LinkedList

/**
 * Created by mikepenz on 05.11.15.
 */
internal object InternalIconicsUtils {

    private var ICON_START = '{'
    private var ICON_END = '}'

    /**
     * Finds the icons within a Editable, and tries to map the the available (given via the fonts
     * param) icons on it.
     * Use this whenever possible, as this method does update the Editable, and does not have to
     * create a new Spanned.
     */
    @JvmStatic
    fun findIconsFromEditable(
        editable: Editable,
        fonts: Map<String, ITypeface>
    ): LinkedList<StyleContainer> {
        val styleContainers = LinkedList<StyleContainer>()
        val existingSpans = LinkedList<StyleContainer>()

        // remember the previous style spans
        editable.getSpans<ParcelableSpan>(0, editable.length, ParcelableSpan::class.java)
                .map {
                    StyleContainer(
                        editable.getSpanStart(it),
                        editable.getSpanEnd(it),
                        it,
                        editable.getSpanFlags(it)
                    )
                }
                .toCollection(existingSpans)

        editable.getSpans<CharacterStyle>(0, editable.length, CharacterStyle::class.java)
                .map {
                    StyleContainer(
                        editable.getSpanStart(it),
                        editable.getSpanEnd(it),
                        it,
                        editable.getSpanFlags(it)
                    )
                }
                .toCollection(existingSpans)

        //SpannableStringBuilder has an issue which causes this to crash
        //https://github.com/mikepenz/Android-Iconics/issues/155#issue-141629137
        kotlin.runCatching { editable.clearSpans() }

        var iconStart = -1
        var i = 0
        while (i < editable.length) {
            val c = editable[i]
            if (c == ICON_START) {
                iconStart = i
            } else if (c == ICON_END) {
                if (iconStart > -1) {

                    placeFontIcon(editable, iconStart, i, fonts)?.let { styleContainer ->
                        styleContainers.add(styleContainer)

                        //adjust existing spans to new position
                        existingSpans.forEach {
                            val newIconStart = (i - iconStart)
                            if (it.startIndex > i) {
                                it.startIndex = it.startIndex - newIconStart
                                it.endIndex = it.endIndex - newIconStart
                            } else if (it.endIndex > i) {
                                it.endIndex = it.endIndex - newIconStart
                            }
                        }

                        //remember how many chars were removed already so we can remove the correct
                        // characters
                        i = iconStart
                    }
                }

                iconStart = -1
            }
            i++
        }

        //add the existing spans
        styleContainers.addAll(existingSpans)

        return styleContainers
    }

    @JvmStatic
    private fun placeFontIcon(
        editable: Editable,
        iconStart: Int,
        iconEnd: Int,
        fonts: Map<String, ITypeface>
    ): StyleContainer? {
        //make sure to check only for possible icons
        if (iconEnd - iconStart >= 6) {
            //build the iconString
            val iconString =
                    editable.subSequence(iconStart + 1, iconEnd).replace("-".toRegex(), "_")
            //find out the fontKey
            val fontKey = editable.subSequence(iconStart + 1, iconStart + 4).toString()

            try {
                //get the correct character for this Font and Icon
                val typeface = fonts[fontKey]
                if (typeface != null) {
                    //get the icon for the iconString
                    val icon = kotlin.runCatching { typeface.getIcon(iconString) }.getOrNull()
                    //we can only add an icon which is a font
                    if (icon != null) {
                        //get and add the mapped char to the string
                        val fontChar = icon.character
                        editable.replace(iconStart, iconEnd + 1, fontChar.toString())

                        //add the current icon to the container
                        return StyleContainer(
                            iconStart,
                            iconStart + 1,
                            iconString,
                            fonts[fontKey]!!
                        )
                    } else {
                        Log.e(Iconics.TAG, "Wrong icon name: $iconString")
                    }
                } else {
                    Log.e(Iconics.TAG, "Wrong fontId: $iconString")
                }
            } catch (e: IllegalArgumentException) {
                Log.e(Iconics.TAG, "Wrong icon name: $iconString")
            }
        }
        return null
    }

    /**
     * Finds the icons within a Spanned, and tries to map the the available (given via the fonts
     * param) icons on it
     */
    @JvmStatic
    fun findIcons(spannable: Spanned, fonts: Map<String, ITypeface>): TextStyleContainer {
        val styleContainers = LinkedList<StyleContainer>()
        val existingSpans = LinkedList<StyleContainer>()

        // remember the previous style spans

        spannable.getSpans(0, spannable.length, ParcelableSpan::class.java)
                .map {
                    StyleContainer(
                        spannable.getSpanStart(it),
                        spannable.getSpanEnd(it),
                        it,
                        spannable.getSpanFlags(it)
                    )
                }
                .toCollection(existingSpans)

        spannable.getSpans(0, spannable.length, CharacterStyle::class.java)
                .map {
                    StyleContainer(
                        spannable.getSpanStart(it),
                        spannable.getSpanEnd(it),
                        it,
                        spannable.getSpanFlags(it)
                    )
                }
                .toCollection(existingSpans)

        //the new string built with the replaced icons
        val spannedString = SpannableStringBuilder()
        var tempIconString = SpannableStringBuilder()

        var removedChars = 0
        spannable.forEachIndexed { i, c ->
            if (c == ICON_START) {
                //if something started with { but was no icon replacement
                spannedString.append(tempIconString)
                //start to remember the tempIconString again
                tempIconString = SpannableStringBuilder()
                tempIconString.append(c)
            } else if (c == ICON_END) {
                tempIconString.append(c)
                //make sure there was a { before and enough chars for the font key
                if (tempIconString.length > 5) {
                    placeFontIcon(spannedString, tempIconString, fonts)?.let { styleContainer ->
                        styleContainers.add(styleContainer)

                        //adjust existing spans to new position
                        existingSpans.forEach {
                            if (it.startIndex > i - removedChars) {
                                it.startIndex = it.startIndex - tempIconString.length + 1
                            }
                            if (it.endIndex > i - removedChars) {
                                it.endIndex = it.endIndex - tempIconString.length + 1
                            }
                        }
                        removedChars += tempIconString.length - 1
                    }
                } else {
                    spannedString.append(tempIconString)
                }
                tempIconString = SpannableStringBuilder()
            } else {
                if (tempIconString.isEmpty()) {
                    spannedString.append(c)
                } else {
                    tempIconString.append(c)
                }
            }
        }

        //make sure to add the last characters which create no complete icon
        spannedString.append(tempIconString)

        //add the existing spans
        styleContainers.addAll(existingSpans)

        return TextStyleContainer(spannedString, styleContainers)
    }

    @JvmStatic
    private fun placeFontIcon(
        spannedString: SpannableStringBuilder,
        tempIconString: SpannableStringBuilder,
        fonts: Map<String, ITypeface>
    ): StyleContainer? {
        //make sure to check only for possible icons
        if (tempIconString.length >= 6) {
            //build the iconString
            val iconString = tempIconString.subSequence(1, tempIconString.length - 1)
                    .replace("-".toRegex(), "_")
            //find out the fontKey
            val fontKey = tempIconString.subSequence(1, 4).toString()

            //get the correct character for this Font and Icon
            val typeface = fonts[fontKey]
            if (typeface != null) {
                //get the icon for the iconString
                val icon = kotlin.runCatching { typeface.getIcon(iconString) }.getOrNull()
                //we can only add an icon which is a font
                if (icon != null) {
                    //get and add the mapped char to the string
                    val fontChar = icon.character
                    spannedString.append(fontChar)

                    //add the current icon to the container
                    return StyleContainer(
                        spannedString.length - 1,
                        spannedString.length,
                        iconString,
                        typeface
                    )
                } else {
                    Log.e(Iconics.TAG, "Wrong icon name: $iconString")
                }
            } else {
                Log.e(Iconics.TAG, "Wrong fontId: $iconString")
            }
        }

        //if this was no working icon we add the tempIconString and return null
        spannedString.append(tempIconString)
        return null
    }

    /**
     * Applies all given styles on the given Spannable
     *
     * @param ctx
     * @param text            the text which will get the Styles applied
     * @param styleContainers all styles to apply
     * @param styles          additional CharacterStyles to apply
     * @param stylesFor       additional styles to apply for specific icons
     */
    @JvmStatic
    fun applyStyles(
        ctx: Context,
        text: Spannable,
        styleContainers: List<StyleContainer>,
        styles: List<CharacterStyle>?,
        stylesFor: Map<String, MutableList<CharacterStyle>>?
    ) {
        styleContainers.forEach {
            val styleOrSpan: Any? = when {
                it.style != null -> it.style
                it.span != null -> it.span
                else -> null
            }
            if (styleOrSpan != null) {
                text.setSpan(styleOrSpan, it.startIndex, it.endIndex, it.flags)
            } else {
                text.setSpan(
                    IconicsTypefaceSpan("sans-serif", it.font!!.getTypeface(ctx)),
                    it.startIndex,
                    it.endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            if (stylesFor?.containsKey(it.icon) == true) {
                stylesFor[it.icon]!!.forEach { characterStyle ->
                    text.setSpan(
                        CharacterStyle.wrap(characterStyle),
                        it.startIndex,
                        it.endIndex,
                        it.flags
                    )
                }
            } else {
                styles?.forEach { characterStyle ->
                    text.setSpan(
                        CharacterStyle.wrap(characterStyle),
                        it.startIndex,
                        it.endIndex,
                        it.flags
                    )
                }
            }
        }
    }
}

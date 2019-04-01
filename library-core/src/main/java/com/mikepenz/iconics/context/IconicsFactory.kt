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

package com.mikepenz.iconics.context

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.animation.tryToEnableIconicsAnimation
import com.mikepenz.iconics.core.R
import com.mikepenz.iconics.utils.buildIconics

internal object IconicsFactory {

    @JvmStatic
    fun onViewCreated(view: View?, context: Context, attrs: AttributeSet): View? {
        if (view != null && view.getTag(R.id.iconics_tag_id) != true) {
            onViewCreatedInternal(view, context, attrs)
            view.setTag(R.id.iconics_tag_id, true)
        }
        return view
    }

    @JvmStatic
    @SuppressLint("RestrictedApi")
    private fun onViewCreatedInternal(view: View, context: Context, attrs: AttributeSet?) {
        if (attrs == null) {
            return
        }

        when (view) {
            is ActionMenuItemView -> {
                IconicsAttrsApplier.getIconicsDrawable(context, attrs)?.let {
                    view.setIcon(view.tryToEnableIconicsAnimation(it))
                }
            }
            is EditText -> {
                // for an editText we only style initial as styling the Editable causes problems!
                view.buildIconics()
            }
            is TextView -> {
                view.buildIconics()

                view.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(cs: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun onTextChanged(cs: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun afterTextChanged(editable: Editable) {
                        Iconics.styleEditable(editable)
                    }
                })
            }
            is ImageView -> {
                IconicsAttrsApplier.getIconicsDrawable(context, attrs)?.let {
                    view.setImageDrawable(view.tryToEnableIconicsAnimation(it))
                }
            }
        }
    }
}
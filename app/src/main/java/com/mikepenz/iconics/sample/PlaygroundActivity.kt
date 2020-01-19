/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.sample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.DynamicDrawableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsArrayBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.sample.databinding.ActivityPlaygroundBinding
import com.mikepenz.iconics.typeface.library.community.material.CommunityMaterial
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.octicons.Octicons
import com.mikepenz.iconics.utils.actionBar
import com.mikepenz.iconics.utils.backgroundColorInt
import com.mikepenz.iconics.utils.colorInt
import com.mikepenz.iconics.utils.colorString
import com.mikepenz.iconics.utils.contourWidthDp
import com.mikepenz.iconics.utils.paddingDp
import com.mikepenz.iconics.utils.parseXmlAndSetIconicsDrawables
import com.mikepenz.iconics.utils.roundedCornersDp
import com.mikepenz.iconics.utils.sizeDp
import com.mikepenz.iconics.utils.sizeX
import com.mikepenz.iconics.utils.sizeY

class PlaygroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityPlaygroundBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_playground)

        // Handle Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Show how to style the text of an existing TextView
        Iconics.Builder()
                .style(
                    ForegroundColorSpan(Color.WHITE),
                    BackgroundColorSpan(Color.BLACK),
                    RelativeSizeSpan(2f)
                )
                .styleFor(
                    "faw-adjust",
                    BackgroundColorSpan(Color.RED),
                    ForegroundColorSpan(Color.parseColor("#33000000")),
                    RelativeSizeSpan(2f)
                )
                .on(binding.test1)
                .build()

        //You can also do some advanced stuff like setting an image within a text
        val sb = SpannableString(binding.test5.text)
        val d = IconicsDrawable(this, FontAwesome.Icon.faw_android).apply {
            sizeDp = 48
            paddingDp = 4
        }

        sb.setSpan(
            ImageSpan(d, DynamicDrawableSpan.ALIGN_BOTTOM),
            1,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.test5.text = sb

        //Set the icon of an ImageView (or something else) as drawable
        binding.test2.setImageDrawable(
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).apply {
                sizeDp = 48
                colorString = "#aaFF0000"
                contourWidthDp = 1
            }
        )

        //Set the icon of an ImageView (or something else) as bitmap
        binding.test3.setImageBitmap(
            IconicsDrawable(this, FontAwesome.Icon.faw_android).apply {
                sizeX = IconicsSize.dp(48)
                sizeY = IconicsSize.dp(32)
                paddingDp = 4
                roundedCornersDp = 8
                colorString = "#deFF0000"
            }.toBitmap()
        )

        //Show how to style the text of an existing button
        Iconics.Builder()
                .style(BackgroundColorSpan(Color.BLACK))
                .style(RelativeSizeSpan(2f))
                .style(ForegroundColorSpan(Color.WHITE))
                .on(binding.test4)
                .build()

        //Show how to style the text of an existing button
        val iconStateListDrawable = StateListDrawable()
        iconStateListDrawable.addState(
            intArrayOf(android.R.attr.state_pressed),
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).apply {
                sizeDp = 48
                colorString = "#aaFF0000"
                contourWidthDp = 1
            }
        )
        iconStateListDrawable.addState(
            intArrayOf(),
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).apply {
                sizeDp = 48
                colorString = "#aa00FF00"
                contourWidthDp = 2
            }
        )
        binding.test6.setImageDrawable(iconStateListDrawable)

        val iconicsDrawableBase = IconicsDrawable(this).apply {
            actionBar()
            colorInt = Color.GREEN
            backgroundColorInt = Color.RED
        }
        val array = IconicsArrayBuilder(iconicsDrawableBase)
                .add(FontAwesome.Icon.faw_android)
                .add(Octicons.Icon.oct_octoface)
                .add("Hallo")
                .add('A')
                .add(";)")
                .build()
        binding.list.adapter = IconsAdapter(this, array)

        // Create icons for menu_navigation
        val planningIcon = IconicsDrawable(this, CommunityMaterial.Icon2.cmd_history)
        val homeIcon = IconicsDrawable(this, CommunityMaterial.Icon2.cmd_home)
        val calendarIcon = IconicsDrawable(this, CommunityMaterial.Icon.cmd_calendar)

        // Set icons
        binding.navigation.menu.apply {
            findItem(R.id.navigation_home).icon = planningIcon
            findItem(R.id.navigation_dashboard).icon = homeIcon
            findItem(R.id.navigation_notifications).icon = calendarIcon
        }

        // Automatically process all icons in menu
        binding.navigationAuto.menu.parseXmlAndSetIconicsDrawables(this, R.menu.menu_playground)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_playground, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private inner class IconsAdapter internal constructor(
        context: Context,
        objects: Array<IconicsDrawable>
    ) : ArrayAdapter<IconicsDrawable>(context, 0, objects) {

        private val inflater: LayoutInflater = LayoutInflater.from(context)

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = inflater.inflate(R.layout.row_icon_array, parent, false)
            val icon = v.findViewById<ImageView>(android.R.id.icon)
            icon.setImageDrawable(getItem(position))
            return v
        }
    }

    companion object {
        @BindingAdapter("iconicsSrc", "iconicsColor")
        @JvmStatic
        fun loadIconicsImage(view: ImageView, name: String, color: Int?) {
            view.setImageDrawable(IconicsDrawable(view.context, name).apply {
                if (color != null) {
                    colorInt = color
                }
            })
        }
    }
}

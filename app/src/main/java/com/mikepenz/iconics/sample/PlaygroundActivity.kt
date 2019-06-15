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
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsArrayBuilder
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.library.community.material.CommunityMaterial
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.octicons.Octicons
import com.mikepenz.iconics.utils.inflateWithIconics
import com.mikepenz.iconics.utils.paddingDp
import com.mikepenz.iconics.utils.parseXmlAndSetIconicsDrawables
import com.mikepenz.iconics.utils.sizeDp
import kotlinx.android.synthetic.main.activity_playground.list
import kotlinx.android.synthetic.main.activity_playground.navigation
import kotlinx.android.synthetic.main.activity_playground.navigation_auto
import kotlinx.android.synthetic.main.activity_playground.test1
import kotlinx.android.synthetic.main.activity_playground.test2
import kotlinx.android.synthetic.main.activity_playground.test3
import kotlinx.android.synthetic.main.activity_playground.test4
import kotlinx.android.synthetic.main.activity_playground.test5
import kotlinx.android.synthetic.main.activity_playground.test6
import kotlinx.android.synthetic.main.activity_playground.toolbar

class PlaygroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        // Handle Toolbar
        setSupportActionBar(toolbar)
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
                .on(test1)
                .build()

        //You can also do some advanced stuff like setting an image within a text
        val sb = SpannableString(test5.text)
        val d = IconicsDrawable(this, FontAwesome.Icon.faw_android)
                .sizeDp(48)
                .paddingDp(4)
        sb.setSpan(
            ImageSpan(d, DynamicDrawableSpan.ALIGN_BOTTOM),
            1,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        test5.text = sb

        //Set the icon of an ImageView (or something else) as drawable
        test2.setImageDrawable(
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up)
                    .size(IconicsSize.dp(48))
                    .color(IconicsColor.parse("#aaFF0000"))
                    .contourWidth(IconicsSize.dp(1))
        )

        //Set the icon of an ImageView (or something else) as bitmap
        test3.setImageBitmap(
            IconicsDrawable(this, FontAwesome.Icon.faw_android)
                    .sizeX(IconicsSize.dp(48))
                    .sizeY(IconicsSize.dp(32))
                    .padding(IconicsSize.dp(4))
                    .roundedCorners(IconicsSize.dp(8))
                    .color(IconicsColor.parse("#deFF0000"))
                    .toBitmap()
        )

        //Show how to style the text of an existing button
        Iconics.Builder()
                .style(BackgroundColorSpan(Color.BLACK))
                .style(RelativeSizeSpan(2f))
                .style(ForegroundColorSpan(Color.WHITE))
                .on(test4)
                .build()

        //Show how to style the text of an existing button
        val iconStateListDrawable = StateListDrawable()
        iconStateListDrawable.addState(
            intArrayOf(android.R.attr.state_pressed),
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up)
                    .size(IconicsSize.dp(48))
                    .color(IconicsColor.parse("#aaFF0000"))
                    .contourWidth(IconicsSize.dp(1))
        )
        iconStateListDrawable.addState(
            intArrayOf(),
            IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up)
                    .size(IconicsSize.dp(48))
                    .color(IconicsColor.parse("#aa00FF00"))
                    .contourWidth(IconicsSize.dp(2))
        )
        test6.setImageDrawable(iconStateListDrawable)

        val iconicsDrawableBase = IconicsDrawable(this)
                .actionBar()
                .color(IconicsColor.colorInt(Color.GREEN))
                .backgroundColor(IconicsColor.colorInt(Color.RED))
        val array = IconicsArrayBuilder(iconicsDrawableBase)
                .add(FontAwesome.Icon.faw_android)
                .add(Octicons.Icon.oct_octoface)
                .add("Hallo")
                .add('A')
                .add(";)")
                .build()

        list.adapter = IconsAdapter(this, array)

        // Create icons for menu_navigation
        val planningIcon = IconicsDrawable(this).icon(CommunityMaterial.Icon2.cmd_history)
        val homeIcon = IconicsDrawable(this).icon(CommunityMaterial.Icon2.cmd_home)
        val calendarIcon = IconicsDrawable(this).icon(CommunityMaterial.Icon.cmd_calendar)

        // Set icons
        navigation.menu.apply {
            findItem(R.id.navigation_home).icon = planningIcon
            findItem(R.id.navigation_dashboard).icon = homeIcon
            findItem(R.id.navigation_notifications).icon = calendarIcon
        }

        // Automatically process all icons in menu
        navigation_auto.menu.parseXmlAndSetIconicsDrawables(this, R.menu.menu_playground)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflateWithIconics(this, R.menu.menu_playground, menu)
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
}

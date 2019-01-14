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
import android.text.style.*
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.iconics.typeface.fonrawesome.FontAwesome
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsArrayBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.utils.IconicsMenuInflaterUtil
import com.mikepenz.iconics.typeface.octicons.Octicons


class PlaygroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        // Handle Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //Show how to style the text of an existing TextView
        val tv1 = findViewById<TextView>(R.id.test1)
        Iconics.IconicsBuilder().ctx(this)
                .style(ForegroundColorSpan(Color.WHITE), BackgroundColorSpan(Color.BLACK), RelativeSizeSpan(2f))
                .styleFor("faw-adjust", BackgroundColorSpan(Color.RED), ForegroundColorSpan(Color.parseColor("#33000000")), RelativeSizeSpan(2f))
                .on(tv1)
                .build()

        //You can also do some advanced stuff like setting an image within a text
        val tv2 = findViewById<TextView>(R.id.test5)
        val sb = SpannableString(tv2.text)
        val d = IconicsDrawable(this, FontAwesome.Icon.faw_android).sizeDp(48).paddingDp(4)
        sb.setSpan(ImageSpan(d, DynamicDrawableSpan.ALIGN_BOTTOM), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv2.text = sb

        //Set the icon of an ImageView (or something else) as drawable
        val iv2 = findViewById<ImageView>(R.id.test2)
        iv2.setImageDrawable(IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).sizeDp(48).color(Color.parseColor("#aaFF0000")).contourWidthDp(1))

        //Set the icon of an ImageView (or something else) as bitmap
        val iv3 = findViewById<ImageView>(R.id.test3)
        iv3.setImageBitmap(IconicsDrawable(this, FontAwesome.Icon.faw_android).sizeDpX(48).sizeDpY(32).paddingDp(4).roundedCornersDp(8).color(Color.parseColor("#deFF0000")).toBitmap())

        //Show how to style the text of an existing button
        val b4 = findViewById<Button>(R.id.test4)
        Iconics.IconicsBuilder().ctx(this)
                .style(BackgroundColorSpan(Color.BLACK))
                .style(RelativeSizeSpan(2f))
                .style(ForegroundColorSpan(Color.WHITE))
                .on(b4)
                .build()

        //Show how to style the text of an existing button
        val b6 = findViewById<ImageButton>(R.id.test6)
        val iconStateListDrawable = StateListDrawable()
        iconStateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).sizeDp(48).color(Color.parseColor("#aaFF0000")).contourWidthDp(1))
        iconStateListDrawable.addState(intArrayOf(), IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_up).sizeDp(48).color(Color.parseColor("#aa00FF00")).contourWidthDp(2))
        b6.setImageDrawable(iconStateListDrawable)

        val listView = findViewById<ListView>(R.id.list)

        val iconicsDrawableBase = IconicsDrawable(this).actionBar().color(Color.GREEN).backgroundColor(Color.RED)
        val array = IconicsArrayBuilder(iconicsDrawableBase)
                .add(FontAwesome.Icon.faw_android)
                .add(Octicons.Icon.oct_octoface)
                .add("Hallo")
                .add('A')
                .add(";)")
                .build()

        listView.adapter = IconsAdapter(this, array)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        IconicsMenuInflaterUtil.inflate(menuInflater, this, R.menu.menu_playground, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private inner class IconsAdapter internal constructor(context: Context, objects: Array<IconicsDrawable>) : ArrayAdapter<IconicsDrawable>(context, 0, objects) {

        private val mInflater: LayoutInflater

        init {
            mInflater = LayoutInflater.from(context)
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = mInflater.inflate(R.layout.row_icon_array, parent, false)

            val icon = v.findViewById<ImageView>(android.R.id.icon)
            icon.setImageDrawable(getItem(position))

            return v
        }
    }
}

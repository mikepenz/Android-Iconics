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

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.select.getSelectExtension
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.colorInt
import com.mikepenz.iconics.colorRes
import com.mikepenz.iconics.colorString
import com.mikepenz.iconics.paddingDp
import com.mikepenz.iconics.sample.item.TestItem
import com.mikepenz.iconics.typeface.library.community.material.CommunityMaterial
import kotlinx.android.synthetic.main.activity_playground.toolbar
import kotlinx.android.synthetic.main.icons_fragment.list

class TestActivity : AppCompatActivity() {
    private val adapter = FastItemAdapter<TestItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Handle Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Init and Setup RecyclerView
        list.apply {
            layoutManager = LinearLayoutManager(this@TestActivity)
            addItemDecoration(SpaceItemDecoration())
            itemAnimator = DefaultItemAnimator()
            adapter = this@TestActivity.adapter
        }

        adapter.getSelectExtension().isSelectable = true
        adapter.getSelectExtension().selectWithItemUpdate = true

        val icon = CommunityMaterial.Icon.cmd_circle_slice_8

        val states = arrayOf(
            intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(android.R.attr.state_selected)  // selected
        )
        val colors = intArrayOf(Color.BLUE, Color.RED)
        val colorStateList = ColorStateList(states, colors)

        // @formatter:off
        adapter.add(TestItem("Default", IconicsDrawable(this, icon)))
        adapter.add(TestItem("ColorInt (red)", IconicsDrawable(this, icon).colorInt(Color.RED)))
        adapter.add(TestItem("ColorRes (prim)", IconicsDrawable(this, icon).colorRes(R.color.colorPrimary)))
        adapter.add(TestItem("ColorStr (red)", IconicsDrawable(this, icon).colorString("#FF0000")))
        adapter.add(TestItem("#AAFF0000", IconicsDrawable(this, icon).colorString("#AAFF0000")))
        adapter.add(TestItem("Alpha(50%) (red)", IconicsDrawable(this, icon).colorInt(Color.RED).alpha(255/2)))
        adapter.add(TestItem("ColorStateList", IconicsDrawable(this, icon).color(IconicsColor.colorList(colorStateList))))

        adapter.add(TestItem("Padding 8dp", IconicsDrawable(this, icon).paddingDp(8)))
        adapter.add(TestItem("OffsetX 8dp", IconicsDrawable(this, icon).iconOffsetX(IconicsSize.dp(8))))
        adapter.add(TestItem("OffsetY 8dp", IconicsDrawable(this, icon).iconOffsetY(IconicsSize.dp(8))))
        adapter.add(TestItem("OffsetX/Y 8dp", IconicsDrawable(this, icon).iconOffsetX(IconicsSize.dp(8)).iconOffsetY(IconicsSize.dp(8))))
        adapter.add(TestItem("OffsetX/Y -8dp", IconicsDrawable(this, icon).iconOffsetX(IconicsSize.dp(-8)).iconOffsetY(IconicsSize.dp(-8))))

        adapter.add(TestItem("Background (red)", IconicsDrawable(this, icon).backgroundColor(IconicsColor.colorInt(Color.RED))))
        adapter.add(TestItem("Contour (red)(1dp)", IconicsDrawable(this, icon).contourColor(IconicsColor.colorInt(Color.RED)).contourWidth(IconicsSize.dp(1))))
        adapter.add(TestItem("!!?? BackgroundContour (red)(1dp)", IconicsDrawable(this, icon).backgroundContourColor(IconicsColor.colorInt(Color.RED)).backgroundContourWidth(IconicsSize.dp(1)).drawBackgroundContour(true)))

        adapter.add(TestItem("Background (CSL)", IconicsDrawable(this, icon).backgroundColor(IconicsColor.colorList(colorStateList))))
        adapter.add(TestItem("Contour (CSL)(1dp)", IconicsDrawable(this, icon).contourColor(IconicsColor.colorList(colorStateList)).contourWidth(IconicsSize.dp(1))))
        adapter.add(TestItem("!!?? BackgroundContour (CSL)(1dp)", IconicsDrawable(this, icon).backgroundContourColor(IconicsColor.colorList(colorStateList)).backgroundContourWidth(IconicsSize.dp(1)).drawBackgroundContour(true)))
        // @formatter:on
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

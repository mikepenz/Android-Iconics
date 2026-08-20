/*
 * Copyright (c) 2026 Mike Penz
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

import android.app.Activity
import android.view.Menu
import androidx.appcompat.view.menu.MenuBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.utils.IconicsMenuInflaterUtil
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * `menu_playground` covers the three relevant cases:
 * - `menu_item_1` has a plain `android:icon` and no `ico_*` attributes
 * - `menu_item_2` is defined via `ico_*` attributes
 * - `menu_item_3` has no icon at all
 */
@RunWith(RobolectricTestRunner::class)
class IconicsMenuInflaterUtilTest {

    private lateinit var activity: Activity
    private lateinit var menu: Menu

    @Before fun setUp() {
        activity = Robolectric.buildActivity(PlaygroundActivity::class.java).get()
        menu = MenuBuilder(activity)
    }

    @Test fun `iconics item gets an IconicsDrawable`() {
        IconicsMenuInflaterUtil.inflate(activity.menuInflater, activity, R.menu.menu_playground, menu)

        assertTrue(menu.findItem(R.id.menu_item_2).icon is IconicsDrawable)
    }

    @Test fun `non-iconics item keeps its android icon`() {
        activity.menuInflater.inflate(R.menu.menu_playground, menu)
        val original = menu.findItem(R.id.menu_item_1).icon
        assertNotNull("menu_item_1 is expected to declare an android:icon", original)

        IconicsMenuInflaterUtil.parseXmlAndSetIconicsDrawables(activity, R.menu.menu_playground, menu)

        assertSame(
            "an item without ico_* attributes must keep the drawable of its android:icon",
            original,
            menu.findItem(R.id.menu_item_1).icon
        )
    }

    @Test fun `item without any icon stays without one`() {
        IconicsMenuInflaterUtil.inflate(activity.menuInflater, activity, R.menu.menu_playground, menu)

        assertNull(menu.findItem(R.id.menu_item_3).icon)
    }
}

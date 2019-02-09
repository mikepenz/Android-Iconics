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

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialize.util.KeyboardUtil
import java.util.Collections
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var mIconsFragment: IconsFragment? = null
    private var mRandomize: Boolean = false
    private var mShadow: Boolean = false
    private var mFonts: List<ITypeface>? = null
    private var mIdentifierGmd = 0
    private var mCurrentSearch: String? = null
    private var mDrawer: Drawer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        //order fonts by their name
        mFonts = ArrayList(Iconics.registeredFonts)
        Collections.sort(mFonts!!) { object1, object2 -> object1.fontName.compareTo(object2.fontName) }

        //add all icons of all registered Fonts to the list
        val items = ArrayList<IDrawerItem<*>>(Iconics.registeredFonts.size)
        var count = 0
        for (font in mFonts!!) {
            val pdi = PrimaryDrawerItem()
                    .withName(font.fontName)
                    .withBadge("" + font.icons.size)
                    .withDescription(if (TextUtils.isEmpty(font.author)) font.version else font.version + " - " + font.author)
                    .withBadgeStyle(BadgeStyle().withColorRes(R.color.md_grey_200))
                    .withIcon(getRandomIcon(font))
                    .withIdentifier(count.toLong())

            if (font.mappingPrefix == "gmd") {
                mIdentifierGmd = count
            }
            items.add(pdi)
            count++
        }

        mDrawer = DrawerBuilder().withActivity(this)
                .withToolbar(toolbar)
                .withDrawerItems(items)
                .withOnDrawerItemClickListener { view, i, iDrawerItem ->
                    loadIcons(mFonts!![i].fontName)
                    supportActionBar!!.title = mFonts!![i].fontName

                    false
                }
                .withOnDrawerListener(object : Drawer.OnDrawerListener {
                    override fun onDrawerOpened(drawerView: View) {
                        KeyboardUtil.hideKeyboard(this@MainActivity)
                    }

                    override fun onDrawerClosed(drawerView: View) {}

                    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}
                })
                .withFireOnInitialOnClick(true)
                .withSelectedItem(mIdentifierGmd.toLong())
                .build()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu items for use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        //
        menu.findItem(R.id.search).setIcon(
            IconicsDrawable(
                this,
                MaterialDesignIconic.Icon.gmi_search
            )
                    .color(IconicsColor.colorInt(Color.WHITE))
                    .size(IconicsSize.dp(24f))
                    .respectFontBounds(true)
        )

        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String): Boolean {
                search(s)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                search(s)
                return true
            }

            private fun search(s: String) {
                mCurrentSearch = s

                if (mDrawer != null) {
                    var count = 0
                    for (font in mFonts!!) {
                        var foundCount = 0
                        if (font.icons != null) {
                            for (icon in font.icons) {
                                if (icon.toLowerCase().contains(s.toLowerCase())) {
                                    foundCount++
                                }
                            }
                        }
                        mDrawer!!.updateBadge(
                            count.toLong(),
                            StringHolder(foundCount.toString() + "")
                        )

                        count++
                    }
                }

                //filter out the current fragment
                if (mIconsFragment != null) mIconsFragment!!.onSearch(s)
            }
        })

        val menuItem = menu.findItem(R.id.action_opensource)
        menuItem.setIcon(
            IconicsDrawable(this, FontAwesome.Icon.faw_github)
                    .actionBar()
                    .color(IconicsColor.colorInt(Color.WHITE))
        )
        return super.onCreateOptionsMenu(menu)
    }

    private fun getRandomIcon(typeface: ITypeface): IIcon {
        val random = Random().nextInt(typeface.icons.size)
        val icons = typeface.icons.iterator()
        for (i in 1 until random) {
            icons.next()
        }
        return typeface.getIcon(icons.next())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        when (item.itemId) {
            R.id.action_randomize -> {
                item.isChecked = !item.isChecked
                mIconsFragment!!.randomize(item.isChecked)
                mRandomize = item.isChecked
                return true
            }
            R.id.action_shadow -> {
                item.isChecked = !item.isChecked
                mIconsFragment!!.shadow(item.isChecked)
                mShadow = item.isChecked
                return true
            }
            R.id.action_opensource -> {
                LibsBuilder()
                        .withFields(R.string::class.java!!.getFields())
                        .withLicenseShown(true)
                        .withActivityTitle(getString(R.string.action_opensource))
                        .withActivityTheme(R.style.AppTheme)
                        .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                        .start(this@MainActivity)

                return true
            }
            R.id.action_playground -> {
                startActivity(Intent(applicationContext, PlaygroundActivity::class.java))
                return true
            }
            R.id.action_automatic -> {
                startActivity(Intent(applicationContext, AutomaticActivity::class.java))
                return true
            }
            R.id.action_old_automatic -> {
                startActivity(Intent(applicationContext, OldAutomaticActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun loadIcons(fontName: String) {
        val ft = supportFragmentManager.beginTransaction()
        mIconsFragment = IconsFragment.newInstance(fontName)
        mIconsFragment!!.randomize(mRandomize)
        mIconsFragment!!.shadow(mShadow)
        mIconsFragment!!.onSearch(mCurrentSearch)
        ft.replace(R.id.content, mIconsFragment!!)
        ft.commit()
    }
}

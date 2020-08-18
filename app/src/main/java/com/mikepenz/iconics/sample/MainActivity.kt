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

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.aboutlibraries.util.getThemeColor
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic
import com.mikepenz.iconics.utils.actionBar
import com.mikepenz.iconics.utils.colorInt
import com.mikepenz.iconics.utils.paddingDp
import com.mikepenz.iconics.utils.sizeDp
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.util.updateBadge
import kotlinx.android.synthetic.main.activity_main.root
import kotlinx.android.synthetic.main.activity_main.slider
import kotlinx.android.synthetic.main.activity_main.toolbar
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private lateinit var fonts: List<ITypeface>
    private var iconsFragment: IconsFragment? = null
    private var isRandomize: Boolean = false
    private var isShadowEnabled: Boolean = false
    private var identifierGmd = 0
    private var currentSearch: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, root, toolbar, R.string.material_drawer_open, R.string.material_drawer_close)

        //order fonts by their name
        fonts = Iconics.getRegisteredFonts(this).sortedBy { it.fontName }

        //add all icons of all registered Fonts to the list
        val items = ArrayList<IDrawerItem<*>>(fonts.size)
        fonts.forEachIndexed { index, font ->
            val pdi = PrimaryDrawerItem().apply {
                name = StringHolder(font.fontName)
                badge = StringHolder(font.icons.size.toString())
                description = StringHolder(if (font.author.isEmpty()) font.version else font.version + " - " + font.author)
                identifier = index.toLong()
                badgeStyle = BadgeStyle().apply {
                    color = ColorHolder.fromColor(getThemeColor(R.attr.colorBackgroundFloating))
                    textColor = ColorHolder.fromColor(getThemeColor(R.attr.colorOnBackground))
                }
                icon = ImageHolder(IconicsDrawable(this@MainActivity, getRandomIcon(font)).apply {
                    colorList = ColorStateList.valueOf(getThemeColor(android.R.attr.textColorPrimary))
                    sizeDp = 24
                    paddingDp = 1
                })
            }
            if (font.mappingPrefix == "gmd") {
                identifierGmd = index
            }
            items.add(pdi)
        }

        root.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {}

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerOpened(drawerView: View) {
                val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        })
        slider.onDrawerItemClickListener = { v, item, position ->
            fonts[position].fontName.also {
                loadIcons(it)
                supportActionBar?.title = it
            }
            false
        }
        slider.itemAdapter.add(items)
        slider.setSelection(identifierGmd.toLong(), true)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu items for use in the action bar
        menuInflater.inflate(R.menu.menu_main, menu)

        //
        menu.findItem(R.id.search).icon = IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_search).apply {
            colorInt = Color.WHITE
            sizeDp = 24
            respectFontBounds = true
        }

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
                currentSearch = s

                fonts.forEachIndexed { index, font ->
                    val foundCount = font.icons.count { it.contains(s, true) }
                    slider.updateBadge(index.toLong(), StringHolder(foundCount.toString()))
                }

                //filter out the current fragment
                iconsFragment?.onSearch(s)
            }
        })

        val menuItem = menu.findItem(R.id.action_opensource)
        menuItem.icon = IconicsDrawable(this, FontAwesome.Icon.faw_github).apply {
            actionBar()
            colorInt = Color.WHITE
        }

        return super.onCreateOptionsMenu(menu)
    }

    private fun getRandomIcon(typeface: ITypeface): IIcon {
        val random = Random().nextInt(typeface.icons.size)
        val icon = typeface.icons.toList()[random]
        return typeface.getIcon(icon)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }

        // Handle presses on the action bar items
        when (item.itemId) {
            R.id.action_randomize -> {
                item.isChecked = !item.isChecked
                iconsFragment?.randomize(item.isChecked)
                isRandomize = item.isChecked
                return true
            }
            R.id.action_shadow -> {
                item.isChecked = !item.isChecked
                iconsFragment?.shadow(item.isChecked)
                isShadowEnabled = item.isChecked
                return true
            }
            R.id.action_opensource -> {
                LibsBuilder()
                        .withFields(R.string::class.java.fields)
                        .withLicenseShown(true)
                        .withActivityTitle(getString(R.string.action_opensource))
                        .withEdgeToEdge(true)
                        .start(this@MainActivity)

                return true
            }
            R.id.action_playground -> {
                startActivity(Intent(applicationContext, PlaygroundActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun loadIcons(fontName: String) {
        supportFragmentManager.beginTransaction().also {
            val iconsFragment = IconsFragment.newInstance(fontName).apply {
                randomize(isRandomize)
                shadow(isShadowEnabled)
                onSearch(currentSearch)
            }
            it.replace(R.id.content, iconsFragment)
            it.commit()
            this.iconsFragment = iconsFragment
        }
    }
}

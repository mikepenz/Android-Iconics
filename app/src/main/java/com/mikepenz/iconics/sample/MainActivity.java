/*
 * Copyright 2014 Mike Penz
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

package com.mikepenz.iconics.sample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.KeyboardUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private IconsFragment mIconsFragment;
    private boolean mRandomize;
    private List<ITypeface> mFonts;
    private int mIdentifierGmd = 0;
    private String mCurrentSearch = null;
    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //order fonts by their name
        mFonts = new ArrayList<>(Iconics.getRegisteredFonts(this));
        Collections.sort(mFonts, new Comparator<ITypeface>() {
            @Override
            public int compare(final ITypeface object1, final ITypeface object2) {
                return object1.getFontName().compareTo(object2.getFontName());
            }
        });

        //add all icons of all registered Fonts to the list
        ArrayList<IDrawerItem> items = new ArrayList<>(Iconics.getRegisteredFonts(this).size());
        int count = 0;
        for (ITypeface font : mFonts) {
            PrimaryDrawerItem pdi = new PrimaryDrawerItem()
                    .withName(font.getFontName())
                    .withBadge("" + font.getIcons().size())
                    .withDescription(TextUtils.isEmpty(font.getAuthor()) ? font.getVersion() : font.getVersion() + " - " + font.getAuthor())
                    .withBadgeStyle(
                            new BadgeStyle().withColorRes(R.color.md_grey_200)
                    )
                    .withIcon(
                            getRandomIcon(font)
                    )
                    .withIdentifier(count);

            if (font.getMappingPrefix().equals("gmd")) {
                mIdentifierGmd = count;
            }
            items.add(pdi);
            count++;
        }

        mDrawer = new DrawerBuilder().withActivity(this)
                .withToolbar(toolbar)
                .withDrawerItems(items)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                        loadIcons(mFonts.get(i).getFontName());
                        getSupportActionBar().setTitle(mFonts.get(i).getFontName());

                        return false;
                    }
                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        KeyboardUtil.hideKeyboard(MainActivity.this);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSelectedItem(mIdentifierGmd)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //
        menu.findItem(R.id.search).setIcon(new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_search).color(Color.WHITE).sizeDp(24).respectFontBounds(true));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    search(s);
                    return true;
                }


                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }


                private void search(String s) {
                    mCurrentSearch = s;

                    if (mDrawer != null) {
                        int count = 0;
                        for (ITypeface font : mFonts) {
                            int foundCount = 0;
                            if (font.getIcons() != null) {
                                for (String icon : font.getIcons()) {
                                    if (icon.toLowerCase().contains(s.toLowerCase())) {
                                        foundCount++;
                                    }
                                }
                            }
                            mDrawer.updateBadge(count, new StringHolder(foundCount + ""));

                            count++;
                        }
                    }

                    //filter out the current fragment
                    if (mIconsFragment != null) mIconsFragment.onSearch(s);
                }
            });
        } else {
            menu.findItem(R.id.search).setVisible(false);
        }

        MenuItem menuItem = menu.findItem(R.id.action_opensource);
        menuItem.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_github).actionBar().color(Color.WHITE));
        return super.onCreateOptionsMenu(menu);
    }

    private IIcon getRandomIcon(ITypeface typeface) {
        int random = new Random().nextInt(typeface.getIcons().size());
        Iterator<String> icons = typeface.getIcons().iterator();
        for (int i = 1; i < random; i++) {
            icons.next();
        }
        return typeface.getIcon(icons.next());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_randomize:
                item.setChecked(!item.isChecked());
                mIconsFragment.randomize(item.isChecked());
                mRandomize = item.isChecked();
                return true;
            case R.id.action_opensource:
                new LibsBuilder()
                        .withFields(R.string.class.getFields())
                        .withLicenseShown(true)
                        .withActivityTitle(getString(R.string.action_opensource))
                        .withActivityTheme(R.style.AppTheme)
                        .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                        .start(MainActivity.this);

                return true;
            case R.id.action_playground:
                startActivity(new Intent(getApplicationContext(), PlaygroundActivity.class));
                return true;
            case R.id.action_automatic:
                startActivity(new Intent(getApplicationContext(), AutomaticActivity.class));
                return true;
            case R.id.action_old_automatic:
                startActivity(new Intent(getApplicationContext(), OldAutomaticActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void loadIcons(String fontName) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        mIconsFragment = IconsFragment.newInstance(fontName);
        mIconsFragment.randomize(mRandomize);
        mIconsFragment.onSearch(mCurrentSearch);
        ft.replace(R.id.content, mIconsFragment);
        ft.commit();
    }
}

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
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.ui.LibsActivity;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.sample.adapter.IconAdapter;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.BaseDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ArrayList<IDrawerItem> items = new ArrayList<>(Iconics.getRegisteredFonts().size());
        //add all icons of all registered Fonts to the list
        for (ITypeface font : Iconics.getRegisteredFonts()) {
            items.add(new PrimaryDrawerItem().withName(font.getFontName()));
        }

        new Drawer().withActivity(this)
                .withToolbar(toolbar)
                .withDrawerItems(items)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        ITypeface font = new ArrayList<>(Iconics.getRegisteredFonts()).get(i);
                        loadIcons(font.getFontName());

                    }
                })
        .withSelectedItem(0)
        .build();

        String fontName = new ArrayList<>(Iconics.getRegisteredFonts()).get(0).getFontName();
        loadIcons(fontName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_opensource);
        menuItem.setIcon(new IconicsDrawable(this, FontAwesome.Icon.faw_github).actionBar().color(Color.WHITE));
        //menuItem.setIcon(new IconicsDrawable(this, "faw-github").actionBarSize().color(Color.WHITE));


        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_opensource:
                //Create an intent with context and the Activity class
                Intent i = new Intent(getApplicationContext(), LibsActivity.class);
                //Pass the fields of your application to the lib so it can find all external lib information
                i.putExtra(Libs.BUNDLE_FIELDS, Libs.toStringArray(R.string.class.getFields()));

                //Display the library license (OPTIONAL
                i.putExtra(Libs.BUNDLE_LICENSE, true);

                //Set a title (OPTIONAL)
                i.putExtra(Libs.BUNDLE_TITLE, getString(R.string.action_opensource));

                //Pass your theme (OPTIONAL)
                i.putExtra(Libs.BUNDLE_THEME, R.style.AboutTheme);

                //start the activity
                startActivity(i);
                return true;
            case R.id.action_playground:
                Intent ip = new Intent(getApplicationContext(), PlaygroundActivity.class);
                startActivity(ip);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadIcons(String fontName) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, IconsFragment.newInstance(fontName));
        ft.commit();
    }
}

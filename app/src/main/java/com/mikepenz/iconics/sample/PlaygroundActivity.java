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

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsArrayBuilder;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.octicons_typeface_library.Octicons;


public class PlaygroundActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        //Show how to style the text of an existing TextView
        TextView tv1 = (TextView) findViewById(R.id.test1);
        new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor("faw-adjust", new BackgroundColorSpan(Color.RED), new ForegroundColorSpan(Color.parseColor("#33000000")), new RelativeSizeSpan(2f))
                .on(tv1)
                .build();

        //You can also do some advanced stuff like setting an image within a text
        TextView tv2 = (TextView) findViewById(R.id.test5);
        SpannableString sb = new SpannableString(tv2.getText());
        IconicsDrawable d = new IconicsDrawable(this, FontAwesome.Icon.faw_android).sizeDp(48).paddingDp(4);
        sb.setSpan(new ImageSpan(d, DynamicDrawableSpan.ALIGN_BOTTOM), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv2.setText(sb);

        //Set the icon of an ImageView (or something else) as drawable
        ImageView iv2 = (ImageView) findViewById(R.id.test2);
        iv2.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_o_up).sizeDp(48).color(Color.parseColor("#aaFF0000")).contourWidthDp(1));

        //Set the icon of an ImageView (or something else) as bitmap
        ImageView iv3 = (ImageView) findViewById(R.id.test3);
        iv3.setImageBitmap(new IconicsDrawable(this, FontAwesome.Icon.faw_android).sizeDpX(48).sizeDpY(32).paddingDp(4).roundedCornersDp(8).color(Color.parseColor("#deFF0000")).toBitmap());

        //Show how to style the text of an existing button
        Button b4 = (Button) findViewById(R.id.test4);
        new Iconics.IconicsBuilder().ctx(this)
                .style(new BackgroundColorSpan(Color.BLACK))
                .style(new RelativeSizeSpan(2f))
                .style(new ForegroundColorSpan(Color.WHITE))
                .on(b4)
                .build();

        //Show how to style the text of an existing button
        ImageButton b6 = (ImageButton) findViewById(R.id.test6);
        StateListDrawable iconStateListDrawable = new StateListDrawable();
        iconStateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_o_up).sizeDp(48).color(Color.parseColor("#aaFF0000")).contourWidthDp(1));
        iconStateListDrawable.addState(new int[]{}, new IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_o_up).sizeDp(48).color(Color.parseColor("#aa00FF00")).contourWidthDp(2));
        b6.setImageDrawable(iconStateListDrawable);

        ListView listView = (ListView) findViewById(R.id.list);

        IconicsDrawable iconicsDrawableBase = new IconicsDrawable(this).actionBar().color(Color.GREEN).backgroundColor(Color.RED);
        IconicsDrawable[] array = new IconicsArrayBuilder(iconicsDrawableBase)
                .add(FontAwesome.Icon.faw_android)
                .add(Octicons.Icon.oct_octoface)
                .add("Hallo")
                .add('A')
                .add(";)")
                .build();

        listView.setAdapter(new IconsAdapter(this, array));

    }

    private class IconsAdapter extends ArrayAdapter<IconicsDrawable> {

        private final LayoutInflater mInflater;

        public IconsAdapter(Context context, IconicsDrawable[] objects) {
            super(context, 0, objects);
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = mInflater.inflate(R.layout.row_icon_array, parent, false);

            ImageView icon = (ImageView) v.findViewById(android.R.id.icon);
            icon.setImageDrawable(getItem(position));

            return v;
        }
    }
}

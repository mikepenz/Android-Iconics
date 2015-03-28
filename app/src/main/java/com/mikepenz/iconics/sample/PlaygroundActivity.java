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
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.FontAwesome;


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
        iv3.setImageBitmap(new IconicsDrawable(this, new FontAwesome(), FontAwesome.Icon.faw_android).color(Color.parseColor("#deFF0000")).toBitmap());

        //Show how to style the text of an existing button (NOT WORKING AT THE MOMENT)
        Button b4 = (Button) findViewById(R.id.test4);
        new Iconics.IconicsBuilder().ctx(this)
                .style(new BackgroundColorSpan(Color.BLACK))
                .style(new RelativeSizeSpan(2f))
                .style(new ForegroundColorSpan(Color.WHITE))
                .on(b4)
                .build();
    }
}

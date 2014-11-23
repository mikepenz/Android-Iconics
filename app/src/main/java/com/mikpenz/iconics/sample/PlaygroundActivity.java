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

package com.mikpenz.iconics.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikpenz.iconics.Iconics;
import com.mikpenz.iconics.IconicsDrawable;
import com.mikpenz.iconics.typeface.FontAwesome;


public class PlaygroundActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        TextView tv1 = (TextView) findViewById(R.id.test1);
        new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor("faw-adjust", new BackgroundColorSpan(Color.RED))
                .on(tv1)
                .build();

        ImageView iv2 = (ImageView) findViewById(R.id.test2);

        iv2.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_thumbs_o_up).sizeDp(48).contourColor(Color.RED).contourWidthDp(1));

        ImageView iv3 = (ImageView) findViewById(R.id.test3);
        iv3.setImageBitmap(new IconicsDrawable(this, new FontAwesome(), FontAwesome.Icon.faw_android).color(Color.GREEN).toBitmap());

        Button b4 = (Button) findViewById(R.id.test4);
        new Iconics.IconicsBuilder().ctx(this)
                .style(new BackgroundColorSpan(Color.BLACK))
                .style(new RelativeSizeSpan(2f))
                .style(new ForegroundColorSpan(Color.WHITE))
                .on(b4)
                .build();
    }
}

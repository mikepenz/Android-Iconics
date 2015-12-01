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
import android.os.Bundle;
import android.widget.TextView;

import com.mikepenz.iconics.context.IconicsContextWrapper;


public class OldAutomaticActivity extends Activity {
    @Override
    protected void attachBaseContext(Context newBase) {
        //not compatible with Calligraphy
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);

        //set a new text on the textView and set the icon font on it
        ((TextView) findViewById(R.id.test4)).setText("{gmd-favorite} GIF");
    }
}

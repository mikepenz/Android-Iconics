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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import com.mikepenz.iconics.context.IconicsLayoutInflater2
import kotlinx.android.synthetic.main.activity_automatic.test4
import kotlinx.android.synthetic.main.activity_automatic.toolbar

class AutomaticActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //define the IconicsLayoutInflater
        //this is compatible with calligraphy and other libs which wrap the baseContext
        LayoutInflaterCompat.setFactory2(layoutInflater, IconicsLayoutInflater2(delegate))

        //call super.onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_automatic)

        // Handle Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //set a new text on the textView and set the icon font on it
        test4.text = "{gmd-favorite} GIF"
    }
}

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


import androidx.multidex.MultiDexApplication
import com.mikepenz.iconics.sample.typeface.CustomFont
import com.mikepenz.iconics.ver_four.Iconics
import com.mikepenz.iconics.ver_four.typeface.GenericFont

class CustomApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        //register custom fonts like this (or also provide a font definition file)
        Iconics.markInitDone()
        Iconics.registerFont(CustomFont())
        Iconics.init(this)

        //Generic font creation process
        val gf2 = GenericFont(
                    "GenericFont",
                    "SampleGenericFont",
                    "gmf",
                    "font/materialdrawerfont.ttf"
                )
        gf2.registerIcon("person", '\ue800')
        gf2.registerIcon("up", '\ue801')
        gf2.registerIcon("down", '\ue802')
        Iconics.registerFont(gf2)

        //Enable the below line to not allow the automatic font detection via the included string fields. This helps to increase performance by a tiny bit.
        //Iconics.markInitDone();
    }

}

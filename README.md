#Android-Iconics  [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.mikepenz/iconics-core/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.mikepenz/iconics-core) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--Iconics-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1164)

![Image](https://raw.githubusercontent.com/mikepenz/Android-Iconics/feature/next-generation/DEV/github/banner.png)

> If you are an app developer you will know the problem. You start an app but require many different icons, in different sizes (**ldpi, mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi**), **different colors**, and **different variants**.
If you get the icons as **vector** (.svg) or there are many changes over the time, you will always have to get the correct drawables again.

> **This consumes a lot of time!**

Now there's an **easy, fast, and small** solution for this! The **Android-Iconics** library.

This library allows you to include vector icons everywhere in your project. No limits are given.
**Scale with no limit**, use **any Color** at any time, provide a **contour**, and many additional customizations...

Use the icons in the variation you need them.

**What do you get**
- No customization limitations (size, color, contour, background, padding, positioning, ...)
- One icon source (no more mdpi, hdpi, ...)
- Flexibility
- If it takes an Drawable, it will also work with the IconicsDrawable!
- Save in APK size

**Already available fonts**
- FontAwesome
- Material Design Icons
- Meteocons
- Octicons
- Community Material Icons

**Need more?**
Provide additional fonts for you project, or even create your custom font with just the icons you need.

#Migration
- [MIGRATION GUIDE](https://github.com/mikepenz/Android-Iconics/blob/develop/MIGRATION.md)

#Setup

##1. Provide the gradle dependency
```gradle
dependencies {
	compile 'com.mikepenz:iconics-core:2.2.0@aar'
}
```

##2. Choose your desired fonts
```gradle
compile 'com.mikepenz:google-material-typeface:2.2.0.1@aar'
compile 'com.mikepenz:fontawesome-typeface:4.4.0.1@aar'
compile 'com.mikepenz:octicons-typeface:3.2.0.1@aar'
compile 'com.mikepenz:meteocons-typeface:1.1.0.1@aar'
compile 'com.mikepenz:community-material-typeface:1.2.65.1@aar'
compile 'com.mikepenz:weather-icons-typeface:2.0.10.1@aar'
compile 'com.mikepenz:typeicons-typeface:2.0.7.1@aar'
compile 'com.mikepenz:entypo:1.0.0.1@aar'
```

##3. Inject into Context (optional)
Wrap the `Activity` context. This will enable automatic icon detection for `TextViews`,`Buttons`, and allow you to set icons on `ImageView`'s via xml.
```java
@Override
protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
}
```

#Usage
##Use as drawable

```java
new IconicsDrawable(this)
    .icon(FontAwesome.Icon.faw_android)
    .color(Color.RED)
    .sizeDp(24)
```

##Use via XML

If you use the Iconics library via XML provide the icon you want to use in the following syntax: `gmd-favorite` --> `fontId`-`iconName`. A list of the
available fonts and their `fontId` can be found near the end of the README.md
All icon names from the default fonts can be found via the [DEMO](https://play.google.com/store/apps/details?id=com.mikepenz.iconics.sample) application.

####Notation within text
Use the `{` icon-definer `}` syntax
```gson
Some great text with a {faw-android} font awesome icon and {met-wind} meteocons icons.
```

###As ImageView (only available if you inject the context)
```xml
<ImageView
    android:layout_width="48dp"
    android:layout_height="48dp"
    app:ico_color="@color/md_red_A200"
    app:ico_icon="gmd-plus-circle"
    app:ico_size="48dp" />
    
    //other possible attributes
    //app:ico_background_color="@android:color/transparent"
    //app:ico_color="@color/md_red_100"
    //app:ico_contour_color="@android:color/transparent"
    //app:ico_contour_width="0dp"
    //app:ico_corner_radius="0dp"
    //app:ico_icon="gmd-plus-circle"
    //app:ico_offset_x="0dp"
    //app:ico_offset_y="0dp"
    //app:ico_padding="0dp"
    //app:ico_size="48dp"
```
###As TextView (only available if you inject the context)
```xml
<TextView
    android:text="{gmd-chart} Chart"
    android:textColor="@android:color/black"
    android:layout_width="wrap_content"
    android:layout_height="56dp"
    android:textSize="16sp"/>
```

###Custom Views (if you do NOT inject the context)
####As IconicsImageView
```xml
<com.mikepenz.iconics.view.IconicsImageView
    android:layout_width="72dp"
    android:layout_height="72dp"
    app:iiv_color="@android:color/holo_red_dark"
    app:iiv_icon="gmd-favorite" />
```

####As IconicsTextView
```xml
<com.mikepenz.iconics.view.IconicsTextView
        android:text="abc{hif-test}defgh{faw-adjust}ijk{fon-test1}lmnopqrstuv{fon-test2}wxyz"
        android:textColor="@android:color/black"
        android:layout_width="wrap_content"
        android:layout_height="56dp"
        android:textSize="16sp"/>
```

####As IconicsButton
```xml
<com.mikepenz.iconics.view.IconicsButton
        android:text="{faw-adjust} Button"
        android:layout_width="120dp"
        android:layout_height="60dp"/>
```


#Screenshots

![Image](https://raw.githubusercontent.com/mikepenz/Android-Iconics/develop/DEV/github/screenshots1.jpg)


#Available fonts
* [Google Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font) - [Google Material Design Icons](https://github.com/google/material-design-icons)
  * "gmd"
  * compile 'com.mikepenz:google-material-typeface:2.2.0.1@aar'
* [Fontawesome](http://fontawesome.io)
  * "faw"
  * compile 'com.mikepenz:fontawesome-typeface:4.4.0.1@aar'
* [Meteocons](http://www.alessioatzeni.com/meteocons/)
  * "met"
  * compile 'com.mikepenz:meteocons-typeface:+@aar'
* [Octicons](https://github.com/github/octicons)
  * "oct"
  * compile 'com.mikepenz:octicons-typeface:+@aar'
* [Community Material](http://materialdesignicons.com/)
  * "cmd"
  * compile 'com.mikepenz:community-material-typeface:+@aar'
* [Weather Icons](https://erikflowers.github.io/weather-icons/)
  * "wic"
  * compile 'com.mikepenz:weather-icons-typeface:+@aar'
* [Typeicons](http://typicons.com/)
  * "typ"
  * compile 'com.mikepenz:typeicons-typeface:+@aar'
* [Entypo](http://www.entypo.com/)
  * "ent"
  * compile 'com.mikepenz:entypo:+@aar'


#Advanced Usage

###Register fonts

If you want to add your own custom font, or a GenericFont you have to register this font (before using it). The best place to do this is the `Application`.
```java
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new CustomFont());
    }
}

```

###Advanced IconicsBuilder
Everything is easy and simple. Right? But now you got a single icon within your textview and you need additional styling?
Just define the style for all icons or only a specific one. You can find this in the PlaygroundActivity of the sample too.
```java
new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(FontAwesome.Icon.faw_adjust, new BackgroundColorSpan(Color.RED))
                .on(tv1)
                .build();
```

###String icon-key or typeface enum
Sometimes you won't like to use the icon-key ("faw-adjust") like this, but use the enum provided by a specific font. Both is valid:
```java
  new IconicsDrawable(this, "faw-adjust").actionBarSize()
```
```java
  new IconicsDrawable(this, FontAwesome.Icon.faw_adjust).sizeDp(24)
```


##Create custom fonts
This is possible with only the *.ttf and *.css mapping file. And will take you 2 minutes.

You can get these two files by downloading a web icon font, or if you want to create your
own custom icon font from *.svg files then you can use following tools:
* [Fontello](http://fontello.com)
* [IcoMoon](http://icomoon.io) 
* let me know if you find other tools.

After you got those two files, head over to the icon addon creation tool [android-iconics.mikepenz.com](http://android-iconics.mikepenz.com).
Enter all the information. Add the *.ttf and *.css and click the button. It will generate and download the icon font addon as
zip. (this tool is local only, no files are sent to a server, you can safely use it with any icons)

#ProGuard
Exclude `R` from ProGuard to enable the font addon auto detection
```proguard
-keep class .R
-keep class **.R$* {
    <fields>;
}
```
All other ProGuard rules are now bundled internally with each font. 

#Demo
You can try the sample application out. It's on Google Play ;)
https://play.google.com/store/apps/details?id=com.mikepenz.iconics.sample


#Credits
- [Joan Zapata](https://github.com/JoanZapata) He is the creator of [Android-Iconify](https://github.com/JoanZapata/android-iconify) which gave me the idea of this project. Some core concepts and ideas were reused, but everything is written from scratch.
- [Christopher Jenkins](https://github.com/chrisjenx/) Thanks for the great usage of a custom `ContextWrapper` inside [Calligraphy](https://github.com/chrisjenx/Calligraphy/)

#Developed By

* Mike Penz - http://mikepenz.com - <mikepenz@gmail.com>


#License

    Copyright 2015 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



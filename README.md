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


> UPGRADE < v2.0.0
>* there is now a core package which comes without included fonts
>* provide the fonts you need. no additional steps required


#Setup

##1. Provide the gradle dependency
```gradle
dependencies {
	compile 'com.mikepenz:iconics-core:1.7.2@aar'
}
```

##2. Choose your desired fonts
```gradle
compile 'com.mikepenz:google-material-typeface:1.2.0@aar'
compile 'com.mikepenz:fontawesome-typeface:4.4.0@aar'
compile 'com.mikepenz:octicons-typeface:3.0.1@aar'
compile 'com.mikepenz:meteocons-typeface:1.1.3@aar'
compile 'com.mikepenz:community-material-typeface:1.1.72@aar'
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

###As ImageView
```xml
<com.mikepenz.iconics.view.IconicsImageView
    android:layout_width="72dp"
    android:layout_height="72dp"
    app:iiv_color="@android:color/holo_red_dark"
    app:iiv_icon="gmd-favorite" />
```

###As Text

To use the icon within text use the `{` icon-definer `}` syntax

```gson
Some great text with a {faw-android} font awesome icon and {met-wind} meteocons icons.
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
* [Fontawesome](http://fontawesome.io)
  * "faw"
  * DEFAULT
* [Google Material Design Icons](https://github.com/google/material-design-icons)
  * "gmd"
  * DEFAULT
* [Meteocons](http://www.alessioatzeni.com/meteocons/)
  * "met"
  * compile 'com.mikepenz.iconics:meteocons-typeface:+@aar'
* [Octicons](https://github.com/github/octicons)
  * "oct"
  * compile 'com.mikepenz.iconics:octicons-typeface:+@aar'
* [Community Material](http://materialdesignicons.com/)
  * "cmd"
  * compile 'com.mikepenz.iconics:community-material-typeface:+@aar'


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


###Create custom fonts using [Fontello](http://fontello.com) or [IcoMoon](http://icomoon.io)

If you plan to use an existing icon font, one provided by your design team, or if you have an svg and want to use it as drawable just follow those simple steps.

####1. Create the icon font (not required if you already have one)
Open [Fontello](http://fontello.com) or [IcoMoon](http://icomoon.io) and select the icons you need. Add your vectors (.svg) and then just download the font.

####1.2. Add the font to your project
- Unpack the .zip you just downloaded and add the *.ttf to your project under `src/main/assets/fonts`
- In the next step you will have to know the unicode value for the icons
 - this information can be found in the `fontello-codes.css` (if you used fontello)
 - or in the style.css (if you used icomoon)

####2. Implement your CustomFont
- Great you got your IconFont and you know which unicode character displays which icon. Now you can create your own font with it. You have to options 2.1. or 2.2.

#####2.1. Implement as GenericFont
- To implement a GenericFont just provide the mapping before you use the Iconics. (best inside a [CustomApplication](https://github.com/mikepenz/Android-Iconics/blob/develop/app/src/main/java/com/mikepenz/iconics/sample/CustomApplication.java))

```java
//Create a new GenericFont by defining a 3 char long fontId and by defining the path to the font (starting inside src/main/assets)
GenericFont gf2 = new GenericFont("gmf", "fonts/materialdrawerfont.ttf");
//now register the icons which are inside the font. Just provide the unicode value and name.
//the unicode value is defined as '\e800', just add the 'u' after '\' to tell java that it's an unicode char
gf2.registerIcon("person", '\ue800');
gf2.registerIcon("up", '\ue801');
gf2.registerIcon("down", '\ue802');
//now register the created GenericFont
Iconics.registerFont(gf2);
```
- After defining the GenericFont you can use it like this
```java
new IconicsDrawable(this).icon("gmf-person").sizeDp(24);
```

#####2.2. Implement as CustomFont
- A more complex but easier to use / more safe implementation is to create a CustomFont.
- For a QuickStart just use the [CustomFont](https://github.com/mikepenz/Android-Iconics/blob/develop/app/src/main/java/com/mikepenz/iconics/sample/typeface/CustomFont.java) used in the Sample app
- A CustomFont has to implement the `ITypeface` interface, and can then be easily used as any of the provided fonts

```java
public class CustomFont implements ITypeface {
    //define the font file to use
    private static final String TTF_FILE = "fontello.ttf";

    private static Typeface typeface = null;
    private static HashMap<String, Character> mChars;

    //return a icon by it's key
    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    //return all possible key unicode-character mappings
    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }

        return mChars;
    }

    //the mapping prefix used for this font like fon-android
    @Override
    public String getMappingPrefix() {
        return "fon";
    }

    //return all possible icon names
    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();

        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }

        return icons;
    }

    //implement all additional methods from the interface
    //...


    //return the font from the assets (you can take this method in most cases)
    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    //implement the enum containing all possible icons. each icon name is like `fontId`_`iconNamE` --> `fon_test1` maps to the icon with the unicode char \e800
    public static enum Icon implements IIcon {
        //define all possible mappings here:
        fon_test1('\ue800'),
        fon_test2('\ue801');

        //define all methods required by the IIcon interface, you can just copy and paste those
        char character;
        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new CustomFont();
            }
            return typeface;
        }
    }
}
```

#Proguard rules
```
-keep class com.mikepenz.iconics.** { *; }
-keep class com.mikepenz.community_material_typeface_library.CommunityMaterial
-keep class com.mikepenz.fontawesome_typeface_library.FontAwesome
-keep class com.mikepenz.google_material_typeface_library.GoogleMaterial
-keep class com.mikepenz.meteocons_typeface_library.Meteoconcs
-keep class com.mikepenz.octicons_typeface_library.Octicons
```

#Demo
You can try the sample application out. It's on Google Play ;)
https://play.google.com/store/apps/details?id=com.mikepenz.iconics.sample


#Credits
- [Joan Zapata](https://github.com/JoanZapata) He is the creator of [Android-Iconify](https://github.com/JoanZapata/android-iconify) which gave me the idea of this project. Some core concepts and ideas were reused, but everything is written from scratch.


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



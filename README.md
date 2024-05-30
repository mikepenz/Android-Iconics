# Android-Iconics

... allows to include any icon font with all its vector icons in your project. No limits. **Scale with no limit**, use **any color** at any time, provide a **contour**, and many additional customizations...

-------

<p align="center">
    <a href="#whats-included-">What's included 🚀</a> &bull;
    <a href="#setup">Setup 🛠️</a> &bull;
    <a href="MIGRATION.md">Migration Guide 🧬</a> &bull;
    <a href="FAQ.md">WIKI / FAQ 📖</a> &bull;
    <a href="#create-custom-fonts">Custom Font 🖍️</a> &bull;
    <a href="https://play.google.com/store/apps/details?id=com.mikepenz.iconics.sample">Sample App</a>
</p>

-------

### What's included 🚀
- No customization limitations (size, color, contour, background, padding, positioning, ...)
- Shadow support
- Use as XML Drawable starting API 24
- One icon source (no more mdpi, hdpi, ...)
- Flexibility
  - Size
  - Colors
  - Contour
  - Shadow
  - Auto mirroring for RTL (opt-in)
- If it takes a Drawable, it will also work with the IconicsDrawable!
- Save in APK size
- Compose support

**Already available fonts**
- [Google Material Design Icons](https://github.com/google/material-design-icons)
- [Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font)
- [Fontawesome](https://fontawesome.com/)
- [Meteocons](http://www.alessioatzeni.com/meteocons/)
- [Octicons](https://github.com/github/octicons)
- [Community Material](http://materialdesignicons.com/)
- [Weather Icons](https://erikflowers.github.io/weather-icons/)
- [Typeicons](http://typicons.com/)
- [Entypo](http://www.entypo.com/)
- [Devicon](http://devicon.fr/)
- [Foundation Icons](http://zurb.com/playground/foundation-icon-fonts-3)
- [Ionicons](http://ionicons.com/)
- [Material Design DX](https://jossef.github.io/material-design-icons-iconfont/)
- [Pixeden 7 Stroke](https://themes-pixeden.com/font-demos/7-stroke/)
- [Phosphor](https://phosphoricons.com/)
- [Simple Icons](https://simpleicons.org/)
- Or create your own font with any icon needed.

# Setup

## Latest releases 🛠

- Kotlin | [v5.4.0](https://github.com/mikepenz/Android-Iconics/tree/v5.4.0)
- Pre-Release | [v5.5.0-b01](https://github.com/mikepenz/Android-Iconics/tree/v5.5.0-b01)

## 1. Provide the gradle dependency
```gradle
dependencies {
    //the core iconics library (without any widgets)
    implementation "com.mikepenz:iconics-core:${latestAndroidIconicsRelease}"
    implementation "androidx.appcompat:appcompat:${versions.appCompat}"
}
```

## 1b. (optional) Add the view's dependency
```gradle
//this adds all ui view widgets (IconicsButton, IconicsImageView, ...)
implementation "com.mikepenz:iconics-views:${latestAndroidIconicsRelease}"
```

## 2. Choose your desired fonts

> Note: Fonts ending with `-kotlin` require at least v4.x of Android-Iconics
> Note: v5.1.x or newer requires the latest font versions

```gradle
implementation 'com.mikepenz:google-material-typeface:4.0.0.3-kotlin@aar'
implementation 'com.mikepenz:google-material-typeface-{outlined|rounded|sharp}:4.0.0.2-kotlin@aar'
implementation 'com.mikepenz:material-design-iconic-typeface:2.2.0.9-kotlin@aar'
implementation 'com.mikepenz:fontawesome-typeface:5.9.0.3-kotlin@aar'
implementation 'com.mikepenz:octicons-typeface:11.1.0.1-kotlin@aar'
implementation 'com.mikepenz:meteocons-typeface:1.1.0.8-kotlin@aar'
implementation 'com.mikepenz:community-material-typeface:7.0.96.1-kotlin@aar' // note 5.3.45.1 and newer alphabetically sorts, and merges in 3 sections
implementation 'com.mikepenz:weather-icons-typeface:2.0.10.8-kotlin@aar'
implementation 'com.mikepenz:typeicons-typeface:2.0.7.8-kotlin@aar'
implementation 'com.mikepenz:entypo-typeface:1.0.0.8-kotlin@aar'
implementation 'com.mikepenz:devicon-typeface:2.0.0.8-kotlin@aar'
implementation 'com.mikepenz:foundation-icons-typeface:3.0.0.8-kotlin@aar'
implementation 'com.mikepenz:ionicons-typeface:2.0.1.8-kotlin@aar'
implementation 'com.mikepenz:pixeden-7-stroke-typeface:1.2.0.6-kotlin@aar'
implementation 'com.mikepenz:material-design-icons-dx-typeface:5.0.1.3-kotlin@aar'
implementation 'com.mikepenz:phosphor-typeface:1.0.0.1-kotlin@aar'
implementation 'com.mikepenz:simple-icons-typeface:17.0.0.3@aar'
```

> [!WARNING]  
> The fonts use the `jetpack startup` library to automatically register themselves.
> If `jetpack startup` is disabled,
> it is required to manually register the fonts. Please find additional details in
> the [Register fonts](#register-fonts).


# Usage

> [!NOTE]  
> It might be required to call `Iconics.init(applicationContext)` if no context based APIs are used
> from the library otherwise.

## Use as drawable

```kotlin
IconicsDrawable(this, FontAwesome.Icon.faw_android).apply {
    colorInt = Color.RED
    sizeDp = 24
}
```

## Use via XML

If you use the Iconics library via XML provide the icon you want to use in the following syntax: `gmd-favorite` --> `fontId`-`iconName`. A list of the
available fonts and their `fontId` can be found [here](#available-fonts).
All icon names from the default fonts can be found via the [DEMO](https://play.google.com/store/apps/details?id=com.mikepenz.iconics.sample) application.

#### Notation within text
Use the `{` icon-definer `}` syntax
```gson
Some great text with a {faw-android} font awesome icon and {met-wind} meteocons icons.
```

### Drawable XML (API 24+)

Specify the drawable in your `drawable` folder.

```xml
<com.mikepenz.iconics.IconicsDrawable
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:ico_icon="gmd_favorite"
    app:ico_color="#0000FF"
    app:ico_contour_width="1dp"
    app:ico_contour_color="#00FFFF"
    app:ico_size="24dp" />
    // all custom theming attributes supported
```

Use like any normal drawable in your application.
This feature was suggested and initially provided by @dzamlo

### Custom Views
#### As IconicsImageView
```xml
<com.mikepenz.iconics.view.IconicsImageView
    android:layout_width="72dp"
    android:layout_height="72dp"
    app:iiv_color="@android:color/holo_red_dark"
    app:iiv_icon="gmd-favorite" />  // or @string/gmd_favorite with our generator
    //app:iiv_size="12dp"
    //app:iiv_padding="2dp"
    //app:iiv_contour_color="#FF0000"
    //app:iiv_contour_width="2dp"
    //app:iiv_background_color="#FFFF00"
    //app:iiv_corner_radius="2dp"
    //app:iiv_background_contour_color="#FF0000"
    //app:iiv_background_contour_width="1dp"
    //app:iiv_shadow_radius="4dp"
    //app:iiv_shadow_dx="1dp"
    //app:iiv_shadow_dy="1dp"
    //app:iiv_animations="spin|blink_alpha|blink_scale"
```

#### As IconicsTextView
```xml
<com.mikepenz.iconics.view.IconicsTextView
    android:text="abc{hif-test}defgh{faw-adjust}ijk{fon-test1}lmnopqrstuv{fon-test2}wxyz"
    android:textColor="@android:color/black"
    android:layout_width="wrap_content"
    android:layout_height="56dp"
    android:textSize="16sp"/>
```

#### As IconicsButton
```xml
<com.mikepenz.iconics.view.IconicsButton
    android:text="{faw-adjust} Button"
    android:layout_width="120dp"
    android:layout_height="60dp"/>
```

## Compose

To include the experimental compose support in your project add the following dependency to your project (since v5.2.0)

```gradle
implementation "com.mikepenz:iconics-compose:${latestAndroidIconicsRelease}"
```

Use the provided `Image` wrapper and set the icon.

```kotlin
Image(
    GoogleMaterial.Icon.gmd_access_alarm,
    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
)
```

# Screenshots

![Image](https://raw.githubusercontent.com/mikepenz/Android-Iconics/develop/DEV/github/screenshots1.jpg)

# Available fonts

| Link                                                                                                              | Prefix          | Dependency                                                                            |
|-------------------------------------------------------------------------------------------------------------------|-----------------|---------------------------------------------------------------------------------------|
| [Google Material Design Icons](https://github.com/google/material-design-icons) **ORIGINAL by
Google**            | gmd,gmo,gmr,gms | implementation 'com.mikepenz:google-material-typeface{-outlined,rounded,sharp}:+@aar' |
| [Material Design Iconic Font](http://zavoloklom.github.io/material-design-iconic-font) **Google Material
Iconic** | gmi             | implementation 'com.mikepenz:material-design-iconic-typeface:+@aar'                   |
| [Fontawesome](https://fontawesome.com/)                                                                           | faw             | implementation 'com.mikepenz:fontawesome-typeface:+@aar'                              |
| [FontawesomeBrand](https://fontawesome.com/)                                                                      | fab             | implementation 'com.mikepenz:fontawesome-typeface:+@aar'                              |
| [FontawesomeRegular](https://fontawesome.com/)                                                                    | far             | implementation 'com.mikepenz:fontawesome-typeface:+@aar'                              |
| [Meteocons](http://www.alessioatzeni.com/meteocons/)                                                              | met             | implementation 'com.mikepenz:meteocons-typeface:+@aar'                                |
| [Octicons](https://github.com/github/octicons)                                                                    | oct             | implementation 'com.mikepenz:octicons-typeface:+@aar'                                 |
| [Community Material](http://materialdesignicons.com/)                                                             | cmd             | implementation 'com.mikepenz:community-material-typeface:+@aar'                       |
| [Weather Icons](https://erikflowers.github.io/weather-icons/)                                                     | wic             | implementation 'com.mikepenz:weather-icons-typeface:+@aar'                            |
| [Typeicons](http://typicons.com/)                                                                                 | typ             | implementation 'com.mikepenz:typeicons-typeface:+@aar'                                |
| [Entypo](http://www.entypo.com/)                                                                                  | ent             | implementation 'com.mikepenz:entypo-typeface:+@aar'                                   |
| [Devicon](http://devicon.fr/)                                                                                     | dev             | implementation 'com.mikepenz:devicon-typeface:+@aar'                                  |
| [Foundation Icons](https://github.com/zurb/foundation-icon-fonts)                                                 | fou             | implementation 'com.mikepenz:foundation-icons-typeface:+@aar'                         |
| [Ionicons](http://ionicons.com/)                                                                                  | ion             | implementation 'com.mikepenz:ionicons-typeface:+@aar'                                 |
| [Pixden7Stroke](http://themes-pixeden.com/font-demos/7-stroke/)                                                   | pe7             | implementation 'com.mikepenz:pixeden-7-stroke-typeface:+@aar'                         |
| [Material Design DX](https://jossef.github.io/material-design-icons-iconfont/)                                    | cmf             | implementation 'com.mikepenz:material-design-icons-dx-typeface:+@aar'                 |
| [Phosphor Icons](https://phosphoricons.com/)                                                                      | pho             | implementation 'com.mikepenz:phosphor-typeface:+@aar'                                 |
| [Simple Icons](https://simpleicons.org/)                                                                          | sim             | implementation 'com.mikepenz:simple-icons-typeface:+@aar'                             |

Licenses for all included fonts are linked inside the class or can be found on the coresponding repositories.

# Compatibility Note

### appcompat:1.4.x

Appcompat v1.4.x introduces default enabled emoji support into all `AppCompat*` views, which prevents the `IconicsView*` views (iconics-views module) from properly applying the spannable style.
To fix this problem, emoji support has to be disabled by doing:

```xml
app:emojiCompatEnabled="false"
```

More information on the appcompat emoji support: https://developer.android.com/jetpack/androidx/releases/appcompat#1.4.0-alpha01

# Advanced Usage

### Register fonts

If you want to add your own custom font, or a GenericFont you have to register this font (before using it). The best place to do this is the `Application`.

And initialize Iconics as you wish
```kotlin
class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(CustomFont())
    }
}
```

### Advanced IconicsBuilder
Everything is easy and simple. Right? But now you got a single icon within your textview and you need additional styling?
Just define the style for all icons or only a specific one. You can find this in the PlaygroundActivity of the sample too.
```kotlin
Iconics.Builder()
    .style(ForegroundColorSpan(Color.WHITE), BackgroundColorSpan(Color.BLACK), RelativeSizeSpan(2f))
    .styleFor(FontAwesome.Icon.faw_adjust, BackgroundColorSpan(Color.RED))
    .on(tv1)
    .build()
```

### String icon-key or typeface enum
Sometimes you won't like to use the icon-key ("faw-adjust") like this, but use the enum provided by a specific font. Both is valid:
```kotlin
IconicsDrawable(this, "faw-adjust").actionBar()
```
```kotlin
IconicsDrawable(this, FontAwesome.Icon.faw_adjust).apply {
    sizeDp = 24
    paddingDp = 1
}
```

## Create custom fonts
This is possible with only the *.ttf and *.css mapping file. And will take you 2 minutes.

You can get these two files by downloading a web icon font, or if you want to create your
own custom icon font from *.svg files then you can use following tools:
* [Fontello](http://fontello.com)
* [IcoMoon](http://icomoon.io) 
* [Fontastic](http://app.fontastic.me)
* let me know if you find other tools.

After you got those two files, head over to the icon addon creation tool [android-iconics.mikepenz.com](https://android-iconics.mikepenz.com).
Enter all the information. Add the *.ttf and *.css and click the button. It will generate and download the icon font addon as
zip. (this tool is local only, no files are sent to a server, you can safely use it with any icons)

## String fields for icons
For generating string field for each of icons of your font, you can use this simple generator:
[Android-Iconics String Generator](https://github.com/zTrap/Android-Iconics-String-Generator)

## Android module generator

A awesome gradle plugin which can automatically fetch a font from Fontastic, and generate the Android Module for your project.
[Iconics-Font-Generator](https://github.com/ligol/IconicsFontGenerator)

# ProGuard / R8

ProGuard / R8 rules are bundled internally with each font.

# Special Contributor
- [Baptiste Lagache](https://github.com/ligol) Thanks for the gradle font module generator
- Also thanks for all the other contributors.

# Credits
- [Joan Zapata](https://github.com/JoanZapata) He is the creator of [Android-Iconify](https://github.com/JoanZapata/android-iconify) which gave me the idea of this project. Some core concepts and ideas were reused, but everything is written from scratch.
- [Christopher Jenkins](https://github.com/chrisjenx/) Thanks for the great usage of a custom `ContextWrapper` inside [Calligraphy](https://github.com/chrisjenx/Calligraphy/)
- [Stephan Schober](https://github.com/tehfonsi)

# Developed By

- Mike Penz
  - [mikepenz.dev](https://mikepenz.dev) - [blog.mikepenz.dev](https://blog.mikepenz.dev) - <mikepenz@gmail.com>
  - [paypal.me/mikepenz](http://paypal.me/mikepenz)
  - [Automatic changelog generation action](https://github.com/marketplace/actions/release-changelog-builder)

- Peter Gulko
  - [github.com/zTrap](https://github.com/zTrap)

# License

    Copyright 2021 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

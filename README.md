#Android-Iconics  [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.mikepenz.iconics/library/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.mikepenz.iconics/library)

Android-Iconics is a library to use (almost) any alternative iconfont in your projects. It allows you to add any Android-Iconics compatible typeface-library-addon to your project and you are able to start using that font.

__ **NOTE:** Upgrade to > 0.6.0 You can now write **"faw-android"** instead of **"icon-faw-android"** in texts!

Let's start with some awesome screenshots ;)

![Image](https://raw.githubusercontent.com/mikepenz/Android-Iconics/master/DEV/screenshots/screenshot_1_small.jpg)
![Image](https://raw.githubusercontent.com/mikepenz/Android-Iconics/master/DEV/screenshots/screenshot_2_small.jpg)

You can use these icons in any IconicTextView just by defining the icon within the text. An example for FontAwesome looks like this: {faw-github}. You see pretty easy right?

You can also use it on any text by using the simple builder pattern. Here's the shortest possible sample:

```java
new Iconics.IconicsBuilder().ctx(this).on(YOUR_TEXT_VIEW).build();
```
Define icons in a text as following:
```gson
Some great text with a {faw-android} font awesome icon and {met-wind} meteocons icons.
```


But wait! There's more. You can also use it as Drawable anywhere. Create it like this:

```java
new IconicsDrawable(this, "faw-adjust").color(Color.RED)
```

If you don't know the name of the icon, and the typeface-library-addon allows it you can also do the following:
```java
new IconicsDrawable(this, FontAwesome.Icon.faw_android).color(Color.GREEN)
```

##Include in your project
The Android-Iconics Library is pushed to [Maven Central], so you just need to add the following dependency to your `build.gradle`.

```javascript
dependencies {
	compile 'com.mikepenz.iconics:library:0.6.0@aar'
}
```

##Use typeface-library-addons
One basic function of this library is the feature to drop in new typefaces on the go. The default font of this project is FontAwesome (http://fontawesome.io), but you can create and add as many as you like.

The main idea is that the community can create libraries which can be used without the need of an extra library. 

So how does it work?
Just add the dependency of any and as many typface-library-addons in your build.gradle just beneath the android-iconics dependency.

```javascript
dependencies {
	compile 'com.mikepenz.iconics:library:0.6.0@aar'
	compile 'com.mikepenz.iconics:meteocons-typeface:1.0.0@aar'
}
```

To enable them for the IconicsTextView too follow the steps under [Register typeface](#register-typeface)

##Advanced usage

###working with multiple typeface-library-addons and icons
In some cases you will use multiple typefaces. It is really easy to decide which icon of which typeface-library-addon should be used. Each of those got a unique **3-character** long identifier which is the prefix of every single icon. 
FontAwesome - "faw"
Meteocons - "met"

Evertime you want to use an icon in a text just write {faw-adjust}, ...

###Register typeface
In some cases you will love to use a typeface-library-addon in your IconicTextView and everywhere else without the need of adding it as typeface all the time.

Just override your Application and register your additional fonts like this:
```java
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new Meteoconcs());
        Iconics.registerFont(new CustomFont());
    }
}
```
and set it in your AndroidManifest.xml as name
```java
    <application
        android:name="com.mikpenz.iconics.sample.CustomApplication"
        ...
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
  new IconicsDrawable(this, "faw-adjust")
```
```java
  new IconicsDrawable(this, FontAwesome.Icon.faw_adjust)
```

##Available fonts
* [Fontawesome](http://fontawesome.io)
  * "faw"
  * DEFAULT
* [Meteocons](http://www.alessioatzeni.com/meteocons/)
  * "met"
  * compile 'com.mikepenz.iconics:meteocons-typeface:+@aar'


##Demo
You can try the sample application out. It's on Google Play ;)
https://play.google.com/store/apps/details?id=com.mikpenz.iconics.sample

##Contribute
The easiest way to contribute is by creating a new typeface-library addon. This is a pretty easy step. Just look into the meteocons-typeface-library project within this repository. You will see you only need 2 things. The font itself (the .ttf file). And the Typeface definition which is an implementation of the ITypeface class. 

Just fill in the required information, create the mapping and it works. To help the users using your typeface-library-addon you should upload it to maven and let me know so i can add it to the list of available fonts. 

So the hardest part is to create the mapping. I also have a solution for this problem. 
Just use the awesome service of http://fontello.com/ create a typeface-library-addon of one of the provided fonts there or upload your own. If missing customize the names. Choose a good 3-character long prefix (css prefix under settings) and download the webfont. 
This will include the .ttf to use, and a file called test-codes.css under css. This repository includes a small helper to create the enum-list for the Typeface definition class. (You can find it under /DEV/extractor). Just drop the test-codes.css in the same folder. rename it to test.css and run the extractor.js with node extractor.js. This will output the correct list.

If something is unclear, don't be afraid to drop an e-mail, or create an github issue.


##Credits
- [Joan Zapata](https://github.com/JoanZapata) He is the creator of [Android-Iconify](https://github.com/JoanZapata/android-iconify) which gave me the idea of this project. It implements some really great concepts, and i only tried to improve them and give it some more flexibility.


#Developed By

* Mike Penz - http://mikepenz.com - <mikepenz@gmail.com>


#License

    Copyright 2014 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



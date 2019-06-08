## Upgrade Notes

### Library

### core v3.x.x -> 4.x.x
Now libray is kotlin-first

* Font files
  * Font's store now based on default way to store fonts. (moved from common assets to font-specific resource assets)
* `Iconics`
  * No context from now required. We get the application context via ContentProvider
* `Iconics.IconicsBuilder`
  * Renamed to `Iconics.Builder`
  * Removed `ctx(Context)` method
* `IconicsDrawable`
  * Replaced all `*Res(int)`, `*Px(int)`, `*Dp(int)` method to use `IconicsSize` and `IconicsColor` classes instead
  * Constants `TOOLBAR_ICON_SIZE` and `TOOLBAR_ICON_PADDING` moved to `IconicsSize`
  * All getters now have property-syntax
  * All producer-provided methods from [Android-Iconics Kt](https://github.com/zTrap/Android-Iconics-Kt) are included in class and can return nullable value (value will be set only when not null)
  * `enableShadowSupport(View)` moved to `IconicsUtils`
* All `utils` classes and typeface libraries now can not be instantiated
* `ITypeface`
  * Method `getTypeface(Context)` replaced with field `rawTypeface`
  * Automatically retrieves raw font from file by provided `fontRes` (see [GenericFont.kt](/library-core/src/main/java/com/mikepenz/iconics/typeface/GenericFont.kt) if You wont to use old scheme)

#### Community Material Icons > v2.7.94
* With the update of the community material icons, the amount of icons exceeded the allowed length of an enum. Thus it was split up in `CommunityMaterial.Icon` and `CommunityMaterial.Icon2` if you use the icons via code, please use the depending enum.
  * The icons were split apart by the letter `h`. All icons starting from `a` to `g` are in the `CommunityMaterial.Icon` enum, all icons from `h` to `z` are in the `CommunityMaterial.Icon2` enum.

#### v3.1.x
* Upgraded the library to use `androidX` dependencies. This means your project will need to depend on `androidX` dependencies too. If you still use appcompat please consider using a version older than v3.1.x. 
* Further details about migrating to androidX and a overview can be found on the official docs. https://developer.android.com/topic/libraries/support-library/refactor

#### 2.9.5
* the attributes for the `IconicsMenuInflaterUtil` start now with `ico_` instead of `iiv_`
* the `IconicsMenuInflaterUtil` was moved into the `core` module to simplify code

#### 2.9.0
* The library-core was split apart into **iconics-core** and **iconics-views** to slim down the **iconics-core** and allow more advanced UI features in the **iconics-views**
* the core dep stays the same: `compile "com.mikepenz:iconics-core:2.9.0@aar"`
* for all UI widgets add `compile "com.mikepenz:iconics-views:2.9.0@aar"`

#### 2.8.0
* Dropping support for API < 14. New `MinSdkVersion` is now 14

#### 2.x.y -> 2.5.0
* there is now a new prefered solution to enable the Iconics features on Android base views like ImageViews, TextViews or all views which extend those.
 * instead of wrapping the `baseContext` you should now define the `IconicsLayoutInflater` as default `LayoutInflater`. This will also bring [Calligraphy](https://github.com/chrisjenx/Calligraphy) compatiblity (or to other libs which wrap the `baseContext`)
 * this requires an `Activity` extending the `AppCompatActivity` or implementing the `AppCompatDelegate`

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
    //...
    super.onCreate(savedInstanceState);
    //...
}
```

* if you do not wrap the `BaseContext` with a different lib, or do not extend from `AppCompatActivity` or do not implement `AppCompatDelegate` you can still wrap the `baseContext`

```java
@Override
protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
}
```


#### v1.x.y -> v2.0.0
* there is now a core package which comes without included fonts
* provide the fonts you need. no additional steps required

### Font Addons
#### Google Material font v2.1.0.1.original
* **NOTE:** Google's font has a bad baseline so icons are not centered within text. Drawables look fine. Use Material Design Iconic as alternative if this is an issue for you
* is now the default Google Material icon set again with the "**gmd**" mapping
* package name `com.mikepenz.google_material_typeface_library.GoogleMaterial`
#### Material Design Iconic v2.2.0.1
* is now the standalone Material Design Iconic icon pack with the "**gmi**" mapping
* package name `com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic`

#### Google Material font 1.2.0.1 --> 2.1.2.1
* the mapping of some icons changed

##Upgrade Notes

### Library
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
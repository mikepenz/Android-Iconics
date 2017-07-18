# IconicsImageView Family

##### Members
- [IconicsImageView](#iconicsimageview)
- [IconicsImageButton](#iconicsimagebutton)

## All possible attributes

For all the family available this attributes

| Name | Format | Description |
| --- | --- | --- |
| app:iiv_icon             | string                | set icon
| app:iiv_color            | color / reference     | set icon color
| app:iiv_size             | dimension / reference | set icon size
| app:iiv_padding          | dimension / reference | set icon padding
| app:iiv_contour_color    | color / reference     | set contour color
| app:iiv_contour_width    | dimension / reference | set contour width
| app:iiv_background_color | color / reference     | set background color
| app:iiv_corner_radius    | dimension / reference | set corner radius

## Usage examples

### IconicsImageView
```xml
<com.mikepenz.iconics.view.IconicsImageView
    android:layout_width="72dp"
    android:layout_height="72dp"
    app:iiv_color="@color/md_red_200"
    app:iiv_icon="gmd-favorite"/>
```
![image_view_sample_1][1]

### IconicsImage
```xml
<com.mikepenz.iconics.view.IconicsImageButton
    android:id="@+id/test8"
    android:layout_width="48dp"
    android:layout_height="48dp"
    app:iiv_color="@color/md_red_200"
    app:iiv_icon="gmd-favorite"/>
```
![image_button_sample_1][2]

  [1]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/image_view_sample_1.PNG
  [2]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/image_button_sample_1.PNG

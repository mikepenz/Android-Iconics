# IconicsCompoundButton Family

##### Members
- [IconicsCompoundButton](#iconicscompoundbutton)
- [IconicsCheckBox](#iconicscheckbox)

## All possible attributes

For all the family available this attributes

| Name | Format | Description |
| --- | --- | --- |
| app:iiv_**STATE***_icon             | string                | set icon
| app:iiv_**STATE***_color            | color / reference     | set icon color
| app:iiv_**STATE***_size             | dimension / reference | set icon size
| app:iiv_**STATE***_padding          | dimension / reference | set icon padding
| app:iiv_**STATE***_contour_color    | color / reference     | set contour color
| app:iiv_**STATE***_contour_width    | dimension / reference | set contour width
| app:iiv_**STATE***_background_color | color / reference     | set background color
| app:iiv_**STATE***_corner_radius    | dimension / reference | set corner radius

***STATE** - variant of definition state when will be used this `IconicsDrawable`.

Available variants:

 - checked
 - unchecked

## Usage Examples

### IconicsCheckBox
```xml
<com.mikepenz.iconics.view.IconicsCheckBox
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="IconicsCheckBox"
    android:padding="5dp"

    app:iiv_checked_color="@color/primary"
    app:iiv_checked_icon="@string/gmd_star"
    app:iiv_checked_size="24dp"

    app:iiv_unchecked_color="@color/primary"
    app:iiv_unchecked_icon="@string/gmd_star_border"
    app:iiv_unchecked_size="24dp"/>
 ```
normal

![check_box_sample_1][1]

checked

![check_box_sample_2][2]

  [1]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/check_box_sample_1.PNG
  [2]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/check_box_sample_2.PNG

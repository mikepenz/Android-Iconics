# IconicsTextView Family

##### Members
- [IconicsTextView](#iconicstextview)
- [IconicsButton](#iconicsbutton)
- [IconicsCheckableTextView](#iconicscheckabletextview)

## All possible attributes

For all the family available this attributes

| Name | Format | Description |
| --- | --- | --- |
| app:iiv_animate_icon_changes       | boolean               | set fade animation for icons changing
| app:iiv_**SIDE***_icon             | string                | set icon
| app:iiv_**SIDE***_color            | color / reference     | set icon color
| app:iiv_**SIDE***_size             | dimension / reference | set icon size
| app:iiv_**SIDE***_padding          | dimension / reference | set icon padding
| app:iiv_**SIDE***_contour_color    | color / reference     | set contour color
| app:iiv_**SIDE***_contour_width    | dimension / reference | set contour width
| app:iiv_**SIDE***_background_color | color / reference     | set background color
| app:iiv_**SIDE***_corner_radius    | dimension / reference | set corner radius

For `CheckableTextView` also available this attributes

| Name | Format | Description |
| --- | --- | --- |
| app:iiv_**SIDE***_checked_icon             | string                | set icon
| app:iiv_**SIDE***_checked_color            | color / reference     | set icon color
| app:iiv_**SIDE***_checked_size             | dimension / reference | set icon size
| app:iiv_**SIDE***_checked_padding          | dimension / reference | set icon padding
| app:iiv_**SIDE***_checked_contour_color    | color / reference     | set contour color
| app:iiv_**SIDE***_checked_contour_width    | dimension / reference | set contour width
| app:iiv_**SIDE***_checked_background_color | color / reference     | set background color
| app:iiv_**SIDE***_checked_corner_radius    | dimension / reference | set corner radius

***SIDE** - variant of definition side where will be placed `IconicsDrawable`.

Available variants:

 - start
 - end
 - top
 - end
 - all

## Attributes priority:
Attributes with variable `all` < attributes with some else variable (`start`, `top` etc).

Working like as `style` - local overrides global

**IMPORTANT TRICK**

For overriding some of attributes to default use resources with prefix `default_`

```xml
<com.mikepenz.iconics.view.IconicsTextView
    ...
    app:iiv_all_color="@color/md_amber_300"
    app:iiv_all_icon="@string/gmd_account_circle"
    app:iiv_all_size="24dp"
    app:iiv_bottom_icon="@string/default_icon"/>
```
![text_view_sample_3][1]

## Usage examples

### IconicsTextView
```xml
<com.mikepenz.iconics.view.IconicsTextView
    android:layout_width="wrap_content"
    android:layout_height="56dp"
    android:text="abcdefgh{faw-adjust}ijk{fon-test1}lmnopqrstuv{fon-test2}wxyz"
    android:textColor="@android:color/black"
    android:textSize="16sp"/>
```
![text_view_sample_1][2]

```xml
<com.mikepenz.iconics.view.IconicsTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="IconicsTextView with side-drawables"
    android:textColor="@android:color/black"

    app:iiv_all_color="@color/md_amber_300"
    app:iiv_all_icon="@string/gmd_account_circle"
    app:iiv_all_size="24dp"/>
```
![text_view_sample_2][3]

### IconicsButton
```xml
<com.mikepenz.iconics.view.IconicsButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="IconicsButton with side-drawables"

    app:iiv_all_color="@color/md_red_600"
    app:iiv_all_icon="@string/faw_android"
    app:iiv_all_size="24dp"/>
```
![button_sample_1][4]

```xml
<com.mikepenz.iconics.view.IconicsButton
    android:layout_width="0dp"
    android:layout_height="60dp"
    android:layout_weight="1"
    android:text="{faw-adjust} Button"/>
```
![button_sample_2][5]

### IconicsCheckableTextView
```xml
<com.mikepenz.iconics.view.IconicsCheckableTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="IconicsCheckableTextView"
    android:textColor="@android:color/black"
    android:padding="5dp"

    app:iiv_all_size="24dp"
    app:iiv_all_checked_size="24dp"

    app:iiv_start_icon="@string/gmd_error_outline"
    app:iiv_start_color="@color/colorAccent"
    app:iiv_start_checked_icon="@string/gmd_error"
    app:iiv_start_checked_color="@color/colorAccent"

    app:iiv_top_icon="@string/gmd_help_outline"
    app:iiv_top_color="@color/md_deep_orange_400"
    app:iiv_top_checked_icon="@string/gmd_help"
    app:iiv_top_checked_color="@color/md_deep_orange_400"

    app:iiv_end_icon="@string/gmd_info_outline"
    app:iiv_end_color="@color/md_cyan_800"
    app:iiv_end_checked_icon="@string/gmd_info"
    app:iiv_end_checked_color="@color/md_cyan_800"

    app:iiv_bottom_icon="@string/gmd_add_circle_outline"
    app:iiv_bottom_color="@color/md_blue_grey_300"
    app:iiv_bottom_checked_icon="@string/gmd_add_circle"
    app:iiv_bottom_checked_color="@color/md_blue_grey_300"/>
```
Normal

![checkable_text_view_sample_1][6]

Checked

![checkable_text_view_sample_2][7]

  [1]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/text_view_sample_3.PNG
  [2]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/text_view_sample_1.PNG
  [3]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/text_view_sample_2.PNG
  [4]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/button_sample_1.PNG
  [5]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/button_sample_2.PNG
  [6]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/checkable_text_view_sample_1.PNG
  [7]: https://github.com/zTrap/Android-Iconics/blob/develop/DEV/github/wiki/checkable_text_view_sample_2.PNG
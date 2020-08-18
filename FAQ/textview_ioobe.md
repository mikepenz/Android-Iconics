### Q: IndexOutOfBoundsException internally of the `TextView` when using `setText` with the `IconicsLayoutInflator2` applied?

```
FATAL EXCEPTION: main
Process: com.mikepenz.iconics.sample.debug, PID: 23793
java.lang.IndexOutOfBoundsException: charAt: 4 >= length 2
   at android.text.SpannableStringBuilder.charAt(SpannableStringBuilder.java:123)
   at android.widget.TextView.desired(TextView.java:8049)
   at android.widget.TextView.onMeasure(TextView.java:8121)
   at android.view.View.measure(View.java:22071)
   at android.widget.LinearLayout.measureHorizontal(LinearLayout.java:1148)
   at android.widget.LinearLayout.onMeasure(LinearLayout.java:687)
   at android.view.View.measure(View.java:22071)
   at android.widget.RelativeLayout.measureChildHorizontal(RelativeLayout.java:715)
   at android.widget.RelativeLayout.onMeasure(RelativeLayout.java:461)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6602)
   at android.widget.FrameLayout.onMeasure(FrameLayout.java:185)
   at android.support.v7.widget.ContentFrameLayout.onMeasure(ContentFrameLayout.java:139)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6602)
   at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1514)
   at android.widget.LinearLayout.measureVertical(LinearLayout.java:806)
   at android.widget.LinearLayout.onMeasure(LinearLayout.java:685)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6602)
   at android.widget.FrameLayout.onMeasure(FrameLayout.java:185)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6602)
   at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1514)
   at android.widget.LinearLayout.measureVertical(LinearLayout.java:806)
   at android.widget.LinearLayout.onMeasure(LinearLayout.java:685)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:6602)
   at android.widget.FrameLayout.onMeasure(FrameLayout.java:185)
   at com.android.internal.policy.DecorView.onMeasure(DecorView.java:724)
   at android.view.View.measure(View.java:22071)
   at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2422)
   at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1504)
   at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1761)
   at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1392)
   at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6752)
   at android.view.Choreographer$CallbackRecord.run(Choreographer.java:911)
   at android.view.Choreographer.doCallbacks(Choreographer.java:723)
   at android.view.Choreographer.doFrame(Choreographer.java:658)
   at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:897)
   at android.os.Handler.handleCallback(Handler.java:790)
   at android.os.Handler.dispatchMessage(Handler.java:99)
   at android.os.Looper.loop(Looper.java:164)
   at android.app.ActivityThread.main(ActivityThread.java:6494)
   at java.lang.reflect.Method.invoke(Native Method)
   at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:438)
   at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:807)
```

### A: 
The issue is caused by the following:
WIth the `IconicsLayoutInflater2` I'll automatically replace text with the icon + attach a text listener to the textview.

When we then adjust the text the normal `draw` logic instantly kicks in of the textview, during this time we get the event of the `TextWatcher` with the editable, which we modify to be the icon.
The problem here is though, that the `draw` logic of the `TextView` is too stupid and does not detect that instead of multiple lines (the text for the icon would result in 4 lines) is now only 1 line (the icon is super short, the text behind is also super short, so no line break necessary) So it will blow up. There's sadly not much we can do about this (setting the lines, and line number to 1 surprisingly does not change the internal line calculation :D)

The easiest approach to get around this is use the `IconicsTextView` as this will adjust the icon during `setText`, another approach (but not so handy) would be to apply the styling to the text as spannable, and apply this then to the normal `TextView` (so it would have the short string from the beginning)

Another nice workaround is to add `android:ellipsize="start"` to that `TextView` as this will change the way it calculates line breaks, and it won't crash anymore.

### Related issue:
https://github.com/mikepenz/Android-Iconics/issues/350

### Branch with issue showcase + fix:
https://github.com/mikepenz/Android-Iconics/tree/feature/fix_textview_ioobe
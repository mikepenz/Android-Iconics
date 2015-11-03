package com.mikepenz.iconics.context;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.core.R;

class IconicsFactory {

    public View onViewCreated(View view, Context context, AttributeSet attrs) {
        if (view != null && view.getTag(R.id.iconics_tag_id) != Boolean.TRUE) {
            onViewCreatedInternal(view, context, attrs);
            view.setTag(R.id.iconics_tag_id, Boolean.TRUE);
        }
        return view;
    }

    void onViewCreatedInternal(View view, final Context context, AttributeSet attrs) {
        if (view instanceof TextView) {
            if (attrs == null) {
                return;
            }

            TextView tv = (TextView) view;
            tv.setText(new Iconics.IconicsBuilder().ctx(context).on(tv.getText()).build());
        }
    }
}
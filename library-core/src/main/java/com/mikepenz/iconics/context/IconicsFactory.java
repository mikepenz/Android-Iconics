package com.mikepenz.iconics.context;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.core.R;

/**
 * Base created by Christopher Jenkins
 * https://github.com/chrisjenx/Calligraphy
 */
class IconicsFactory {

    /**
     * @param view
     * @param context
     * @param attrs
     * @return
     */
    public View onViewCreated(View view, Context context, AttributeSet attrs) {
        if (view != null && view.getTag(R.id.iconics_tag_id) != Boolean.TRUE) {
            onViewCreatedInternal(view, context, attrs);
            view.setTag(R.id.iconics_tag_id, Boolean.TRUE);
        }
        return view;
    }

    /**
     * @param view
     * @param context
     * @param attrs
     */
    void onViewCreatedInternal(View view, final Context context, AttributeSet attrs) {
        if (view instanceof TextView) {
            if (attrs == null) {
                return;
            }

            //handle iconics
            new Iconics.IconicsBuilder().ctx(context).on((TextView) view).build();

            ((TextView) view).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    Iconics.styleEditable(context, editable);
                }
            });
        }
    }
}
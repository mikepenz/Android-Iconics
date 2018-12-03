package com.mikepenz.iconics.context;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable;
import com.mikepenz.iconics.core.R;

import androidx.appcompat.view.menu.ActionMenuItemView;

class IconicsFactory {

    View onViewCreated(View view, Context context, AttributeSet attrs) {
        if (view != null && view.getTag(R.id.iconics_tag_id) != Boolean.TRUE) {
            onViewCreatedInternal(view, context, attrs);
            view.setTag(R.id.iconics_tag_id, Boolean.TRUE);
        }
        return view;
    }

    @SuppressLint("RestrictedApi")
    private void onViewCreatedInternal(View view, final Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        if (view instanceof ActionMenuItemView) {
            IconicsDrawable drawable = IconicsAttrsApplier.getIconicsDrawable(context, attrs);
            if (drawable != null) {
                ((ActionMenuItemView) view).setIcon(drawable);

                if (drawable instanceof IconicsAnimatedDrawable) {
                    ((IconicsAnimatedDrawable) drawable).animateIn(view);
                }
            }
        } else if (view instanceof EditText) {
            //handle iconics
            new Iconics.IconicsBuilder().ctx(context).on((TextView) view).build();

            //for an editText we only style initial as styling the Editable causes problems!
        } else if (view instanceof TextView) {
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
        } else if (view instanceof ImageView) {
            IconicsDrawable drawable = IconicsAttrsApplier.getIconicsDrawable(context, attrs);
            if (drawable != null) {
                ((ImageView) view).setImageDrawable(drawable);

                if (drawable instanceof IconicsAnimatedDrawable) {
                    ((IconicsAnimatedDrawable) drawable).animateIn(view);
                }
            }
        }
    }
}
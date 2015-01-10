/*
 * Copyright 2014 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.FontAwesome;

public class IconicsButton extends Button {

    public IconicsButton(Context context) {
        super(context);
        if (!isInEditMode()) {
            setTypeface(new FontAwesome().getTypeface(context));
        }
    }

    public IconicsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setTypeface(new FontAwesome().getTypeface(context));
        }
    }

    public IconicsButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            setTypeface(new FontAwesome().getTypeface(context));
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}

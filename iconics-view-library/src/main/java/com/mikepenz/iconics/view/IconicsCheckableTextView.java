package com.mikepenz.iconics.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.SoundEffectConstants;
import android.widget.Checkable;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.CheckedCompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;
import com.mikepenz.iconics.internal.IconicsViewsAttrsReader;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
public class IconicsCheckableTextView extends IconicsTextView implements Checkable, CheckedCompoundIconicsDrawables {
    protected CompoundIconsBundle mCheckedIconsBundle;
    private boolean mAnimateChanges;

    private boolean mChecked;
    private boolean mBroadcasting;

    private OnCheckedChangeListener mOnCheckedChangeListener;

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    public IconicsCheckableTextView(Context context) {
        this(context, null);
    }

    public IconicsCheckableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public IconicsCheckableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        mCheckedIconsBundle = new CompoundIconsBundle();
        setFocusable(true);
        setClickable(true);
        //taking normal state attrs
        super.applyAttr(context, attrs, defStyle);
        //taking checked state attrs
        applyAttr(context, attrs, defStyle);
        //setting created icons
        setIcons();
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    @SuppressLint("CustomViewStyleable")
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsCheckableTextView, defStyle, 0);
        IconicsViewsAttrsReader.readIconicsCheckableTextView(context, a, mCheckedIconsBundle);
        a.recycle();
        a = context.obtainStyledAttributes(attrs, R.styleable.IconicsAnimateChanges, defStyle, 0);
        mAnimateChanges = a.getBoolean(R.styleable.IconicsAnimateChanges_iiv_animate_icon_changes, true);
        a.recycle();
    }

    private void setIcons() {
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this,
                createStatesStart(),
                createStatesTop(),
                createStatesEnd(),
                createStatesBottom()
        );
    }

    private StateListDrawable createStatesStart() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mStartIconBundle,
                mCheckedIconsBundle.mStartIconBundle, mAnimateChanges);
    }

    private StateListDrawable createStatesTop() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mTopIconBundle,
                mCheckedIconsBundle.mTopIconBundle, mAnimateChanges);
    }

    private StateListDrawable createStatesEnd() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mEndIconBundle,
                mCheckedIconsBundle.mEndIconBundle, mAnimateChanges);
    }

    private StateListDrawable createStatesBottom() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mBottomIconBundle,
                mCheckedIconsBundle.mBottomIconBundle, mAnimateChanges);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return IconicsCheckableTextView.class.getName();
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();

            // Avoid infinite recursions if setChecked() is called from a listener
            if (mBroadcasting) {
                return;
            }

            mBroadcasting = true;
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            mBroadcasting = false;
        }

    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public boolean performClick() {
        toggle();

        final boolean handled = super.performClick();
        if (!handled) {
            playSoundEffect(SoundEffectConstants.CLICK);
        }

        return handled;
    }

    //region CheckedCompoundIconicsDrawablesImpl
    @Nullable
    @Override
    public IconicsDrawable getCheckedIconicsDrawableStart() {
        if (mCheckedIconsBundle.mStartIconBundle != null) {
            return mCheckedIconsBundle.mStartIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getCheckedIconicsDrawableTop() {
        if (mCheckedIconsBundle.mTopIconBundle != null) {
            return mCheckedIconsBundle.mTopIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getCheckedIconicsDrawableEnd() {
        if (mCheckedIconsBundle.mEndIconBundle != null) {
            return mCheckedIconsBundle.mEndIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getCheckedIconicsDrawableBottom() {
        if (mCheckedIconsBundle.mBottomIconBundle != null) {
            return mCheckedIconsBundle.mBottomIconBundle;
        } else {
            return null;
        }
    }

    @Override
    public void setCheckedDrawableStart(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mStartIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setCheckedDrawableTop(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mTopIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setCheckedDrawableEnd(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mEndIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setCheckedDrawableBottom(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mBottomIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setCheckedDrawableForAll(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mStartIconBundle = drawable;
        mCheckedIconsBundle.mTopIconBundle = drawable;
        mCheckedIconsBundle.mEndIconBundle = drawable;
        mCheckedIconsBundle.mBottomIconBundle = drawable;
        setIcons();
    }
    //endregion

    public interface OnCheckedChangeListener {
        void onCheckedChanged(IconicsCheckableTextView buttonView, boolean isChecked);
    }
}

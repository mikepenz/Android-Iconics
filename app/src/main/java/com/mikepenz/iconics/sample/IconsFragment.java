package com.mikepenz.iconics.sample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListener;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.sample.item.IconItem;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.materialize.util.UIUtils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by a557114 on 16/04/2015.
 */
public class IconsFragment extends Fragment {

    private static final String FONT_NAME = "FONT_NAME";
    private ArrayList<IconItem> mIcons = new ArrayList<>();
    private FastItemAdapter<IconItem> mAdapter;
    private boolean mRandomize;
    private boolean mShadow;
    private String mSearch;
    private PopupWindow mPopup;
    private Random mRandom = new Random();

    public static IconsFragment newInstance(String fontName) {
        Bundle bundle = new Bundle();

        IconsFragment fragment = new IconsFragment();
        bundle.putString(FONT_NAME, fontName);
        fragment.setArguments(bundle);

        return fragment;
    }

    public void randomize(boolean randomize) {
        mRandomize = randomize;
        if (mAdapter != null) {
            mAdapter.notifyAdapterDataSetChanged();
        }
    }

    public void shadow(boolean shadow) {
        mShadow = shadow;
        if (mAdapter != null) {
            mAdapter.notifyAdapterDataSetChanged();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icons_fragment, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init and Setup RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new SpaceItemDecoration());
        //animator not yet working
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FastItemAdapter<>();
        configAdapter();
        recyclerView.setAdapter(mAdapter);

        if (getArguments() != null) {
            String fontName = getArguments().getString(FONT_NAME);

            for (ITypeface iTypeface : Iconics.getRegisteredFonts(getActivity())) {
                if (iTypeface.getFontName().equalsIgnoreCase(fontName)) {
                    if (iTypeface.getIcons() != null) {
                        for (String icon : iTypeface.getIcons()) {
                            mIcons.add(new IconItem(icon));
                        }
                        mAdapter.set(mIcons);
                        break;
                    }
                }
            }
        }
        //filter if a search param was provided
        onSearch(mSearch);
    }

    private void configAdapter() {
        //our popup on touch
        mAdapter.withOnTouchListener((v, motionEvent, adapter, item, position) -> {
            int a = motionEvent.getAction();
            if (a == MotionEvent.ACTION_DOWN) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
                IconicsDrawable icon = new IconicsDrawable(v.getContext())
                        .icon(item.getIcon())
                        .size(IconicsSize.dp(144))
                        .padding(IconicsSize.dp(8))
                        .backgroundColor(IconicsColor.parse("#DDFFFFFF"))
                        .roundedCorners(IconicsSize.dp(12));
                ImageView imageView = new ImageView(v.getContext());
                imageView.setImageDrawable(
                        icon
                );
                int size = (int) UIUtils.convertDpToPixel(144, v.getContext());
                mPopup = new PopupWindow(imageView, size, size);
                mPopup.showAsDropDown(v);

                //copy to clipboard
                ClipboardManager clipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Android-Iconics icon", icon.getIcon().getFormattedName());
                clipboard.setPrimaryClip(clip);
            } else if (a == MotionEvent.ACTION_UP || a == MotionEvent.ACTION_CANCEL || a == MotionEvent.ACTION_OUTSIDE) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
            }
            return false;
        });

        mAdapter.withOnBindViewHolderListener(new OnBindViewHolderListener() {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, List payloads) {
                IconItem.ViewHolder holder = (IconItem.ViewHolder) viewHolder;

                IconItem item = mAdapter.getItem(position);

                if (item != null) {
                    //set the R.id.fastadapter_item tag of this item to the item object (can be used when retrieving the view)
                    viewHolder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item, item);

                    //as we overwrite the default listener
                    item.bindView(holder, payloads);

                    if (mRandomize) {
                        holder.image.getIcon()
                                .color(IconicsColor.colorRes(getRandomColor(position)))
                                .padding(IconicsSize.dp(mRandom.nextInt(12)))
                                .contourWidth(IconicsSize.dp(mRandom.nextInt(2)))
                                .contourColor(IconicsColor.colorInt(getRandomColor(position - 2)));


                        int y = mRandom.nextInt(10);
                        if (y % 4 == 0) {
                            holder.image.getIcon()
                                    .backgroundColor(IconicsColor.colorRes(getRandomColor(position - 4)))
                                    .roundedCorners(IconicsSize.dp(2 + mRandom.nextInt(10)));
                        }
                    }

                    if (mShadow) {
                        holder.image.getIcon().enableShadowSupport(holder.image);
                        //holder.image.getIcon().shadowDp(1, 1, 1, Color.argb(200, 0, 0, 0));
                        holder.image.getIcon()
                                .shadowRadius(IconicsSize.dp(1))
                                .shadowDelta(IconicsSize.dp(1))
                                .shadowColor(IconicsColor.colorInt(Color.argb(200, 0, 0, 0)));
                    }
                }
            }

            @Override
            public void unBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
                IconItem item = (IconItem) viewHolder.itemView.getTag(com.mikepenz.fastadapter.R.id.fastadapter_item);
                if (item != null) {
                    item.unbindView((IconItem.ViewHolder) viewHolder);
                    //remove set tag's
                    viewHolder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item, null);
                    viewHolder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item_adapter, null);
                } else {
                    Log.e("FastAdapter", "The bindView method of this item should set the `Tag` on its itemView (https://github.com/mikepenz/FastAdapter/blob/develop/library-core/src/main/java/com/mikepenz/fastadapter/items/AbstractItem.java#L189)");
                }
            }

            @Override
            public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, int position) {

            }

            @Override
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder, int position) {

            }

            @Override
            public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder, int position) {
                return false;
            }
        });
    }

    void onSearch(String s) {
        mSearch = s;

        if (mAdapter != null) {
            if (TextUtils.isEmpty(s)) {
                mAdapter.clear();
                mAdapter.setNewList(mIcons);
            } else {
                AbstractList<IconItem> tmpList = new ArrayList<>();
                for (IconItem icon : mIcons) {
                    if (icon.getIcon().toLowerCase().contains(s.toLowerCase())) {
                        tmpList.add(icon);
                    }
                }
                mAdapter.setNewList(tmpList);
            }
        }
    }


    private int getRandomColor(int i) {
        //make sure w are > 0
        if (i < 0) {
            i = i * (-1);
        }

        //get a random color
        if (i % 10 == 0) {
            return R.color.md_black_1000;
        } else if (i % 10 == 1) {
            return R.color.md_blue_500;
        } else if (i % 10 == 2) {
            return R.color.md_green_500;
        } else if (i % 10 == 3) {
            return R.color.md_red_500;
        } else if (i % 10 == 4) {
            return R.color.md_orange_500;
        } else if (i % 10 == 5) {
            return R.color.md_pink_500;
        } else if (i % 10 == 6) {
            return R.color.md_amber_500;
        } else if (i % 10 == 7) {
            return R.color.md_blue_grey_500;
        } else if (i % 10 == 8) {
            return R.color.md_orange_500;
        } else if (i % 10 == 9) {
            return R.color.md_yellow_500;
        }

        return 0;
    }
}

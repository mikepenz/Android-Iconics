package com.mikepenz.iconics.sample;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
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
    private ArrayList<IconItem> icons = new ArrayList<>();
    private FastItemAdapter<IconItem> mAdapter;
    private boolean randomize;
    private String search;
    private PopupWindow popup;
    private Random random = new Random();

    public static IconsFragment newInstance(String fontName) {
        Bundle bundle = new Bundle();

        IconsFragment fragment = new IconsFragment();
        bundle.putString(FONT_NAME, fontName);
        fragment.setArguments(bundle);

        return fragment;
    }

    public void randomize(boolean randomize) {
        this.randomize = randomize;
        if (this.mAdapter != null) {
            this.mAdapter.notifyAdapterDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icons_fragment, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init and Setup RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
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
                            icons.add(new IconItem(icon));
                        }
                        mAdapter.set(icons);
                        break;
                    }
                }
            }
        }
        //filter if a search param was provided
        onSearch(search);
    }

    private void configAdapter() {
        //our popup on touch
        mAdapter.withOnTouchListener(new FastAdapter.OnTouchListener<IconItem>() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent, IAdapter<IconItem> adapter, IconItem item, int position) {
                int a = motionEvent.getAction();
                if (a == MotionEvent.ACTION_DOWN) {
                    if (popup != null && popup.isShowing()) {
                        popup.dismiss();
                    }
                    IconicsDrawable icon = new IconicsDrawable(v.getContext()).icon(item.getIcon()).sizeDp(144).paddingDp(8).backgroundColor(Color.parseColor("#DDFFFFFF")).roundedCornersDp(12);
                    ImageView imageView = new ImageView(v.getContext());
                    imageView.setImageDrawable(
                            icon
                    );
                    int size = (int) UIUtils.convertDpToPixel(144, v.getContext());
                    popup = new PopupWindow(imageView, size, size);
                    popup.showAsDropDown(v);

                    //copy to clipboard
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(icon.getIcon().getFormattedName());
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Android-Iconics icon", icon.getIcon().getFormattedName());
                        clipboard.setPrimaryClip(clip);
                    }
                } else if (a == MotionEvent.ACTION_UP || a == MotionEvent.ACTION_CANCEL || a == MotionEvent.ACTION_OUTSIDE) {
                    if (popup != null && popup.isShowing()) {
                        popup.dismiss();
                    }
                }
                return false;
            }
        });

        mAdapter.withOnBindViewHolderListener(new FastAdapter.OnBindViewHolderListener() {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, List payloads) {
                IconItem.ViewHolder holder = (IconItem.ViewHolder) viewHolder;

                //as we overwrite the default listener
                mAdapter.getItem(position).bindView(holder, payloads);

                if (randomize) {
                    holder.image.setColorRes(getRandomColor(position));
                    holder.image.setPaddingDp(random.nextInt(12));

                    holder.image.setContourWidthDp(random.nextInt(2));
                    holder.image.setContourColor(getRandomColor(position - 2));


                    int y = random.nextInt(10);
                    if (y % 4 == 0) {
                        holder.image.setBackgroundColorRes(getRandomColor(position - 4));
                        holder.image.setRoundedCornersDp(2 + random.nextInt(10));
                    }
                }
            }
        });
    }

    void onSearch(String s) {
        search = s;

        if (mAdapter != null) {
            if (TextUtils.isEmpty(s)) {
                mAdapter.clear();
                mAdapter.setNewList(icons);
            } else {
                AbstractList<IconItem> tmpList = new ArrayList<>();
                for (IconItem icon : icons) {
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

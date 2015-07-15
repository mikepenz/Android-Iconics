package com.mikepenz.iconics.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.adapter.IconAdapter;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.ArrayList;

/**
 * Created by a557114 on 16/04/2015.
 */
public class IconsFragment extends Fragment {

    private static final String FONT_NAME = "FONT_NAME";
    private ArrayList<String> icons = new ArrayList<String>();

    public static IconsFragment newInstance(String fontName) {
        Bundle bundle = new Bundle();

        IconsFragment fragment = new IconsFragment();

        bundle.putString(FONT_NAME, fontName);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icons_fragment, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init and Setup RecyclerView
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //animator not yet working
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        IconAdapter mAdapter = new IconAdapter(new ArrayList<String>(), R.layout.row_icon);
        mRecyclerView.setAdapter(mAdapter);

        if (getArguments() != null) {
            String fontName = getArguments().getString(FONT_NAME);

            for (ITypeface iTypeface : Iconics.getRegisteredFonts()) {
                if (iTypeface.getFontName().equalsIgnoreCase(fontName)) {
                    if (iTypeface.getIcons() != null) {
                        for (String icon : iTypeface.getIcons()) {
                            icons.add(icon);
                        }
                        mAdapter.setIcons(icons);
                        break;
                    }
                }
            }
        }

    }
}

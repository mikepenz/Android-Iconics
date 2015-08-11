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

package com.mikepenz.iconics.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.iconics.sample.R;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;
import java.util.Random;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private Random random = new Random();
    private boolean randomize;
    private List<String> icons;
    private int rowLayout;


    public IconAdapter(boolean randomize, List<String> icons, int rowLayout) {
        this.randomize = randomize;
        this.icons = icons;
        this.rowLayout = rowLayout;
    }


    public void setIcons(boolean randomize, List<String> icons) {
        this.randomize = randomize;
        this.icons.addAll(icons);
        this.notifyItemRangeInserted(0, icons.size() - 1);
    }

    public void setRandomized(boolean randomize) {
        this.randomize = randomize;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final String icon = icons.get(i);
        viewHolder.image.setIcon(icon);
        viewHolder.name.setText(icon);

        if (randomize) {

            viewHolder.image.setColorRes(getRandomColor(i));
            viewHolder.image.setPaddingDp(random.nextInt(12));

            viewHolder.image.setContourWidthDp(random.nextInt(2));
            viewHolder.image.setContourColor(getRandomColor(i - 2));


            int y = random.nextInt(10);
            if (y % 4 == 0) {
                viewHolder.image.setBackgroundColorRes(getRandomColor(i - 4));
                viewHolder.image.setRoundedCornersDp(2 + random.nextInt(10));
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


    @Override
    public int getItemCount() {
        return icons == null ? 0 : icons.size();
    }


    public void clear() {
        icons.clear();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public IconicsImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (IconicsImageView) itemView.findViewById(R.id.icon);
        }

    }
}

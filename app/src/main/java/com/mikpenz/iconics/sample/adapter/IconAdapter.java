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

package com.mikpenz.iconics.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikpenz.iconics.IconicsDrawable;
import com.mikpenz.iconics.sample.MainActivity;
import com.mikpenz.iconics.sample.R;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private List<String> icons;
    private int rowLayout;
    private MainActivity mAct;

    public IconAdapter(List<String> icons, int rowLayout, MainActivity act) {
        this.icons = icons;
        this.rowLayout = rowLayout;
        this.mAct = act;
    }

    public void setIcons(List<String> icons) {
        this.icons = icons;
        this.notifyItemRangeInserted(0, icons.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final String icon = icons.get(i);

        IconicsDrawable id = new IconicsDrawable(mAct, icon);

        viewHolder.image.setImageDrawable(id);
        viewHolder.name.setText(icon);
    }

    @Override
    public int getItemCount() {
        return icons == null ? 0 : icons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.icon);
        }

    }
}

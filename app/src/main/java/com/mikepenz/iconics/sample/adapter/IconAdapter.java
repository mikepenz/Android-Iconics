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
import com.mikepenz.iconics.view.IconicsImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.iconics.sample.R;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private List<String> icons;
    private int rowLayout;

    public IconAdapter(List<String> icons, int rowLayout) {
        this.icons = icons;
        this.rowLayout = rowLayout;
    }

    public void setIcons(List<String> icons) {
        this.icons.addAll(icons);
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
        viewHolder.image.setIcon(icon);
        viewHolder.name.setText(icon);
    }

    @Override
    public int getItemCount() {
        return icons == null ? 0 : icons.size();
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

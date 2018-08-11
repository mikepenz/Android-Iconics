package com.mikepenz.iconics.sample.item;

import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.sample.R;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

/**
 * Created by mikepenz on 26.07.16.
 */

public class IconItem extends AbstractItem<IconItem, IconItem.ViewHolder> {
    private String icon;

    public String getIcon() {
        return icon;
    }

    public IconItem withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public IconItem(String icon) {
        this.icon = icon;
    }

    @Override
    public int getType() {
        return R.id.item_row_icon;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_icon;
    }

    @Override
    public void bindView(ViewHolder holder, List payloads) {
        super.bindView(holder, payloads);

        holder.image.setIcon(new IconicsDrawable(holder.image.getContext(), icon));
        holder.name.setText(icon);

        holder.image.getIcon().color(Color.BLACK);
        holder.image.getIcon().paddingDp(0);
        holder.image.getIcon().contourWidthDp(0);
        holder.image.getIcon().contourColor(Color.TRANSPARENT);
        holder.image.setBackgroundColor(Color.TRANSPARENT);

        //as we want to respect the bounds of the original font in the icon list
        holder.image.getIcon().respectFontBounds(true);
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public IconicsImageView image;


        ViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.icon);
        }
    }
}

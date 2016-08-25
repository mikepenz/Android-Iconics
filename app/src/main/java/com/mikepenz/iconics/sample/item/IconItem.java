package com.mikepenz.iconics.sample.item;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.iconics.sample.R;
import com.mikepenz.iconics.view.IconicsImageView;

import java.util.List;

/**
 * Created by mikepenz on 26.07.16.
 */

public class IconItem extends AbstractItem<IconItem, IconItem.ViewHolder> {
    //the static ViewHolderFactory which will be used to generate the ViewHolder for this Item
    private static final ViewHolderFactory<? extends ViewHolder> FACTORY = new ItemFactory();

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

        holder.image.setIcon(icon);
        holder.name.setText(icon);

        holder.image.setColor(Color.BLACK);
        holder.image.setPaddingDp(0);
        holder.image.setContourWidthDp(0);
        holder.image.setContourColor(Color.TRANSPARENT);
        holder.image.setBackgroundColor(Color.TRANSPARENT);

        //as we want to respect the bounds of the original font in the icon list
        holder.image.getIcon().respectFontBounds(true);
    }

    /**
     * our ItemFactory implementation which creates the ViewHolder for our adapter.
     * It is highly recommended to implement a ViewHolderFactory as it is 0-1ms faster for ViewHolder creation,
     * and it is also many many times more efficient if you define custom listeners on views within your item.
     */
    protected static class ItemFactory implements ViewHolderFactory<ViewHolder> {
        public ViewHolder create(View v) {
            return new ViewHolder(v);
        }
    }

    /**
     * return our ViewHolderFactory implementation here
     *
     * @return
     */
    @Override
    public ViewHolderFactory<? extends ViewHolder> getFactory() {
        return FACTORY;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public IconicsImageView image;


        ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (IconicsImageView) itemView.findViewById(R.id.icon);
        }
    }
}

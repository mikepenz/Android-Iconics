/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.sample.item

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.sample.R
import com.mikepenz.iconics.sample.utils.getThemeColor
import com.mikepenz.iconics.utils.colorInt
import com.mikepenz.iconics.utils.contourColorInt
import com.mikepenz.iconics.utils.contourWidthDp
import com.mikepenz.iconics.utils.paddingDp
import com.mikepenz.iconics.view.IconicsImageView

/**
 * Created by mikepenz on 26.07.16.
 */

class IconItem(icon: String) : AbstractItem<IconItem.ViewHolder>() {
    var icon: String? = null
        private set

    fun withIcon(icon: String): IconItem {
        this.icon = icon
        return this
    }

    init {
        this.icon = icon
    }

    override val layoutRes: Int
        get() = R.layout.row_icon

    override val type: Int
        get() = R.id.item_row_icon

    override fun bindView(holder: ViewHolder, payloads: List<Any>) {
        super.bindView(holder, payloads)

        val ctx = holder.image.context
        val icon = IconicsDrawable(ctx, this.icon ?: " ")
        holder.image.icon = icon
        holder.name.text = this.icon

        icon.apply {
            colorInt = ctx.getThemeColor(android.R.attr.textColorPrimary)
            paddingDp = 0
            contourWidthDp = 0
            contourColorInt = Color.TRANSPARENT
            respectFontBounds = true
        }

        holder.image.setBackgroundColor(Color.TRANSPARENT)
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var image: IconicsImageView = itemView.findViewById(R.id.icon)
    }
}

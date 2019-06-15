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

package com.mikepenz.iconics.sample

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListener
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.sample.item.IconItem
import com.mikepenz.iconics.utils.IconicsUtils
import com.mikepenz.iconics.utils.backgroundColorRes
import com.mikepenz.iconics.utils.backgroundColorString
import com.mikepenz.iconics.utils.colorRes
import com.mikepenz.iconics.utils.contourColorRes
import com.mikepenz.iconics.utils.contourWidthDp
import com.mikepenz.iconics.utils.enableShadowSupport
import com.mikepenz.iconics.utils.paddingDp
import com.mikepenz.iconics.utils.roundedCornersDp
import com.mikepenz.iconics.utils.sizeDp
import kotlinx.android.synthetic.main.icons_fragment.list
import java.util.ArrayList
import java.util.Random
import kotlin.math.abs

/**
 * Created by a557114 on 16/04/2015.
 */
class IconsFragment : Fragment() {
    private val random = Random()
    private val icons = ArrayList<IconItem>()
    private val adapter by lazy { FastItemAdapter<IconItem>() }
    private var randomize: Boolean = false
    private var shadow: Boolean = false
    private var search: String? = null
    private lateinit var popup: PopupWindow

    fun randomize(randomize: Boolean) {
        this.randomize = randomize
        adapter.notifyAdapterDataSetChanged()
    }

    fun shadow(shadow: Boolean) {
        this.shadow = shadow
        adapter.notifyAdapterDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.icons_fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init and Setup RecyclerView
        list.apply {
            layoutManager = GridLayoutManager(activity, 2)
            addItemDecoration(SpaceItemDecoration())
            //animator not yet working
            itemAnimator = DefaultItemAnimator()
            configAdapter()
            adapter = this@IconsFragment.adapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    dismissPopup()
                }
            })
        }

        arguments?.let { arguments ->
            arguments.getString(FONT_NAME).let { fontName ->
                icons.clear()
                Iconics.getRegisteredFonts(context)
                        .firstOrNull { it.fontName.equals(fontName, true) }
                        ?.let { iTypeface ->
                            val iconItems = iTypeface.icons.asSequence().map(::IconItem)

                            icons.addAll(iconItems)
                            adapter.set(icons)
                        }
            }
        }
        //filter if a search param was provided
        onSearch(search)
    }

    private fun configAdapter() {
        //our popup on touch
        adapter.onClickListener = { v, _, item, _ ->
            dismissPopup()

            val ctx = v?.context
            if (ctx != null) {
                val i = item.icon
                if (i != null) {
                    val icon = IconicsDrawable(ctx)
                            .icon(i)
                            .sizeDp(144)
                            .paddingDp(8)
                            .backgroundColorString("#DDFFFFFF")
                            .roundedCornersDp(12)

                    ImageView(ctx).let { imageView ->
                        imageView.setImageDrawable(icon)

                        if (!::popup.isInitialized) {
                            val size = IconicsUtils.convertDpToPx(ctx, 144)

                            PopupWindow(size, size).let { popup ->
                                this@IconsFragment.popup = popup
                            }
                        }
                        popup.contentView = imageView
                        popup.showAsDropDown(v)
                    }

                    //copy to clipboard
                    (ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).run {
                        setPrimaryClip(
                            ClipData.newPlainText(
                                "Android-Iconics icon",
                                icon.icon?.formattedName
                            )
                        )
                    }
                }
            }
            false
        }

        adapter.onBindViewHolderListener = object : OnBindViewHolderListener {

            override fun onBindViewHolder(
                viewHolder: RecyclerView.ViewHolder,
                position: Int,
                payloads: MutableList<Any>
            ) {
                val holder = viewHolder as IconItem.ViewHolder

                val item = adapter.getItem(position)

                if (item != null) {
                    //set the R.id.fastadapter_item tag of this item to the item object (can be used when retrieving the view)
                    holder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item, item)

                    //as we overwrite the default listener
                    item.bindView(holder, payloads)


                    holder.image.icon?.let {
                        if (randomize) {
                            it.colorRes(getRandomColor(position))
                                    .paddingDp(random.nextInt(12))
                                    .contourWidthDp(random.nextInt(2))
                                    .contourColorRes(getRandomColor(position - 2))

                            val y = random.nextInt(10)
                            if (y % 4 == 0) {
                                it.backgroundColorRes(getRandomColor(position - 4))
                                        .roundedCorners(IconicsSize.dp((2 + random.nextInt(10))))
                            }
                        }
                    }

                    if (shadow) {
                        holder.image.enableShadowSupport()
                        //holder.image.getIcon().shadowDp(1, 1, 1, Color.argb(200, 0, 0, 0));
                        holder.image.icon?.shadow(
                            radius = IconicsSize.dp(1),
                            dx = IconicsSize.dp(1),
                            dy = IconicsSize.dp(1),
                            color = IconicsColor.colorInt(Color.argb(200, 0, 0, 0))
                        )
                    }
                }
            }

            override fun unBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
                val item =
                        viewHolder.itemView.getTag(com.mikepenz.fastadapter.R.id.fastadapter_item) as IconItem
                item.unbindView(viewHolder as IconItem.ViewHolder)
                //remove set tag's
                viewHolder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item, null)
                viewHolder.itemView.setTag(
                    com.mikepenz.fastadapter.R.id.fastadapter_item_adapter,
                    null
                )
            }

            override fun onFailedToRecycleView(
                viewHolder: RecyclerView.ViewHolder,
                position: Int
            ): Boolean {
                return false
            }

            override fun onViewAttachedToWindow(
                viewHolder: RecyclerView.ViewHolder,
                position: Int
            ) {
            }

            override fun onViewDetachedFromWindow(
                viewHolder: RecyclerView.ViewHolder,
                position: Int
            ) {
            }
        }
    }

    internal fun onSearch(s: String?) {
        search = s

        if (s.isNullOrBlank()) {
            adapter.clear()
            adapter.setNewList(icons)
        } else {
            val tmpList = icons.filter { it.icon?.contains(s, true) == true }
            adapter.setNewList(tmpList)
        }
    }

    private fun dismissPopup() {
        if (::popup.isInitialized && popup.isShowing) {
            popup.dismiss()
        }
    }

    private fun getRandomColor(i: Int): Int {
        //get a random color
        return when (abs(i) % 10) {
            0 -> R.color.md_black_1000
            1 -> R.color.md_blue_500
            2 -> R.color.md_green_500
            3 -> R.color.md_red_500
            4 -> R.color.md_orange_500
            5 -> R.color.md_pink_500
            6 -> R.color.md_amber_500
            7 -> R.color.md_blue_grey_500
            8 -> R.color.md_orange_500
            9 -> R.color.md_yellow_500
            else -> 0
        }
    }

    companion object {

        private const val FONT_NAME = "FONT_NAME"

        fun newInstance(fontName: String): IconsFragment {
            return IconsFragment().apply {
                arguments = bundleOf(FONT_NAME to fontName)
            }
        }
    }
}

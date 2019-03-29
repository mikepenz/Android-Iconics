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
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListener
import com.mikepenz.fastadapter.listeners.OnTouchListener
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.sample.item.IconItem
import com.mikepenz.iconics.utils.IconicsUtils
import com.mikepenz.iconics.utils.toIconicsColor
import com.mikepenz.iconics.utils.toIconicsColorRes
import com.mikepenz.iconics.utils.toIconicsSizeDp
import com.mikepenz.materialize.util.UIUtils
import kotlinx.android.synthetic.main.icons_fragment.list
import java.util.ArrayList
import java.util.Random
import kotlin.math.abs

/**
 * Created by a557114 on 16/04/2015.
 */
class IconsFragment : Fragment() {
    private val mIcons = ArrayList<IconItem>()
    private lateinit var mAdapter: FastItemAdapter<IconItem>
    private var mRandomize: Boolean = false
    private var mShadow: Boolean = false
    private var mSearch: String? = null
    private var popup: PopupWindow? = null
    private val mRandom = Random()

    fun randomize(randomize: Boolean) {
        mRandomize = randomize
        if (::mAdapter.isInitialized) {
            mAdapter.notifyAdapterDataSetChanged()
        }
    }

    fun shadow(shadow: Boolean) {
        mShadow = shadow
        if (::mAdapter.isInitialized) {
            mAdapter.notifyAdapterDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.icons_fragment, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init and Setup RecyclerView
        val recyclerView = list
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.addItemDecoration(SpaceItemDecoration())
        //animator not yet working
        recyclerView.itemAnimator = DefaultItemAnimator()
        mAdapter = FastItemAdapter()
        configAdapter()
        recyclerView.adapter = mAdapter

        arguments?.let { arguments ->
            arguments.getString(FONT_NAME).let { fontName ->
                for (iTypeface in Iconics.registeredFonts) {
                    if (iTypeface.fontName.equals(fontName, ignoreCase = true)) {
                        for (icon in iTypeface.icons) {
                            mIcons.add(IconItem(icon))
                        }
                        mAdapter.set(mIcons)
                        break
                    }
                }
            }
        }
        //filter if a search param was provided
        onSearch(mSearch)
    }

    private fun configAdapter() {
        //our popup on touch
        mAdapter.onTouchListener = object : OnTouchListener<IconItem> {
            override fun onTouch(
                v: View,
                event: MotionEvent,
                adapter: IAdapter<IconItem>,
                item: IconItem,
                position: Int
            ): Boolean {
                val a = event.action
                if (a == MotionEvent.ACTION_DOWN) {
                    if (popup?.isShowing == true) {
                        popup?.dismiss()
                    }

                    val i = item.icon ?: return false
                    val icon = IconicsDrawable(v.context)
                            .icon(i)
                            .size(IconicsSize.dp(144f))
                            .padding(IconicsSize.dp(8f))
                            .backgroundColor("#DDFFFFFF".toIconicsColor())
                            .roundedCorners(IconicsSize.dp(12f))
                    val imageView = ImageView(v.context)
                    imageView.setImageDrawable(
                        icon
                    )
                    val size = UIUtils.convertDpToPixel(144f, v.context).toInt()
                    val popup = PopupWindow(imageView, size, size)
                    this@IconsFragment.popup = popup
                    popup.showAsDropDown(v)

                    //copy to clipboard
                    val clipboard =
                            v.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip =
                            ClipData.newPlainText("Android-Iconics icon", icon.icon?.formattedName)
                    clipboard.primaryClip = clip
                } else if (a == MotionEvent.ACTION_UP || a == MotionEvent.ACTION_CANCEL || a == MotionEvent.ACTION_OUTSIDE) {
                    if (popup?.isShowing == true) {
                        popup?.dismiss()
                    }
                }
                return false
            }
        }


        mAdapter.onBindViewHolderListener = object : OnBindViewHolderListener {

            override fun onBindViewHolder(
                viewHolder: RecyclerView.ViewHolder,
                position: Int,
                payloads: MutableList<Any>
            ) {
                val holder = viewHolder as IconItem.ViewHolder

                val item = mAdapter.getItem(position)

                if (item != null) {
                    //set the R.id.fastadapter_item tag of this item to the item object (can be used when retrieving the view)
                    viewHolder.itemView.setTag(com.mikepenz.fastadapter.R.id.fastadapter_item, item)

                    //as we overwrite the default listener
                    item.bindView(holder, payloads)


                    holder.image.icon?.let {
                        if (mRandomize) {
                            it.color(getRandomColor(position).toIconicsColorRes())
                                    .padding(mRandom.nextInt(12).toIconicsSizeDp())
                                    .contourWidth(mRandom.nextInt(2).toIconicsSizeDp())
                                    .contourColor(getRandomColor(position - 2).toIconicsColor())

                            val y = mRandom.nextInt(10)
                            if (y % 4 == 0) {
                                it.backgroundColor(getRandomColor(position - 4).toIconicsColorRes())
                                        .roundedCorners((2 + mRandom.nextInt(10)).toIconicsSizeDp())
                            }
                        }
                    }

                    if (mShadow) {
                        IconicsUtils.enableShadowSupport(holder.image)
                        //holder.image.getIcon().shadowDp(1, 1, 1, Color.argb(200, 0, 0, 0));
                        holder.image.icon?.shadow(
                            radius = 1.toIconicsSizeDp(),
                            dx = 1.toIconicsSizeDp(),
                            dy = 1.toIconicsSizeDp(),
                            color = Color.argb(200, 0, 0, 0).toIconicsColor()
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
        mSearch = s
        
        if (::mAdapter.isInitialized) {
            if (TextUtils.isEmpty(s)) {
                mAdapter.clear()
                mAdapter.setNewList(mIcons)
            } else {
                val tmpList = ArrayList<IconItem>()
                for (icon in mIcons) {
                    val i = icon.icon ?: continue
                    if (i.toLowerCase().contains(s?.toLowerCase() ?: "")) {
                        tmpList.add(icon)
                    }
                }
                mAdapter.setNewList(tmpList)
            }
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
                arguments = Bundle().apply { putString(FONT_NAME, fontName) }
            }
        }
    }
}

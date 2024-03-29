package com.ethan.demo.adapter

import android.content.Context
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.ethan.demo.R
class ViewPagerAdapter: BaseQuickAdapter<String, QuickViewHolder>() {
    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: String?) {
        holder.setText(R.id.item_tv,item?:"")
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): QuickViewHolder = QuickViewHolder(R.layout.item_view_pager, parent = parent)
}
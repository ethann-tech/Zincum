package com.ethan.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.DataBindingHolder
import com.ethan.demo.bean.MainItemBean
import com.ethan.demo.databinding.ItemMainBinding
import com.ethan.demo.ui.activity.ActivityExtension
import com.ethan.demo.ui.activity.ActivityLoading
import com.ethan.demo.ui.activity.ActivityResendMsg
import com.ethan.demo.ui.activity.ActivityStepNavBar
import com.ethan.demo.ui.activity.ActivityStickyHome
import com.ethan.demo.ui.activity.ActivityTest
import com.ethan.demo.ui.activity.ActivityTimeUtil
import com.ethan.demo.ui.activity.ActivityVerificationCode
import com.ethan.zincum.helper.SlideHelper
import com.ethan.zincum.toast.Toast
import com.ethan.zincum.widget.SideslipLayout
import com.ethan.zincum.widget.SideslipLayout.OnStateChangeListener


class MainAdapter : BaseQuickAdapter<MainItemBean, DataBindingHolder<ItemMainBinding>>() {
    private var mSlideHelper: SlideHelper = SlideHelper()


    override fun onBindViewHolder(holder: DataBindingHolder<ItemMainBinding>, position: Int, item: MainItemBean?) {
        item?.let {
            holder.binding.itemMainText.text = item.toString()
            holder.binding.layoutSides.setOpen(it.open, false)
            holder.binding.tvStick.setOnClickListener { view ->
                Toast.makeText(view.context, item.toString(), Toast.LENGTH_SHORT).show()
            }
            holder.binding.tvDelete.setOnClickListener { view ->
                Toast.makeText(view.context, item.toString(), Toast.LENGTH_SHORT).show()
            }

            holder.binding.layoutSides.setOnStateChangeListener(object : OnStateChangeListener() {
                override fun onInterceptTouchEvent(layout: SideslipLayout): Boolean {
                    val result = mSlideHelper.closeAll(layout)
                    return false
                }
                override fun onStateChanged(layout: SideslipLayout, open: Boolean) {
                    item.open = open
                    mSlideHelper.onStateChanged(layout = layout, open = open)
                }
            })
            holder.binding.layoutContent.setOnClickListener {view->
                when (position) {
                    0 -> ActivityStepNavBar.jump(view.context)
                    1 -> ActivityResendMsg.jump(view.context)
                    2 -> ActivityVerificationCode.jump(view.context)
                    3 -> ActivityTimeUtil.jump(view.context)
                    4 -> ActivityStickyHome.jump(view.context)
                    5 -> ActivityLoading.jump(view.context)
                    6 -> ActivityTest.jump(view.context)
                    7 -> ActivityExtension.jump(view.context)
                }
            }

        }
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): DataBindingHolder<ItemMainBinding> = DataBindingHolder(ItemMainBinding.inflate(LayoutInflater.from(context), parent, false))


}
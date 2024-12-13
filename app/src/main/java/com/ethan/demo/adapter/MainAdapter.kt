package com.ethan.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.DataBindingHolder
import com.ethan.demo.bean.MainItemBean
import com.ethan.demo.databinding.ItemMainBinding
import com.ethan.demo.ui.activity.ActivityContextExt
import com.ethan.demo.ui.activity.ActivityExtension
import com.ethan.demo.ui.activity.ActivityLoading
import com.ethan.demo.ui.activity.ActivityResendMsg
import com.ethan.demo.ui.activity.ActivityStepNavBar
import com.ethan.demo.ui.activity.ActivityStickyHome
import com.ethan.demo.ui.activity.ActivityTest
import com.ethan.demo.ui.activity.ActivityTextView
import com.ethan.demo.ui.activity.ActivityTimeUtil
import com.ethan.demo.ui.activity.ActivityVerificationCode
import com.ethan.zincum.base.ActivityCore
import com.ethan.zincum.helper.SlideHelper
import com.ethan.zincum.toast.Toast
import com.ethan.zincum.widget.SideslipLayout
import com.ethan.zincum.widget.SideslipLayout.OnStateChangeListener


class MainAdapter : BaseQuickAdapter<MainItemBean, DataBindingHolder<ItemMainBinding>>() {
    private var mSlideHelper: SlideHelper = SlideHelper()


    override fun onBindViewHolder(holder: DataBindingHolder<ItemMainBinding>, position: Int, item: MainItemBean?) {
        item?.let {
            holder.binding.itemMainText.text = item.text
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
            holder.binding.layoutContent.setOnClickListener { view ->
                when (position) {
                    0 -> ActivityCore.jump(context = view.context, cls = ActivityStepNavBar::class.java)
                    1 -> ActivityCore.jump(context = view.context, cls = ActivityResendMsg::class.java)
                    2 -> ActivityCore.jump(context = view.context, cls = ActivityVerificationCode::class.java)
                    3 -> ActivityCore.jump(context = view.context, cls = ActivityTimeUtil::class.java)
                    4 -> ActivityCore.jump(context = view.context, cls = ActivityStickyHome::class.java)
                    5 -> ActivityCore.jump(context = view.context, cls = ActivityLoading::class.java)
                    6 -> ActivityCore.jump(context = view.context, cls = ActivityTest::class.java)
                    7 -> ActivityCore.jump(context = view.context, cls = ActivityExtension::class.java)
                    8 -> ActivityCore.jump(context = view.context, cls = ActivityContextExt::class.java)
                    9 -> ActivityCore.jump(context = view.context, cls = ActivityTextView::class.java)
                }
            }
        }
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): DataBindingHolder<ItemMainBinding> = DataBindingHolder(ItemMainBinding.inflate(LayoutInflater.from(context), parent, false))


}
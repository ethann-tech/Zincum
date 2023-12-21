package com.ethan.zincum.listener

import android.view.View
import java.util.*

/**
 * @author: ethan
 * @email: ethan.nj@qq.com
 * @modify_author:
 * @modify_date: 2021年4月28日
 * @description:
 * @date: 2021年4月28日
 */
abstract class OnNoDoubleClickListener(val delayTime:Int=1000) : View.OnClickListener {
    private var lastClickTime: Long = 0
    override fun onClick(v: View) {
        val currentTime = Calendar.getInstance().timeInMillis
        if (currentTime - lastClickTime > delayTime) {
            lastClickTime = currentTime
            onNoDoubleClick(v)
        }
    }

    /**
     * 结果回调方法
     * @param v 被点击对象
     */
    abstract fun onNoDoubleClick(v: View)


}



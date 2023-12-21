package com.ethan.zincum.listener

import android.os.SystemClock
import android.view.View
import io.github.uhsk.kit.isTrue

/**
 *
 * @author: ethan
 * @email: ethann@petalmail.com
 * @description: 指定时间内多次点击指定次数
 * @date: 2023年12月15日
 */
abstract class OnMultiClickListener(val clickCount: Int = 7, private val clickDuration: Long = 3500, private val isClearHits: Boolean = false) : View.OnClickListener {

    private var mHits = LongArray(clickCount)
    override fun onClick(v: View) { // 实现左移，然后最后一个位置更新距离开机的时间，如果最后一个时间和最开始时间小于DURATION，即连续7次点击
        System.arraycopy(mHits, 1, mHits, 0, mHits.size - 1)
        mHits[mHits.size - 1] = SystemClock.uptimeMillis()
        if (mHits[0] >= (SystemClock.uptimeMillis() - clickDuration)) {
            onMultiClick(v)
            isClearHits.isTrue {
                mHits = LongArray(clickCount)
            }
        }
    }

    abstract fun onMultiClick(v: View)
}
package io.github.uhsk.kit.android.view

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import com.ethan.zincum.listener.OnMultiClickListener
import com.ethan.zincum.listener.OnNoDoubleClickListener

fun View.setOnNoDoubleClickListener(delayTime: Int = 1000, listener: (view: View) -> Unit) {
    this.setOnClickListener(object : OnNoDoubleClickListener(delayTime = delayTime) {
        override fun onNoDoubleClick(v: View) {
            listener(v)
        }
    })
}

/**
 * 在指定的时间内连续点击给定的次数
 * @param clickCount 点击次数
 * @param clickDuration 连续点击的时间 毫秒
 * @param listener 点击回调
 */
fun View.setOnMultiClickListener(clickCount: Int = 7, clickDuration: Long = 3500,isClearHits:Boolean=false, listener: (view: View) -> Unit) {
    this.setOnClickListener(object : OnMultiClickListener(clickCount = clickCount, clickDuration = clickDuration,isClearHits=isClearHits) {
        override fun onMultiClick(v: View) {
            listener(v)
        }
    })
}

/**
 * View是否显示 true 显示，false 不显示
 *
 * @since 1.0.2
 * @author ethan
 */
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

/**
 * Vie是否显示 0 显示，非0不显示
 * @since 1.0.2
 * @author ethan
 */
fun View.setVisible(visible: Int) {
    visibility = if (visible == 0) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

/**
 * @since 1.0.2
 * @author ethan
 */
fun View.setInVisible(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

/**
 * 0 可见 非0 不可见 但会占用空间
 * @since 1.0.2
 * @author ethan
 */
fun View.setInVisible(visible: Int) {
    visibility = if (visible == 0) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

var TextView.textColor: Int
    get() = this.textColors.defaultColor
    set(value) {
        this.setTextColor(this.context.getColor(value))
    }


/**
 * 给View设置背景颜色
 * 常见的控件都是继承View,所以都能用
 */
var View.backgroundColor: Int
    get() = (this.background as ColorDrawable).color
    set(value) {
        this.setBackgroundColor(this.context.getColor(value))
    }

/**
 * 给View设置drawable和mipmap资源
 * 常见的控件都是继承View,所以都能用
 */
var View.backgroundResource: Int
    //get方法无意义返回0
    get() = 0
    @NonNull set(value) {
        this.setBackgroundResource(value)
    }

var View.backgroundDrawable: Drawable
    get() = this.background
    set(value) {
        this.background = value
    }


/**
 * 给ImageView设置drawable和mipmap资源
 */
var ImageView.imageDrawable: Drawable
    get() = this.drawable
    set(value) {
        this.setImageDrawable(value)
    }

var ImageView.imageResource: Int
    get() = 0
    set(value) {
        this.setImageResource(value)
    }
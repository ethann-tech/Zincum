package com.ethan.view.kit.verifcode

import android.text.Editable
import android.text.TextWatcher
import android.view.animation.Animation.AnimationListener
import android.view.animation.Animation
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.SeekBar

/**
 * 简化回调写法
 * Created by zxj on 2015/10/13.
 */
class ListenerUtils private constructor() {
    abstract class SimpleTextWatcher : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {}
    }

    abstract class SimpleAnimListener : AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationEnd(animation: Animation) {}
        override fun onAnimationRepeat(animation: Animation) {}
    }

    abstract class SimpleSeekBarListener : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }

    interface SimpleCallback<T> {
        fun complete(o: T)
    }

    interface ImageLoadListener<T> {
        fun complete(o: T)
        fun onFail()
    }
}
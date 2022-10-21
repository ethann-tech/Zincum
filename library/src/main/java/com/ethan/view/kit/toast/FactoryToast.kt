package com.ethan.view.kit.toast

import android.content.Context
import android.os.Build
import android.view.Gravity

/**
 * Toast工程类
 *
 * 备注：为了在安卓版本R(11)能正常的弹出
 *
 * @author sollyu
 * @date   2020-04-10
 */
internal object FactoryToast {

    fun makeText(context: Context, text: CharSequence, @Toast.Duration duration: Int, gravity: Int = Gravity.CENTER): android.widget.Toast {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) Toast.makeText(context, text, duration, gravity = gravity)
        else return android.widget.Toast.makeText(context, "", duration).apply {
            setText(text)
        }
    }

    fun makeText(context: Context, resId: Int): android.widget.Toast {
        return makeText(context = context, text = context.getString(resId), duration = Toast.LENGTH_SHORT)
    }

}
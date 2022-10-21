package com.ethan.view.kit.verifcode

import android.widget.TextView
import androidx.annotation.DrawableRes

/**
 * 重新获取验证码，相关状态封装
 * Created by zxj on 2018/11/29.
 */
class ResendHelper(private val textView: TextView) {
    fun setText(text: String?) {
        textView.text = text
    }

    /**
     * 倒计时完成，重新获取验证码（验证码倒计时）
     *
     * @param
     */
    fun resend() {
        textView.isClickable = true
    }

    fun resend(textColor: Int) {
        textView.isClickable = true
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    fun resend(textColor: Int, @DrawableRes textRes: Int) {
        textView.isClickable = true
        if (textRes != 0) {
            textView.setBackgroundResource(textRes)
        }
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    /**
     * 倒计时过程更新状态
     *
     * @param
     */
    fun resendUpdate() {
        textView.isClickable = false
    }

    fun resendUpdate(textColor: Int) {
        textView.isClickable = false
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    fun resendUpdate(textColor: Int, @DrawableRes textRes: Int) {
        textView.isClickable = false
        if (textRes != 0) {
            textView.setBackgroundResource(textRes)
        }
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    /**
     * 不可点击状态
     *
     * @param
     */
    fun enable() {
        textView.isClickable = false
    }

    fun enable(textColor: Int) {
        textView.isClickable = false
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    fun enable(textColor: Int, @DrawableRes textRes: Int) {
        textView.isClickable = false
        if (textRes != 0) {
            textView.setBackgroundResource(textRes)
        }
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    /**
     * 可点击（获取验证码）
     *
     * @param
     */
    fun getCode(){
        textView.isClickable =true
    }


    fun getCode(textColor: Int) {
        textView.isClickable = true
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }

    fun getCode(textColor: Int, @DrawableRes textRes: Int) {
        textView.isClickable = true
        if (textRes != 0) {
            textView.setBackgroundResource(textRes)
        }
        if (textColor != 0) {
            textView.setTextColor(textColor)
        }
    }
}
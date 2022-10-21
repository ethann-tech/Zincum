package com.ethan.view.kit.verifcode

import android.os.Handler
import android.widget.TextView
import android.widget.EditText
import androidx.annotation.DrawableRes
import android.text.TextUtils
import android.os.Looper
import com.ethan.view.kit.R

/**
 * @Description: 核心的控制层
 * @Auther: ethan
 * @Date: 2019-04-26 17:40
 */
class ResendControl(textView: TextView, editText: EditText) {
    private val resendHelper: ResendHelper
    private var counter: ResendCounter? = null

    /**
     * 默认字体颜色
     */
    var textColor = 0

    /**
     * 可点击 状态背景色
     */
    @DrawableRes
    var selectBackground = R.drawable.bg_btn_orange_full_14_shape

    /**
     * 不可点击状态颜色
     */
    @DrawableRes
    var enableBackground = R.drawable.bg_btn_gray_full_14_shape
    var editText: EditText
    private val tvSend: TextView

    /**
     * 记录上次号码
     */
    private var tmpNum: String = ""

    /**
     * 倒计时清除手机号码标识
     */
    var isCountDown = false
        private set

    init {
        resendHelper = ResendHelper(textView)
        this.editText = editText
        tvSend = textView
    }

    fun injectStyle(textColor: Int, light: Int, dark: Int) {
        this.textColor = textColor
        selectBackground = light
        enableBackground = dark
    }

    fun startCountDown() {

        // 倒计时过程中删除号码也不打断倒计时
        counter = ResendCounter.create(handler, 60, 0, -1, 1000, object : ResendCounter.Listener {
            override fun update(count: Int) {
                isCountDown = true
                resendHelper.setText(editText.context.getString(R.string.reacquire_count_down,count.toString()))
                resendHelper.resendUpdate(
                    textColor,
                    if (enableBackground == 0) R.drawable.bg_btn_gray_full_14_shape else enableBackground
                )
            }

            override fun complete() {
                isCountDown = false
                // 倒计时完成删除号码更改显示
                if (TextUtils.isEmpty(editText.text)) {
                    tvSend.text = editText.context.getString(R.string.get_verification_code)
                    //edtTextView文本为空不能点击
                    resendHelper.enable(
                        textColor,
                        if (enableBackground == 0) R.drawable.bg_btn_gray_full_14_shape else enableBackground
                    )
                } else {
                    if (editText.text.toString() == tmpNum) {
                        //对比上次获取验证码的号码，如果一样则显示重新获取，否则显示获取验证码
                        tvSend.text = editText.context.getString(R.string.reacquire)
                    } else {
                        tvSend.text = editText.context.getString(R.string.get_verification_code)
                    }
                    //都是可点击状态
                    resendHelper.getCode(
                        textColor,
                        if (selectBackground == 0) R.drawable.bg_btn_orange_full_14_shape else selectBackground
                    )
                }
            }
        })

        //记录获取验证码的号码
        tmpNum = editText.text.toString().trim { it <= ' ' }
        counter?.start()
    }

    //检查倒计时
    fun checkStyle() {
        val phone = editText.text.toString()
        if (TextUtils.isDigitsOnly(phone) && phone.isNotEmpty()) {
            if (tvSend.text.toString() == "获取验证码") {
                resendHelper.getCode()
            } else if (tvSend.text.toString() == "重新获取") {
                resendHelper.resend()
            } else {
                // 倒计时中
                resendHelper.enable()
            }
        } else {
            if (!isCountDown) {
                if (phone.isNotEmpty()) {
                    resendHelper.getCode()
                } else {
                    resendHelper.enable()
                }
            }
        }
    }

    fun clear() {
        if (counter != null) {
            counter!!.stop()
        }
    }

    companion object {
        private val handler = Handler(Looper.getMainLooper())
    }
}
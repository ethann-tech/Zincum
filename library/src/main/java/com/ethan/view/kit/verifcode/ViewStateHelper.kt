package com.ethan.view.kit.verifcode

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.ethan.view.kit.R
import java.lang.StringBuilder

/**
 * 控件状态切换
 *
 * @author zxj
 * @date 17/6/12
 */
object ViewStateHelper {
    /**
     * 输入密码禁止空格
     *
     * @param editTexts
     * @param editTexts
     */
    fun addTrimController(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.addTextChangedListener(object : ListenerUtils.SimpleTextWatcher() {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (s.toString().contains(" ")) {
                        val str = s.toString().split(" ").toTypedArray()
                        val str1 = StringBuilder()
                        for (value in str) {
                            str1.append(value)
                        }
                        editText.setText(str1.toString())
                        editText.setSelection(start)
                    }
                }
            })
        }
    }

    /**
     * 切换按钮状态
     *
     * @param view
     * @param controller
     * @param editTexts
     */
    fun addStateController(view: View, controller: ICondition, vararg editTexts: EditText) {
        view.isClickable = false
        if (view.background != null) {
            view.isEnabled = false
        }
        for (editText in editTexts) {
            editText.addTextChangedListener(object : ListenerUtils.SimpleTextWatcher() {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (controller.checkState()) {
                        view.isEnabled = true
                        if (view.background != null) {
                            view.background.level = view.resources.getInteger(R.integer.enable_level)
                        }
                        view.isClickable = true
                    } else {
                        view.isEnabled = false
                        view.isClickable = false
                        if (view.background != null) {
                            view.background.level = view.resources.getInteger(R.integer.disable_level)
                        }
                    }
                }
            })
        }
    }

    /**
     * 切换按钮状态
     *
     * @param view
     * @param controller
     * @param editTexts
     */
    fun addStateControllerBt(context: Context, view: TextView, select: Int, unSelect: Int, controller: ICondition, vararg editTexts: EditText) {
        view.isClickable = false
        if (view.background != null) view.isEnabled = false
        for (editText in editTexts) {
            editText.addTextChangedListener(object : ListenerUtils.SimpleTextWatcher() {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (controller.checkState()) {
                        view.isEnabled = true
                        if (view.background != null) {
                            if (select == 0) {
                                view.setBackgroundResource(R.drawable.bg_btn_orange_full_14_shape)
                            } else {
                                view.setBackgroundResource(select)
                            }
                        }
                        view.setTextColor(ResourcesCompat.getColor(context.resources,android.R.color.white,null))
                        view.isClickable = true
                    } else {
                        view.isEnabled = false
                        view.isClickable = false
                        view.setTextColor(ResourcesCompat.getColor(context.resources,android.R.color.white,null))
                        if (view.background != null) {
                            if (unSelect == 0) {
                                view.setBackgroundResource(R.drawable.bg_btn_gray_full_14_shape)
                            } else {
                                view.setBackgroundResource(unSelect)
                            }
                        }
                    }
                }
            })
        }
    }
}
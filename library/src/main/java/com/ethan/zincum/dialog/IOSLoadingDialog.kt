package com.ethan.zincum.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.annotation.Keep
import androidx.fragment.app.DialogFragment
import com.ethan.zincum.R
@Keep
class IOSLoadingDialog : DialogFragment(), DialogInterface.OnKeyListener {
    /**
     * 默认点击外面无效
     */
    private var onTouchOutside = false

    /**
     * 加载框提示信息 设置默认
     */
    private var hintMsg = "加载中"

    /**
     * 设置是否允许点击外面取消
     *
     * @param onTouchOutside x
     * @return
     */
    fun setOnTouchOutside(onTouchOutside: Boolean): IOSLoadingDialog {
        this.onTouchOutside = onTouchOutside
        return this
    }

    /**
     * 设置加载框提示信息
     *
     * @param hintMsg
     */
    fun setHintMsg(hintMsg: String): IOSLoadingDialog {
        if (!hintMsg.isEmpty()) {
            this.hintMsg = hintMsg
        }
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val dialog = dialog


        dialog.let {
            it?.window?.let { window ->
                window.setBackgroundDrawableResource(android.R.color.transparent)
                it.requestWindowFeature(Window.FEATURE_NO_TITLE)
                it.setCanceledOnTouchOutside(onTouchOutside) //不响应返回键
                it.setOnKeyListener(this)
            }
        }


        // 设置背景透明
        // 去掉标题
        val loadingView = inflater.inflate(R.layout.dialog_ios_loading, container)
        val hintTextView = loadingView.findViewById<TextView>(R.id.tv_ios_loading_dialog_hint)
        hintTextView.text = hintMsg


        return loadingView
    }

    override fun onKey(dialog: DialogInterface, keyCode: Int, event: KeyEvent): Boolean {
        return keyCode == KeyEvent.KEYCODE_BACK
    }
}
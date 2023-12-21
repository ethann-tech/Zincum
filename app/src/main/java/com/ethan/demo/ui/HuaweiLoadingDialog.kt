package com.ethan.demo.ui

import android.content.Context
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.ethan.demo.R
import com.ethan.demo.databinding.DialogHuaweiLoadingViewBinding

class HuaweiLoadingDialog(context: Context) : AppCompatDialog(context, R.style.loading_dialog) {
    private lateinit var mBinding: DialogHuaweiLoadingViewBinding
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        mBinding = DialogHuaweiLoadingViewBinding.inflate(layoutInflater,null,false)
        setContentView(mBinding.root)
    }

    fun setLoadingMessage(message: String) {
        if (message.isEmpty()) {
            mBinding.message.visibility = View.GONE
        } else {
            mBinding.message.text = message
            mBinding.message.visibility = View.VISIBLE
        }
    }

}
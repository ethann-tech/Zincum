package com.ethan.demo.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityResendMsgBinding
import com.ethan.zincum.R
import com.ethan.zincum.verifcode.ICondition
import com.ethan.zincum.verifcode.ResendControl
import com.ethan.zincum.verifcode.ViewStateHelper
import io.github.uhsk.kit.android.view.setOnNoDoubleClickListener

class ActivityResendMsg : ActivityBusinessBase<ActivityResendMsgBinding>(), ICondition {
    private val resendControl by lazy { ResendControl(mBinding.tvResend, mBinding.edtPhone) }

    override fun layoutResId(): Int = com.ethan.demo.R.layout.activity_resend_msg
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResendMsgBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ViewStateHelper.addTrimController(mBinding.edtPhone, mBinding.edtCode)
        ViewStateHelper.addStateControllerBt(mBinding.root.context, mBinding.tvResend, R.drawable.bg_btn_orange_full_14_shape, R.drawable.bg_btn_gray_full_14_shape, this, mBinding.edtPhone)
        ViewStateHelper.addStateControllerBt(mBinding.root.context, mBinding.tvNext, R.drawable.bg_btn_orange_full_14_shape, R.drawable.bg_btn_gray_full_14_shape, this, mBinding.edtPhone)
        initEvent()
    }

    private fun initEvent() {

        mBinding.tvResend.setOnNoDoubleClickListener {
            if (mBinding.edtPhone.toString().isEmpty()) {
                Toast.makeText(mBinding.edtPhone.context, "验证码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnNoDoubleClickListener
            }
            resendControl.startCountDown()
        }

    }

    override fun checkState(): Boolean {
        val smsCode = mBinding.edtPhone.text.toString()
        resendControl.checkStyle()
        if (resendControl.isCountDown) {
            return false
        }
        return smsCode.isNotEmpty()
    }

    override fun onDestroy() {
        super.onDestroy()
        resendControl.clear()
    }


}
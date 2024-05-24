package com.ethan.demo.ui.activity

import androidx.core.content.res.ResourcesCompat
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityVerificationCodeBinding
import com.ethan.zincum.widget.VerificationCodeEditText

class ActivityVerificationCode : ActivityBusinessBase<ActivityVerificationCodeBinding>() {

    override fun initView() {
        super.initView()
        mBinding.includeLayoutToolbar.mToolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.includeLayoutToolbar.mToolbar.title = "验证码输入框"
        mBinding.includeLayoutToolbar.mToolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        mBinding.includeLayoutToolbar.mToolbar.setNavigationOnClickListener {
            finish()
        }
        //输入完成监听
        mBinding.verificationEdit.inputCount = 6
        mBinding.verificationEdit.setOnEditCompleteListener(object : VerificationCodeEditText.OnEditCompleteListener {
            override fun onEditComplete(text: String) {
                mLogger.debug("LOG:ActivityVerificationCode:onEditComplete: 输入完成text={}", text)
            }
        })
    }

    override fun layoutResId(): Int = R.layout.activity_verification_code
}
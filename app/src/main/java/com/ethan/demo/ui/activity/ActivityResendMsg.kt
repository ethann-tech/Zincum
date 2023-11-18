package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ethan.zincum.listener.setNoDoubleClickListener
import com.ethan.zincum.verifcode.ICondition
import com.ethan.zincum.verifcode.ResendControl
import com.ethan.zincum.verifcode.ViewStateHelper
import com.ethan.demo.databinding.ActivityResendMsgBinding
import com.ethan.zincum.R

class ActivityResendMsg:AppCompatActivity(), ICondition {
    private lateinit var mBinding:ActivityResendMsgBinding
    private val resendControl by lazy { ResendControl(mBinding.tvResend,mBinding.edtPhone) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityResendMsgBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ViewStateHelper.addTrimController(mBinding.edtPhone,mBinding.edtCode)
        ViewStateHelper.addStateControllerBt(mBinding.root.context,mBinding.tvResend, R.drawable.bg_btn_orange_full_14_shape, R.drawable.bg_btn_gray_full_14_shape,this,mBinding.edtPhone)
        ViewStateHelper.addStateControllerBt(mBinding.root.context,mBinding.tvNext, R.drawable.bg_btn_orange_full_14_shape, R.drawable.bg_btn_gray_full_14_shape,this,mBinding.edtPhone)
        initEvent()
    }
   private fun initEvent(){
        mBinding.tvResend.setNoDoubleClickListener {
            if (mBinding.edtPhone.toString().isEmpty()){
                Toast.makeText(mBinding.edtPhone.context,"验证码不能为空",Toast.LENGTH_SHORT).show()
                return@setNoDoubleClickListener
            }
            resendControl.startCountDown()
        }

   }

    override fun checkState(): Boolean {
        val smsCode =mBinding.edtPhone.text.toString()
        resendControl.checkStyle()
        if (resendControl.isCountDown){
            return false
        }
        return smsCode.isNotEmpty()
    }
    override fun onDestroy() {
        super.onDestroy()
        resendControl.clear()
    }

    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityResendMsg::class.java))
        }
    }

}
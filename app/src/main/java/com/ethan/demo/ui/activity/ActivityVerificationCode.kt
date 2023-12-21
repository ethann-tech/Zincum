package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.ethan.demo.R
import com.ethan.demo.databinding.ActivityVerificationCodeBinding
import com.ethan.zincum.widget.VerificationCodeEditText

class ActivityVerificationCode:AppCompatActivity() {
    private val mBinding by lazy {
        ActivityVerificationCodeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( mBinding.root)
        mBinding.includeLayoutToolbar.mToolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.includeLayoutToolbar.mToolbar.title = "验证码输入框"
        mBinding.includeLayoutToolbar.mToolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        mBinding.includeLayoutToolbar.mToolbar.setNavigationOnClickListener {
            finish()
        }
        //输入完成监听
        mBinding.verificationEdit.inputCount =6
        mBinding.verificationEdit.setOnEditCompleteListener(object :
            VerificationCodeEditText.OnEditCompleteListener {
            override fun onEditComplete(text: String) {
                Log.d(TAG, "输入完成 : $text")
            }
        })

    }


    companion object{
        const val TAG = "VerificationEdit"

        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityVerificationCode::class.java))
        }
    }
}
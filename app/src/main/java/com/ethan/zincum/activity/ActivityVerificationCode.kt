package com.ethan.zincum.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.ethan.view.kit.widget.VerificationCodeEditText
import com.ethan.zincum.R
import com.ethan.zincum.databinding.ActivityVerificationCodeBinding

class ActivityVerificationCode:AppCompatActivity() {
    private val mBinding by lazy {
        ActivityVerificationCodeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( mBinding.root)
        mBinding.includeLayoutToolbar.toolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.includeLayoutToolbar.toolbar.title = "验证码输入框"
        mBinding.includeLayoutToolbar.toolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))

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
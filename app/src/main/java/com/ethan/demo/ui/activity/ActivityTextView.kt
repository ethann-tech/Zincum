package com.ethan.demo.ui.activity

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityAlignTextBinding
import com.ethan.zincum.toast.Toast
import io.github.uhsk.kit.android.view.clickText
import io.github.uhsk.kit.asDrawable

class ActivityTextView : ActivityBusinessBase<ActivityAlignTextBinding>() {

    override fun initView() {
        mBinding = ActivityAlignTextBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.includeToolbar.mToolbar.title = "TextView"
        setSupportActionBar(mBinding.includeToolbar.mToolbar)
        mBinding.includeToolbar.mToolbar.navigationIcon = R.drawable.nav_back.asDrawable(mContext)


        mBinding.tvTextClick.text = "已阅读并同意《中国移动认证服务条款》、《用户协议》、《隐私政策》。"

        mBinding.tvTextClick.clickText("《用户协议》", Color.RED) {
            Toast.makeText(mContext, "用户协议", Toast.LENGTH_SHORT).show()
        }
        mBinding.tvTextClick.clickText("《隐私政策》", Color.BLUE) {
            Toast.makeText(mContext, "隐私政策", Toast.LENGTH_SHORT).show()
        }
        mBinding.tvTextClick.clickText("《中国移动认证服务条款》", ContextCompat.getColor(mContext, R.color.colorPrimary)) {
            Toast.makeText(mContext, "中国移动认证服务条款", Toast.LENGTH_SHORT).show()
        }
        mBinding.tvTextClick.clickText("联通", "#F2AF00".toColorInt()) {
            Toast.makeText(mContext, "中国移动认证服务条款", Toast.LENGTH_SHORT).show()
        }
    }


}
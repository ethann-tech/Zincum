package com.ethan.demo.ui.activity

import android.os.Build
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityDeviceInfoBinding
import java.lang.StringBuilder

class ActivityDeviceInfo : ActivityBusinessBase<ActivityDeviceInfoBinding>() {

    override fun layoutResId(): Int {
        return R.layout.activity_device_info
    }
    override fun initWindowAttributes() {

    }

    override fun initView() {
        mBinding.tvDeviceInfo.text =StringBuilder().append("手机厂商：").append(Build.MANUFACTURER).append("\n")
            .append("手机名称：").append(Build.BRAND).append("\n")
            .append("产品名：").append(Build.PRODUCT).append("\n")
            .append("手机型号：").append(Build.MODEL).append("\n")
    }

    override fun initListener() {
    }
}
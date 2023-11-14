package com.ethan.demo.activity

import android.os.Build
import android.os.Bundle
import com.ethan.demo.base.ActivityBase
import com.ethan.demo.databinding.ActivityDeviceInfoBinding
import java.lang.StringBuilder

class ActivityDeviceInfo : ActivityBase() {
    private lateinit var mBinding: ActivityDeviceInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDeviceInfoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.tvDeviceInfo.text =StringBuilder().append("手机厂商：").append(Build.MANUFACTURER).append("\n")
            .append("手机名称：").append(Build.BRAND).append("\n")
            .append("产品名：").append(Build.PRODUCT).append("\n")
            .append("手机型号：").append(Build.MODEL).append("\n")
    }
}
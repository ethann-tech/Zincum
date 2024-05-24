package com.ethan.demo.ui.activity

import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityTimeUtilBinding

class ActivityTimeUtil : ActivityBusinessBase<ActivityTimeUtilBinding>() {
//    private static final String ZONED_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSz";

    private val ZONED_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSz"


    val test = "2022-05-06T16:00:00.000+0000"

    override fun initListener() {}

    override fun layoutResId(): Int = R.layout.activity_time_util


}
package com.ethan.demo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBase

class ActivityLoading : ActivityBase() {
    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityLoading::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_huawei_loading)
    }
}
package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import com.ethan.demo.R
import com.ethan.demo.databinding.ActivityTestBinding
import com.ethan.demo.ui.fragment.FragmentTest
import com.ethan.zincum.base.ActivityDataBindingBase

class ActivityTest : ActivityDataBindingBase<ActivityTestBinding>() {
    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityTest::class.java))
        }
    }

    override fun initWindowAttributes() {

    }

    override fun initView() {
        val fm: FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(mBinding.fragmentContainer.id, FragmentTest.newInstance("测试DataBinding", ""))
        ft.commitNow()
    }

    override fun initListener() {

    }

    override fun layoutResId(): Int =R.layout.activity_test
}
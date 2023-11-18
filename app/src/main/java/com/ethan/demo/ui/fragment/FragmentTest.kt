package com.ethan.demo.ui.fragment

import android.os.Bundle
import android.view.View
import com.ethan.demo.R
import com.ethan.demo.databinding.FragmentTestBinding
import com.ethan.zincum.base.FragmentDataBindingBase

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentTest : FragmentDataBindingBase<FragmentTestBinding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun getLayoutResId(): Int = R.layout.fragment_test

    override fun initView(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        mBinding.tv.text = param1
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentTest().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
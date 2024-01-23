package com.ethan.demo.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.ethan.demo.R
import com.ethan.demo.databinding.FragmentTestBinding
import com.ethan.zincum.base.FragmentDataBindingBase
import com.ethan.zincum.widget.CustomItemView
import io.github.uhsk.kit.android.dp2px
import io.github.uhsk.kit.android.obtainColor
import io.github.uhsk.kit.android.sp2px
import io.github.uhsk.kit.asDrawable

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

        val item2 =CustomItemView(requireContext())
        item2.apply {
            rightText = "20"
            rightTextColor =R.color.white
            rightTextBackground =R.drawable.shape_24_24_red_dot
            rightTextMarginEnd =16.dp2px()
            rightTextHeight =18.dp2px()
            rightTextWidth =18.dp2px()
            rightTextSize =10.sp2px().toFloat()
            mainTextColor =context.obtainColor(R.color.color_D81B60)
            mainText ="动态设置文本"
            mainTextColor =context.obtainColor(R.color.color_D81B60)
            mainTextStart =16.dp2px().toFloat()
            type =CustomItemView.Type.SINGLE_TEXT
            background =R.color.white.asDrawable(context)
//            background =R.color.teal_200.asDrawable(context)

        }
        mBinding.container.addView(item2)
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
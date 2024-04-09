package com.ethan.demo.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.widget.LinearLayoutCompat
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

        mBinding.layoutDynamic.addView(CustomItemView(requireContext()).apply {
            rightText = "20"
            rightTextColor = R.color.white
            rightTextBackground = R.drawable.shape_24_24_red_dot
            rightTextMarginEnd = 16.dp2px()
            rightTextHeight = 18.dp2px()
            rightTextWidth = 18.dp2px()
            rightTextSize = 10.sp2px().toFloat()
            mainTextColor = context.obtainColor(R.color.color_D81B60)
            mainText = "动态设置文本"
            mainTextColor = context.obtainColor(R.color.color_D81B60)
            mainTextStart = 16.dp2px().toFloat()
            background = R.color.white.asDrawable(context) //            background =R.color.teal_200.asDrawable(context)
        })
        mBinding.layoutDynamic.addView(CustomItemView(requireContext()).apply {
            background = R.color.color_b2d0e9.asDrawable(context)

            type = CustomItemView.Type.MULTI_TEXT
            rightText = "20"
            rightTextColor = R.color.white
            rightTextBackground = R.drawable.shape_24_24_red_dot
            rightTextMarginEnd = 16.dp2px()
            rightTextHeight = 18.dp2px()
            rightTextWidth = 18.dp2px()
            rightTextSize = 10.sp2px().toFloat()

            mainText = "动态设置文本2"
            mainTextColor = context.obtainColor(R.color.color_D81B60)
            mainTextStart = 16.dp2px().toFloat()
            mainTextSize =16F.sp2px().toFloat()

            secondText = "这是动态设置的子标题"
            secondTextSize = 12.sp2px().toFloat()
            secondTextColor = R.color.color_550165b8
        }, LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, 72.dp2px()))

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
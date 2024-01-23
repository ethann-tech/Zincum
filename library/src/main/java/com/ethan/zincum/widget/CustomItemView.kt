package com.ethan.zincum.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ethan.zincum.R
import com.google.android.material.internal.BaselineLayout
import io.github.uhsk.kit.android.sp2px
import io.github.uhsk.kit.android.view.backgroundColor
import io.github.uhsk.kit.android.view.backgroundResource
import io.github.uhsk.kit.android.view.textColor

/**
 * 自定义ItemView
 * @Created by ethan on 2024/1/17
 */
class CustomItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    enum class Type(val value: Int) {
        SINGLE_TEXT(0),
        MULTI_TEXT(1);

        companion object {
            fun getType(value: Int): Type {
                return Type.values()[value]
            }
        }
    }

    var type: Type = Type.SINGLE_TEXT


    var mainText: String = ""
        set(value) {
            field = value
            tvMain.text = mainText
        }
    var secondText: String = ""
        set(value) {
            field = value
            tvSecond.text = value
        }

    var leftIcon: Int = 0
        set(value) {
            field = value
            imgIntoIcon.setImageResource(value)
        }
    var leftIconStart: Float = 0.0F
        set(value) {
            field = value
            (imgIntoIcon.layoutParams as MarginLayoutParams).marginStart = value.toInt()
        }

    /**
     * mainTextView marginStart
     */
    var mainTextStart: Float = 0.0F
        set(value) {
            field = value
            (tvMain.layoutParams as MarginLayoutParams).marginStart = value.toInt()
        }

    /**
     * mainTextView marginTop
     */
    var mainTextTop: Float = 0F
        set(value) {
            field = value
            (tvMain.layoutParams as MarginLayoutParams).topMargin = value.toInt()
        }
    var mainTextColor: Int = 0
        set(value) {
            field = value
            tvMain.setTextColor(mainTextColor)
        }

    var mainTextSize: Float = 0F
        set(value) {
            field = value
            tvMain.textSize = mainTextSize
        }

    /**
     * 二级标题marginStart
     */
    var secondTextStart: Float = 0.0F
        set(value) {
            field = value
            (tvSecond.layoutParams as MarginLayoutParams).marginStart = value.toInt()
        }

    var secondTextTop: Float = 0F
        set(value) {
            field = value
            (tvSecond.layoutParams as MarginLayoutParams).topMargin = value.toInt()
        }

    var secondTextColor: Int = 0
        set(value) {
            field = value
            tvSecond.setTextColor(value)
        }

    var secondTextSize: Float = 13F
        set(value) {
            field = value
            tvSecond.textSize = value
        }

    var bottomLineHeight: Float = 0F
        set(value) {
            field = value
            bottomLine.layoutParams.height = value.toInt()
        }
    var bottomLineColor: Int = 0
        set(value) {
            field = value
            bottomLine.setBackgroundColor(bottomLineColor)
        }

    var bottomLineMarginStart: Float = 0F
        set(value) {
            field = value
            (bottomLine.layoutParams as MarginLayoutParams).marginStart = value.toInt()
        }
    var bottomLineMarginEnd: Float = 0F
        set(value) {
            field = value
            (bottomLine.layoutParams as MarginLayoutParams).marginEnd = value.toInt()
        }

    var imgInto: Int = 0
        set(value) {
            field = value
            imgIntoIcon.setImageResource(value)
        }

    var rightTextColor: Int = 0
        set(value) {
            field = value
            when {
                value != 0 -> {
                    tvRightText.textColor = value
                }
            }

        }
    var rightTextSize: Float = 0F
        set(value) {
            field = value
            tvRightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
        }
    var rightText: String = ""
        set(value) {
            field = value
            tvRightText.text = value
        }
    var rightTextMarginEnd: Int = 0
        set(value) {
            field = value
            (tvRightText.layoutParams as MarginLayoutParams).marginEnd = value
        }
    var rightTextBackgroundColor: Int = 0
        set(value) {
            field = value
            when {
                value != 0 -> {
                    tvRightText.backgroundColor = value
                }
            }

        }
    var rightTextBackground: Int = 0
        set(value) {
            field = value
            when {
                value != 0 -> {
                    tvRightText.backgroundResource = value
                }
            }
        }

    var rightTextWidth: Int = 0
        set(value) {
            field = value
            tvRightText.layoutParams.width = rightTextWidth
        }
    var rightTextHeight: Int = 0
        set(value) {
            field = value
            tvRightText.layoutParams.height = rightTextHeight
        }

    private var tvMain: AppCompatTextView
    private var tvSecond: AppCompatTextView
    private var imgLeftIcon: AppCompatImageView
    private var imgIntoIcon: AppCompatImageView
    private var tvRightText: AppCompatTextView

    @SuppressLint("RestrictedApi")
    private var bottomLine: BaselineLayout


    init {
        println("init->")
        val rootView = inflate(context, R.layout.layout_item_view, this)
        tvMain = rootView.findViewById(R.id.tv_main_title)
        tvSecond = rootView.findViewById(R.id.tv_second_title)
        imgLeftIcon = rootView.findViewById(R.id.img_icon)
        bottomLine = rootView.findViewById(R.id.bottom_line)
        imgIntoIcon = rootView.findViewById(R.id.img_into)
        tvRightText = rootView.findViewById(R.id.tv_right_text)

        context.obtainStyledAttributes(attrs, R.styleable.CustomItemView).apply {
            type = Type.getType(getInt(R.styleable.CustomItemView_type, 0))

            leftIcon = getResourceId(R.styleable.CustomItemView_iv_icon, 0)
            leftIconStart = getDimension(R.styleable.CustomItemView_iv_icon_start, 0F)
            mainText = getString(R.styleable.CustomItemView_iv_main_text) ?: ""
            mainTextStart = getDimension(R.styleable.CustomItemView_iv_main_text_start, 0F)
            mainTextTop = getDimension(R.styleable.CustomItemView_iv_main_text_top, 0F)
            mainTextColor = getColor(R.styleable.CustomItemView_iv_main_text_color, Color.parseColor("#000000"))
            mainTextSize = getDimension(R.styleable.CustomItemView_iv_main_text_size, 16.sp2px().toFloat())

            secondText = getString(R.styleable.CustomItemView_iv_second_text) ?: ""
            secondTextStart = getDimension(R.styleable.CustomItemView_iv_second_text_start, 0F)
            secondTextTop = getDimension(R.styleable.CustomItemView_iv_second_text_top, 0F)
            secondTextColor = getColor(R.styleable.CustomItemView_iv_second_text_color, Color.parseColor("#ADADB0"))
            secondTextSize = getDimension(R.styleable.CustomItemView_iv_second_text_size, 13.sp2px().toFloat())

            bottomLineHeight = getDimension(R.styleable.CustomItemView_iv_bottom_line_height, 0F)
            bottomLineColor = getColor(R.styleable.CustomItemView_iv_bottom_line_color, Color.parseColor("#000000"))
            bottomLineMarginStart = getDimension(R.styleable.CustomItemView_iv_bottom_line_margin_start, 0F)
            bottomLineMarginEnd = getDimension(R.styleable.CustomItemView_iv_bottom_line_margin_end, 0F)

            imgInto = getResourceId(R.styleable.CustomItemView_iv_into_img, 0)

            rightTextBackground = getResourceId(R.styleable.CustomItemView_iv_right_text_background, 0)
            rightTextColor = getResourceId(R.styleable.CustomItemView_iv_right_text_color, R.color.black)
            rightTextSize = getDimension(R.styleable.CustomItemView_iv_right_text_size, 12.sp2px().toFloat())
            rightText = getString(R.styleable.CustomItemView_iv_right_text) ?: ""
            rightTextMarginEnd = getDimension(R.styleable.CustomItemView_iv_right_text_margin_end, 0F).toInt()
            rightTextWidth = getDimension(R.styleable.CustomItemView_iv_right_text_width, 0F).toInt()
            rightTextHeight = getDimension(R.styleable.CustomItemView_iv_right_text_height, 0F).toInt()
            recycle()
        }
        buildViewByType()
    }


    private fun buildViewByType() {

        if (mainText.isNotBlank()) {
            tvMain.text = mainText
        }
        if (secondText.isNotBlank() && type == Type.MULTI_TEXT) {
            tvSecond.text = secondText
        }
        if (leftIcon != 0) {
            imgLeftIcon.setImageResource(leftIcon)
        }
        if (leftIconStart != 0F) {
            (imgLeftIcon.layoutParams as MarginLayoutParams).marginStart = leftIconStart.toInt()
        }

        if (mainTextStart != 0F) {
            (tvMain.layoutParams as MarginLayoutParams).marginStart = mainTextStart.toInt()
        }

        if (mainTextTop != 0F && type == Type.MULTI_TEXT) {
            (tvMain.layoutParams as MarginLayoutParams).topMargin = mainTextTop.toInt()
        }
        tvMain.apply {
            setTextColor(mainTextColor)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, mainTextSize)
        }

        if (secondTextStart != 0F) {
            (tvSecond.layoutParams as MarginLayoutParams).marginStart = secondTextStart.toInt()
        }
        if (secondTextTop != 0F && type == Type.MULTI_TEXT) {
            (tvSecond.layoutParams as MarginLayoutParams).topMargin = secondTextTop.toInt()
        }
        tvSecond.setTextColor(secondTextColor)
        tvSecond.setTextSize(TypedValue.COMPLEX_UNIT_PX, secondTextSize)

        if (bottomLineHeight != 0F) {
            bottomLine.layoutParams.height = bottomLineHeight.toInt()
        }

        bottomLine.setBackgroundColor(bottomLineColor)
        (bottomLine.layoutParams as MarginLayoutParams).apply {
            marginStart = bottomLineMarginStart.toInt()
            marginEnd = bottomLineMarginEnd.toInt()
        }


        if (imgInto != 0) {
            imgIntoIcon.setImageResource(imgInto)
        }

        if (rightTextBackground != 0) {
            tvRightText.setBackgroundResource(rightTextBackground)
        }
        if (rightTextMarginEnd != 0) {
            (tvRightText.layoutParams as MarginLayoutParams).marginEnd = rightTextMarginEnd
        }
        tvRightText.layoutParams.apply {
            width =if(rightTextWidth ==0) ViewGroup.LayoutParams.WRAP_CONTENT else rightTextWidth
            height =if (rightTextHeight==0) ViewGroup.LayoutParams.WRAP_CONTENT else rightTextHeight
        }
        tvRightText.textColor = rightTextColor
        tvRightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize)
        tvRightText.text = rightText


        when (type) {
            Type.SINGLE_TEXT -> {
                tvSecond.visibility = View.GONE
            }

            Type.MULTI_TEXT  -> {
                tvSecond.visibility = View.VISIBLE
            }
        }

    }
}
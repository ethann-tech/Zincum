package com.ethan.zincum.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.ethan.zincum.R

/**
 * 自定义ItemView
 * @Created by ethan on 2024/1/17
 */
class CustomItemView : ConstraintLayout {

    private var type:Type =Type.SINGLE_TEXT
    constructor(context: Context) : super(context)
    constructor(context: Context,  attrs: AttributeSet) : super(context, attrs){
        initAttrs(attrs =attrs)
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs)


    init {

        buildView()
    }
    private fun initAttrs( attrs: AttributeSet){
        val attrs = context.obtainStyledAttributes(attrs, R.styleable.CustomItemView)

        type =Type.getType(attrs.getInt(R.styleable.CustomItemView_type, 0))

        attrs.recycle()
    }
    private enum class Type(val value: Int) {
        SINGLE_TEXT(0),
        MULTI_TEXT(1);

        companion object{
            fun getType(value: Int): Type {
                return Type.values()[value]
            }
        }

    }


    private fun buildView() {
       val rootView = inflate(context, R.layout.layout_item_view, this)
    }
}
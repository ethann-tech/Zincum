package com.ethan.zincum.helper

import com.ethan.zincum.widget.SideslipLayout

class SlideHelper {
    private val mSlides: MutableList<SideslipLayout> = ArrayList()
    fun onStateChanged(layout: SideslipLayout, open: Boolean) {
        if (open) {
            mSlides.add(layout)
        } else {
            mSlides.remove(layout)
        }
    }

    fun closeAll(layout: SideslipLayout): Boolean {
        if (mSlides.size <= 0) {
            return false
        }
        var result = false
        var i = 0
        while (i < mSlides.size) {
            val slide = mSlides[i]
            if (slide !== layout) {
                slide.close()
                mSlides.remove(slide) // Unnecessary
                result = true
                i--
            }
            i++
        }
        return result
    }
}

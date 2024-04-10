package io.github.uhsk.kit.android

import androidx.recyclerview.widget.GridLayoutManager

/**
 * 配置GridLayoutManager的spanCount 适用于ConcatAdapter
 * @param newSpanCount 新的spanCount
 * @param range 条件
 * @author ethan
 * @version 0.1.3
 */
fun GridLayoutManager.configGridSpanCount(newSpanCount: Int, range: (position: Int) -> Boolean) {
    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return if (range(position)) spanCount else newSpanCount
        }
    }
}
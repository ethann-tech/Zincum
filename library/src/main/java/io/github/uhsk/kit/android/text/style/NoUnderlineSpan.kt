package io.github.uhsk.kit.android.text.style

import android.text.TextPaint
import android.text.style.UnderlineSpan

class NoUnderlineSpan : UnderlineSpan() {
    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = ds.linkColor
        ds.isUnderlineText = false
    }
}
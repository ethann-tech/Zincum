package com.ethan.zincum.widget

import android.content.Context
import android.graphics.Canvas
import android.text.StaticLayout
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ethan.zincum.R

class AlignTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : AppCompatTextView(context, attrs, defStyleAttr) {
    private var alignOnlyOneLine = false

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)


    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlignTextView)
        alignOnlyOneLine = typedArray.getBoolean(R.styleable.AlignTextView_alignOnlyOneLine, false)
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        val content = text
        if (content !is String) {
            super.onDraw(canvas)
            return
        }
        val layout = layout

        for (i in 0 until layout.lineCount) {
            val lineBaseline = layout.getLineBaseline(i) + paddingTop
            val lineStart = layout.getLineStart(i)
            val lineEnd = layout.getLineEnd(i)
            if (alignOnlyOneLine && layout.lineCount == 1) { //只有一行
                val line = content.substring(lineStart, lineEnd)
                val width = StaticLayout.getDesiredWidth(content, lineStart, lineEnd, paint)
                this.drawScaledText(canvas, line, lineBaseline.toFloat(), width)
            } else if (i == layout.lineCount - 1) { //最后一行
                canvas.drawText(
                    content.substring(lineStart),
                    paddingLeft.toFloat(),
                    lineBaseline.toFloat(),
                    paint
                )
                break
            } else { //中间行
                val line = content.substring(lineStart, lineEnd)
                val width = StaticLayout.getDesiredWidth(content, lineStart, lineEnd, paint)
                this.drawScaledText(canvas, line, lineBaseline.toFloat(), width)
            }
        }
    }

    private fun drawScaledText(canvas: Canvas, line: String, baseLineY: Float, lineWidth: Float) {
        if (line.isEmpty()) {
            return
        }
        var x = paddingLeft.toFloat()
        val forceNextLine = line[line.length - 1].code == 10
        val length = line.length - 1
        if (forceNextLine || length == 0) {
            canvas.drawText(line, x, baseLineY, paint)
            return
        }

        val d = (measuredWidth - lineWidth - paddingLeft - paddingRight) / length

        for (element in line) {
            val c = element.toString()
            val cw = StaticLayout.getDesiredWidth(c, this.paint)
            canvas.drawText(c, x, baseLineY, this.paint)
            x += cw + d
        }
    }
}
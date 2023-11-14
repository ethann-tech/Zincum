package com.ethan.zincum

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by ethan on 2022/10/17.
 * @author ethan
 * 自定义的步骤导航控件
 */
open class StepNavigateBar : View {
    private var totalStep = 2
    private var curStep = 1
    private var borderPainter: Paint? = null
    private var fillPainter: Paint? = null
    private var completeTextPainter: Paint? = null
    private var noCompleteTextPainter: Paint? = null
    private var frontPath: Path? = null
    private var behindPath: Path? = null
    private var stepNames = arrayOf("default1", "default2", "default3")
    private var textPadding = 0
    private var stepPadding = 0
    private val borderPadding = 2
    private var radius = 0
    private var fillColor = 0
    private var noFillColor = 0
    private var arcRect: RectF? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StepNavigateBar)
        borderPainter = Paint()
        fillPainter = Paint()
        completeTextPainter = Paint()
        noCompleteTextPainter = Paint()
        frontPath = Path()
        behindPath = Path()
        arcRect = RectF()
        val labelSize = typedArray.getDimensionPixelSize(R.styleable.StepNavigateBar_labelSize, 25)
        textPadding = typedArray.getInteger(R.styleable.StepNavigateBar_textMarginStart, 10)
        borderPainter!!.color = typedArray.getColor(R.styleable.StepNavigateBar_borderColor, Color.GRAY)
        fillColor = typedArray.getColor(R.styleable.StepNavigateBar_fillColor, Color.CYAN)
        radius = typedArray.getInteger(R.styleable.StepNavigateBar_radius, 5)
        stepPadding = typedArray.getInteger(R.styleable.StepNavigateBar_stepSpace, 0)
        noFillColor = typedArray.getColor(R.styleable.StepNavigateBar_noFillColor, Color.WHITE)
        borderPainter!!.style = Paint.Style.STROKE
        borderPainter!!.strokeWidth = 2f
        borderPainter!!.isAntiAlias = true
        fillPainter!!.style = Paint.Style.FILL
        fillPainter!!.isAntiAlias = true
        completeTextPainter!!.color = typedArray.getColor(R.styleable.StepNavigateBar_labelColor, Color.LTGRAY)
        completeTextPainter!!.textSize = labelSize.toFloat()
        completeTextPainter!!.isAntiAlias = true
        noCompleteTextPainter!!.isAntiAlias = true
        noCompleteTextPainter!!.color = typedArray.getColor(
            R.styleable.StepNavigateBar_pendingLabelColor, Color.LTGRAY
        )
        noCompleteTextPainter!!.textSize = labelSize.toFloat()
        typedArray.recycle()
    }

    fun setStepNames(vararg names: String) {
        stepNames = names as Array<String>
        totalStep = stepNames.size
    }

    fun setCurrentStep(stepIndex: Int) {
        curStep = stepIndex
        behindPath = Path()
        frontPath = Path()
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec))
    }

    private fun measureWidth(measureSpec: Int): Int {
        var resultWidth = 0
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) { // We were told how big to be
            resultWidth = specSize
        } else { // Measure the text
            for (step in stepNames) {
                resultWidth += (textPadding * 2 + completeTextPainter!!.measureText(step)).toInt()
            }
            resultWidth += (stepNames.size - 1) * stepPadding
            resultWidth += paddingLeft + paddingRight
            if (specMode == MeasureSpec.AT_MOST) { // Respect AT_MOST value if that was what is called for by
                // measureSpec
                // 60,480
                resultWidth = Math.min(resultWidth, specSize)
            }
        }
        return resultWidth
    }

    private fun measureHeight(measureSpec: Int): Int {
        var resultHeight: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) { // We were told how big to be
            resultHeight = specSize
        } else { // Measure the text (beware: ascent is a negative number)
            resultHeight = (-completeTextPainter!!.ascent() + completeTextPainter!!.descent()).toInt() + paddingTop + paddingBottom
            if (specMode == MeasureSpec.AT_MOST) { // Respect AT_MOST value if that was what is called for by
                // measureSpec
                resultHeight = Math.min(resultHeight, specSize)
            }
        }
        return resultHeight
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val itemWidth = measuredWidth / totalStep
        val itemHeight = measuredHeight
        val margin = 15
        for (i in 0 until curStep) {
            calcPath(frontPath, i, itemWidth, itemHeight, margin)
        }
        for (i in curStep until stepNames.size) {
            calcPath(behindPath, i, itemWidth, itemHeight, margin)
        }
        canvas.drawPath(frontPath!!, borderPainter!!)
        canvas.drawPath(behindPath!!, borderPainter!!)
        fillPainter!!.color = fillColor
        canvas.drawPath(frontPath!!, fillPainter!!)
        fillPainter!!.color = noFillColor
        canvas.drawPath(behindPath!!, fillPainter!!)
        for (i in 0 until curStep) {
            drawText(canvas, completeTextPainter, i, itemWidth, margin)
        }
        for (i in curStep until stepNames.size) {
            drawText(canvas, noCompleteTextPainter, i, itemWidth, margin)
        }
    }

    private fun calcPath(
        path: Path?, stepIndex: Int, itemWidth: Int, itemHeight: Int, margin: Int
    ) { //画左侧
        //第一个Step矩形左边要画圆角
        if (stepIndex == 0) {
            path!!.moveTo((radius + borderPadding).toFloat(), borderPadding.toFloat())
            arcRect!![borderPadding.toFloat(), borderPadding.toFloat(), (radius * 2 + borderPadding).toFloat()] = (radius * 2 + borderPadding).toFloat()
            path.arcTo(arcRect!!, 270f, -90f)
            path.lineTo(borderPadding.toFloat(), (itemHeight - borderPadding - radius).toFloat())
            arcRect!![borderPadding.toFloat(), (itemHeight - borderPadding - radius * 2).toFloat(), (radius * 2 - borderPadding).toFloat()] = (itemHeight - borderPadding).toFloat()
            path.arcTo(arcRect!!, 180f, -90f)
        } else {
            path!!.moveTo(
                (itemWidth * stepIndex + borderPadding).toFloat(), borderPadding.toFloat()
            )
            path.lineTo((itemWidth * stepIndex + margin + borderPadding).toFloat(), itemHeight / 2f)
            path.lineTo(
                (itemWidth * stepIndex + borderPadding).toFloat(), (itemHeight - borderPadding).toFloat()
            )
        }

        //画右侧
        //最后一个矩形右边也要画圆角
        if (stepIndex == stepNames.size - 1) {
            path.lineTo(
                (itemWidth * (stepIndex + 1) - borderPadding - radius).toFloat(), (itemHeight - borderPadding).toFloat()
            )
            arcRect!![(itemWidth * (stepIndex + 1) - borderPadding - radius * 2).toFloat(), (itemHeight - borderPadding - radius * 2).toFloat(), (itemWidth * (stepIndex + 1) - borderPadding).toFloat()] = (itemHeight - borderPadding).toFloat()
            path.arcTo(arcRect!!, 90f, -90f)
            path.lineTo(
                (itemWidth * (stepIndex + 1) - borderPadding).toFloat(), (borderPadding + radius).toFloat()
            )
            arcRect!![(itemWidth * (stepIndex + 1) - borderPadding - radius * 2).toFloat(), borderPadding.toFloat(), (itemWidth * (stepIndex + 1) - borderPadding).toFloat()] = (radius * 2 + borderPadding).toFloat()
            path.arcTo(arcRect!!, 0f, -90f)
        } else {
            path.lineTo(
                (itemWidth * (stepIndex + 1) - stepPadding).toFloat(), (itemHeight - borderPadding).toFloat()
            )
            path.lineTo(
                (itemWidth * (stepIndex + 1) - stepPadding + margin).toFloat(), itemHeight / 2f
            )
            path.lineTo(
                (itemWidth * (stepIndex + 1) - stepPadding).toFloat(), borderPadding.toFloat()
            )
        }
        path.close()
    }

    private fun drawText(
        canvas: Canvas, paint: Paint?, stepIndex: Int, itemWidth: Int, margin: Int
    ) { //设置字体垂直居中的计算方法
        val fontMetrics = paint!!.fontMetricsInt
        val textY = (measuredHeight - fontMetrics.top - fontMetrics.bottom) / 2f
        if (stepIndex == 0) {
            canvas.drawText(stepNames[stepIndex], textPadding.toFloat(), textY, paint)
        } else {
            canvas.drawText(
                stepNames[stepIndex], (itemWidth * stepIndex).toFloat() + margin + textPadding, textY, paint
            )
        }
    }
}
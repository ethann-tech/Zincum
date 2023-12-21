package io.github.uhsk.kit.android

import android.content.res.Resources
import android.os.Build
import android.util.TypedValue

fun Number.dp2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

fun Number.sp2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

fun Number.px2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

fun Number.pt2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

fun Number.in2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

fun Number.mm2px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, this.toFloat(), Resources.getSystem().displayMetrics).toInt()


fun Number.px2dp(): Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
    TypedValue.convertPixelsToDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
} else {
    val scale = Resources.getSystem().displayMetrics.density
    if (scale==0F){
        0
    }else{
        (this.toInt() / scale + 0.5).toInt()
    }

}

fun Number.px2sp(): Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
    TypedValue.convertPixelsToDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
} else {
    val scale = Resources.getSystem().displayMetrics.scaledDensity
    if (scale == 0F) {
        0
    } else {
        (this.toInt() / scale + 0.5).toInt()
    }

}

package io.github.uhsk.kit

import android.graphics.Bitmap
import java.io.File

/**
 * bitmap 保存到文件
 * @param file 保存的文件对象
 * @param format 保存的格式
 * @param quality 保存的质量
 */
fun Bitmap.saveToFile(file: File, format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG, quality: Int = 80) {
    if (file.exists().not()) {
        file.createNewFile()
    }
    file.outputStream().use {
        this.compress(format, quality, it)
    }
}
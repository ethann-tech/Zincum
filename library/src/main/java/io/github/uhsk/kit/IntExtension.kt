/*
 * Copyright (C) 2022. sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.uhsk.kit

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import java.nio.ByteBuffer

/**
 * 将整数转换成数组
 *
 * 注意：会返回[Int.SIZE_BYTES]大小的数组，如：
 *
 * ```kotlin
 * 0.toByteArray() == byteArrayOf(0x00, 0x00, 0x00, 0x00)
 * ```
 *
 * @since 1.0.9
 * @author sollyu
 *
 */
fun Int.toByteArray(): ByteArray {
    return ByteBuffer.allocate(Int.SIZE_BYTES).putInt(this).array()
}

/**
 * 字体颜色设置
 *
 * @param context 上下文
 */

fun Int.asColor(context: Context): Int = ResourcesCompat.getColor(context.applicationContext.resources, this, null)

fun Int.asDrawable(context: Context):Drawable =ResourcesCompat.getDrawable(context.applicationContext.resources,this,null)?: throw NullPointerException("该资源文件转Drawable为null")


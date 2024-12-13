package io.github.uhsk.kit.android.view

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.color.MaterialColors
import io.github.uhsk.kit.android.text.style.NoUnderlineSpan
import java.util.Locale
import java.util.regex.Pattern

/**
 * 再给定的文字范围内，对指定的关键字进行高亮显示
 * 如果关键字颜和颜色数量对应，则使用对应颜色  即kw1 -> colors[0],kw2 -> colors[1]  如果关键字数量大于颜色数量，则不对应的关键字默认使用color[0]
 * @param contentText 文字内容
 * @param keywords 关键字 实例  arrayOf("keyword1", "keyword2")
 * @param colors 高亮颜色 实例  listOf(ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent)) ，默认主题色
 *
 */
fun TextView.keywordHighlight(contentText: String, vararg keywords: String, colors: List<Int> = listOf(MaterialColors.getColor(this, android.R.attr.colorPrimary))) {
    if (contentText.isEmpty() || keywords.isEmpty()) {
        this.text = ""
        return
    }
    val spannableString = SpannableString(contentText)
    val regex = keywords.joinToString("|") { Pattern.quote(it.lowercase()) }
    val matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(contentText.lowercase(Locale.getDefault()))
    // 查找所有匹配的关键字，并应用高亮颜色
    while (matcher.find()) {
        val start = matcher.start()
        val end = matcher.end()
        val index = keywords.withIndex().firstOrNull { it.value.lowercase() == matcher.group() }?.index ?: 0
        val colorSize = colors.size
        val color: Int = if (index >= 0 && index <= colorSize - 1) colors[index] else colors[0]
        spannableString.setSpan(ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    this.text = spannableString

}

/**
 * 给定文本，添加点击事件，并设置颜色和去掉下划线
 * @param keywordText 关键字
 * @param color 文字颜色  示例 Color.RED, ContextCompat.getColor(mContext, R.color.colorPrimary),  "#F2AF00".toColorInt()
 * @ param onClick 点击事件
 *
 *
 */
fun TextView.clickText(keywordText: String, color: Int, onClick: () -> Unit) {

    val builder = SpannableStringBuilder()
    val index = text.indexOf(keywordText, 0)
    if (index == -1) {
        Log.e("clickText", "keywordText not found in text")
        return
    }
    builder.append(text)

    val clickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            onClick()
        }
    }
    builder.setSpan(clickableSpan, index, index + keywordText.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

    val noUnderlineSpan = NoUnderlineSpan()
    builder.setSpan(noUnderlineSpan, index, index + keywordText.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

    val foregroundColorSpan = ForegroundColorSpan(color)
    builder.setSpan(foregroundColorSpan, index, index + keywordText.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
    movementMethod = LinkMovementMethod.getInstance()
    text = builder

}
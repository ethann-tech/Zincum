package io.github.uhsk.kit.android

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.ethan.zincum.listener.OnNoDoubleClickListener

fun Toolbar.setNavigationNoDoubleClickListener(delayTime: Int=1000, listener: (view: View) -> Unit){
    this.setNavigationOnClickListener(object : OnNoDoubleClickListener(delayTime = delayTime){
        override fun onNoDoubleClick(v: View) {
            listener(v)
        }
    })
}
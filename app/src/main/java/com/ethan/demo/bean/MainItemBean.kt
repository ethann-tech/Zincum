package com.ethan.demo.bean

import java.io.Serializable

data class MainItemBean(
    var text:String ="",
    var open: Boolean=false
):Serializable

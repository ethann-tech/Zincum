package com.ethan.demo.managers

import android.net.Uri
import org.slf4j.ILoggerFactory

internal interface ILoggerManager {

    fun init()

    suspend fun zip(): Uri
}

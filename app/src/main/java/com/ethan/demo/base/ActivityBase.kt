package com.ethan.demo.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

open class ActivityBase : AppCompatActivity() {

    companion object {
        fun jump(context: Context, clazz: Class<*>) {
            context.startActivity(Intent(context, clazz))
        }
    }
}
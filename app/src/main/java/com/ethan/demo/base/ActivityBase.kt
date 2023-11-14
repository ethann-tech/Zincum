package com.ethan.demo.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.ethan.demo.activity.ActivityStepNavBar

open class ActivityBase : AppCompatActivity() {
    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityStepNavBar::class.java))
        }
    }
}
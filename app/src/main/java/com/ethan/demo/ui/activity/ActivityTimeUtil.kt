package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ethan.demo.databinding.ActivityTimeUtilBinding
class ActivityTimeUtil : AppCompatActivity() {
    private lateinit var mBinding: ActivityTimeUtilBinding
//    private static final String ZONED_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSz";

    private val ZONED_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSz"


    val test = "2022-05-06T16:00:00.000+0000"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTimeUtilBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        
    }


    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityTimeUtil::class.java))
        }
    }
}
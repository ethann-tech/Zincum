package com.ethan.demo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ethan.demo.databinding.ActivityStickyBinding

class ActivitySticky : AppCompatActivity() {



    private lateinit var mBinding: ActivityStickyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStickyBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }



    companion object{
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivitySticky::class.java))
        }
    }

}
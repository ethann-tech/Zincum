package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBase
import com.ethan.demo.databinding.ActivityContextExtBinding
import io.github.uhsk.kit.android.readAssetFile
import io.github.uhsk.kit.asDrawable

class ActivityContextExt : ActivityBase() {
    private val mLogger: org.slf4j.Logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)
    private lateinit var mBinding: ActivityContextExtBinding

    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityContextExt::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityContextExtBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.toolbar.title = "Context扩展"
        setSupportActionBar(mBinding.toolbar)
        mBinding.toolbar.navigationIcon = R.drawable.nav_back.asDrawable(mContext)

        val assetsFile = baseContext.readAssetFile(path = "test/result.json")
        mLogger.debug("LOG:ActivityContextExt:onCreate: assetsFile={}", assetsFile)
    }
}
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

package com.ethan.demo.ui.activity

import android.os.Build
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityExtensionBinding
import com.ethan.zincum.listener.OnMultiClickListener
import io.github.uhsk.kit.android.dataStore
import io.github.uhsk.kit.android.dp2px
import io.github.uhsk.kit.android.px2dp
import io.github.uhsk.kit.android.px2sp
import io.github.uhsk.kit.android.sp2px
import io.github.uhsk.kit.android.view.imageResource
import io.github.uhsk.kit.android.view.setOnMultiClickListener
import io.github.uhsk.kit.jetpack.datastore.getBoolean
import io.github.uhsk.kit.jetpack.datastore.getDouble
import io.github.uhsk.kit.jetpack.datastore.getFloat
import io.github.uhsk.kit.jetpack.datastore.getInt
import io.github.uhsk.kit.jetpack.datastore.getLong
import io.github.uhsk.kit.jetpack.datastore.getSetString
import io.github.uhsk.kit.jetpack.datastore.getString
import io.github.uhsk.kit.jetpack.datastore.putBoolean
import io.github.uhsk.kit.jetpack.datastore.putDouble
import io.github.uhsk.kit.jetpack.datastore.putFloat
import io.github.uhsk.kit.jetpack.datastore.putInt
import io.github.uhsk.kit.jetpack.datastore.putLong
import io.github.uhsk.kit.jetpack.datastore.putSetString
import io.github.uhsk.kit.jetpack.datastore.putString
import kotlinx.coroutines.launch

class ActivityExtension : ActivityBusinessBase<ActivityExtensionBinding>(), View.OnClickListener {

    override fun layoutResId(): Int = R.layout.activity_extension
    override fun initView() {
        super.initView()
        mBinding.btnContextTest.setOnClickListener(this)
//        mViewBinding.btnContextTest.apply {
//            backgroundResource =R.drawable.ic_launcher_background
//            backgroundDrawable = context.obtainDrawable(R.drawable.ic_launcher_background)
//            backgroundDrawable = context.obtainDrawable(R.drawable.ic_launcher_background)
//        }

        mBinding.btnContextTest1.apply {
            setBackgroundResource(R.color.teal_200)
        }
        mBinding.image.apply {
//            imageDrawable =context.obtainDrawable(R.drawable.ic_launcher_background)
            imageResource = R.drawable.ic_launcher_background
        }


        mBinding.btnDataStoreSave.setOnClickListener {
            lifecycleScope.launch {
                println(mContext.dataStore.hashCode())
                mContext.dataStore.putInt(key = "age", value = 30)
                mContext.dataStore.putBoolean(key = "isHaveMoney", true)
                mContext.dataStore.putDouble(key = "money", value = 312345.345)
                mContext.dataStore.putLong("time", System.nanoTime())
                mContext.dataStore.putFloat("float", 1.24F)
                mContext.dataStore.putString("test", "测试")
                mContext.dataStore.putSetString("set", setOf("1", "2", "3"))
            }
        }
        mBinding.btnDataStoreGet.setOnClickListener {
            lifecycleScope.launch {
                println(mContext.dataStore.getInt(key = "age"))
                println(mContext.dataStore.getBoolean(key = "isHaveMoney"))
                println(mContext.dataStore.getDouble(key = "money"))
                println(mContext.dataStore.getLong("time"))
                println(mContext.dataStore.getFloat("float"))
                println(mContext.dataStore.getString("test"))
                println(mContext.dataStore.getSetString("set"))
                println(mContext.dataStore.hashCode())

            }
        }

        mBinding.btnMulti.setOnClickListener(object : OnMultiClickListener(clickCount = 5, clickDuration = 3000) {
            override fun onMultiClick(v: View) {

            }
        })
        mBinding.btnMulti.setOnMultiClickListener(clickCount = 5, clickDuration = 2000, isClearHits = false) {
            println("在两秒内连续点击了5次")
        }
    }


    override fun onClick(v: View?) {
        when (v) {
            mBinding.btnContextTest -> onClickButtonTest(v)
        }
    }

    private fun onClickButtonTest(view: View) {
        //        this.startActivityForSystemByShutdown()
        println("系统版本= ".plus(Build.VERSION.SDK_INT))
        println("屏幕密度= ".plus(resources.displayMetrics.density))
        println("屏幕ScaleDensity= ".plus(resources.displayMetrics.scaledDensity))
        println("10 dp convert px = ".plus(10.dp2px()))
        println("10 sp convert px= ".plus(10.sp2px()))
        println("10 px convert dp= ".plus(10.px2dp()))
        println("10 px convert sp= ".plus(10.px2sp()))
    }
}

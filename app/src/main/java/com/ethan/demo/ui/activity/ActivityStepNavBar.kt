package com.ethan.demo.ui.activity

import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.ethan.demo.R
import com.ethan.demo.adapter.ViewPagerAdapter
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityStepNavBarBinding

open class ActivityStepNavBar : ActivityBusinessBase<ActivityStepNavBarBinding>() {

    override fun layoutResId(): Int = R.layout.activity_step_nav_bar
    override fun initView() {
        super.initView()
        mBinding.toolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.toolbar.title = "StepNavBar"
        mBinding.toolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        setSupportActionBar(mBinding.toolbar)
        mBinding.toolbar.setNavigationOnClickListener { finish() }
        val steps = arrayOf("Step1", "Step2", "Step3", "Step4", "Step5")
        val chnSteps = arrayOf("步骤一", "步骤二", "步骤三", "步骤四")
        mBinding.stepViewBlue.setStepNames(*steps)
        mBinding.stepViewBlue.setCurrentStep(1)
        mBinding.stepViewGreen.setStepNames(*steps)
        mBinding.stepViewGreen.setCurrentStep(2)
        mBinding.stepViewRed.setStepNames(*chnSteps)
        mBinding.stepViewRed.setCurrentStep(3)
        mBinding.stepViewYellow.setStepNames(*chnSteps)
        mBinding.stepViewYellow.setCurrentStep(4)
        mBinding.stepViewPurple.setStepNames("step1", "step2", "step3", "step4", "step5")
        mBinding.stepViewPurple.setCurrentStep(4)

        val mViewPagerAdapter = ViewPagerAdapter()
        mViewPagerAdapter.addAll(steps.toMutableList())
        mBinding.viewPager2.adapter = mViewPagerAdapter
        mBinding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mBinding.stepViewBlue.setCurrentStep(position + 1)
            }

        })
    }


}
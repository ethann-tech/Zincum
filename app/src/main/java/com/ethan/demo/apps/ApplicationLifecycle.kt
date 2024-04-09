package com.ethan.demo.apps

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

internal open class ApplicationLifecycle : Application(), LifecycleOwner {

    private val mRegistry: LifecycleRegistry = LifecycleRegistry(this)
    private val mHandle: Handler = Handler(Looper.myLooper()!!)
    private var mLastDispatchRunnable: DispatchRunnable? = null

    override val lifecycle: Lifecycle
        get() = mRegistry

    override fun onCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE)
        postDispatchRunnable(Lifecycle.Event.ON_START)
        super.onCreate()
    }

    override fun onTerminate() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP)
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY)
        super.onTerminate()
    }

    private fun postDispatchRunnable(event: Lifecycle.Event) {
        mLastDispatchRunnable?.run()
        mLastDispatchRunnable = DispatchRunnable(mRegistry, event)
        mHandle.postAtFrontOfQueue(mLastDispatchRunnable!!)
    }

    private class DispatchRunnable(private val mRegistry: LifecycleRegistry, private val mEvent: Lifecycle.Event) : Runnable {
        private var mWasExecuted: Boolean = false
        override fun run() {
            if (mWasExecuted)
                return
            mRegistry.handleLifecycleEvent(mEvent)
            mWasExecuted = true
        }
    }

}

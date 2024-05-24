package com.ethan.demo.apps

import android.content.Context
import com.ethan.demo.commons.LoggerKoin
import com.ethan.demo.managers.ILoggerManager
import com.ethan.demo.managers.impls.ImplLoggerManager
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.dsl.module

internal class App : ApplicationLifecycle(),KoinComponent{

    override fun onCreate() {
        super.onCreate()
        initKoin()
        get<ILoggerManager>().init()
    }
    private fun initKoin(){
        startKoin {
            logger(logger = LoggerKoin())
            androidContext(androidContext = this@App)
            modules(mKoinManagerModule)
        }
    }


}

private val mKoinManagerModule = module {
    single<ILoggerManager> { ImplLoggerManager() }
}
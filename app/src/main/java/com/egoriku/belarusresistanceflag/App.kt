package com.egoriku.belarusresistanceflag

import android.app.Application
import com.egoriku.belarusresistanceflag.di.activityModule
import com.egoriku.belarusresistanceflag.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule, activityModule)
        }
    }
}
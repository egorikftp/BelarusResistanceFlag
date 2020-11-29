package com.egoriku.belarusresistanceflag

import android.app.Application
import com.egoriku.belarusresistanceflag.koin.activityModule
import com.egoriku.belarusresistanceflag.koin.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule, activityModule)
        }
    }
}
package com.mytask.app

import android.app.Application
import com.mytask.app.modules.NetworkModule
import com.mytask.app.modules.NewsModules
import com.mytask.app.modules.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(NetworkModule + RepositoryModule + NewsModules)
        }
    }
}
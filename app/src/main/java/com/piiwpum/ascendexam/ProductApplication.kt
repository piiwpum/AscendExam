package com.piiwpum.ascendexam

import android.app.Application
import com.piiwpum.ascendexam.di.appModule
import com.piiwpum.ascendexam.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProductApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ProductApplication)
            androidLogger()
            modules(networkModule, appModule)
        }
    }
}
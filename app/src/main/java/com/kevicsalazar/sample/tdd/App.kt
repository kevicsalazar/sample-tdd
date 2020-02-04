package com.kevicsalazar.sample.tdd

import android.app.Application
import com.kevicsalazar.sample.tdd.di.injectModules


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        injectModules(this)
    }

}
package com.kevicsalazar.sample.tdd.di

import android.app.Application
import com.kevicsalazar.sample.tdd.data.di.dataModules
import com.kevicsalazar.sample.tdd.domain.di.domainModules
import com.kevicsalazar.sample.tdd.features.di.featureModules
import com.kevicsalazar.sample.tdd.utils.listByElementsOf
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal fun injectModules(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(baseModules)
    }
}

val baseModules by lazy {
    listByElementsOf<Module>(
        featureModules,
        domainModules,
        dataModules
    )
}



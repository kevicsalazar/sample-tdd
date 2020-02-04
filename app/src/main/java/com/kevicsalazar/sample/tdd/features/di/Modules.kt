package com.kevicsalazar.sample.tdd.features.di


import com.kevicsalazar.sample.tdd.utils.listByElementsOf
import org.koin.core.module.Module


internal val featureModules by lazy {
    listByElementsOf<Module>()
}

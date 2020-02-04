package com.kevicsalazar.sample.tdd.data.di


import com.kevicsalazar.sample.tdd.utils.listByElementsOf
import org.koin.core.module.Module


internal val dataModules by lazy {
    listByElementsOf<Module>()
}

package com.kevicsalazar.sample.tdd.domain.di


import com.kevicsalazar.sample.tdd.utils.listByElementsOf
import org.koin.core.module.Module


internal val domainModules by lazy {
    listByElementsOf<Module>()
}

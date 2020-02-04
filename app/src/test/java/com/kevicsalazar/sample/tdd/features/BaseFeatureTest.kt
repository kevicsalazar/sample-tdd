package com.kevicsalazar.sample.tdd.features

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before


@ExperimentalCoroutinesApi
open class BaseFeatureTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup0() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

}
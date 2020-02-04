package com.kevicsalazar.sample.tdd.domain.usecases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Test


@ExperimentalCoroutinesApi
class GetUserListUseCaseTest {

    private lateinit var useCase: GetUserListUseCase

    @Test
    fun `When getList method is called return a not empty list`() = runBlockingTest {
        val userList = useCase.getUserList()
        userList.shouldNotBeEmpty()
    }

}
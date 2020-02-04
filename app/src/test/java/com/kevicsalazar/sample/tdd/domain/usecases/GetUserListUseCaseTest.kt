package com.kevicsalazar.sample.tdd.domain.usecases

import com.kevicsalazar.sample.tdd.data.repository.Data
import com.kevicsalazar.sample.tdd.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldHaveSize
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetUserListUseCaseTest {

    private lateinit var useCase: GetUserListUseCase

    private val repository = mockk<UserRepository>()

    @Before
    fun setup() {
        useCase = GetUserListUseCase(repository)
    }

    @Test
    fun `When getList method is called return a not empty list`() = runBlockingTest {
        coEvery { repository.getUserList() } returns Data.userList
        val userList = useCase.getUserList()
        userList.shouldNotBeEmpty()
    }

    @Test
    fun `When getList method is called return a list with one element`() = runBlockingTest {
        coEvery { repository.getUserList() } returns Data.userList
        val userList = useCase.getUserList("maria")
        userList shouldHaveSize 1
    }

}
package com.kevicsalazar.sample.tdd.data.repository

import com.kevicsalazar.sample.tdd.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Test

@ExperimentalCoroutinesApi
class UserRepositoryTest {

    private lateinit var repository: UserRepository

    @Test
    fun `When getList method is called return a not empty list`() = runBlockingTest {
        val userList = repository.getUserList()
        userList.shouldNotBeEmpty()
    }

}
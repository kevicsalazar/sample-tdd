package com.kevicsalazar.sample.tdd.features.list

import com.kevicsalazar.sample.tdd.data.repository.Data
import com.kevicsalazar.sample.tdd.domain.usecases.GetUserListUseCase
import com.kevicsalazar.sample.tdd.features.BaseFeatureTest
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test


@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class UserListPresenterTest : BaseFeatureTest() {

    private lateinit var presenter: UserListPresenter

    private val getUserListUseCase = mockk<GetUserListUseCase>()
    private val view = mockk<UserListView>(relaxed = true)

    @Before
    fun setup() {
        presenter = UserListPresenter(view, getUserListUseCase)
    }

    @Test
    fun `When getList method is called return a not empty list`() = runBlockingTest {

        coEvery { getUserListUseCase.getUserList(any()) } returns Data.userList

        presenter.getList()

        verify(exactly = 1) { view.showList(any()) }

    }

    @Test
    fun `When getList method is called return a failed message`() = runBlockingTest {

        coEvery { getUserListUseCase.getUserList(any()) } throws Exception("Error")

        presenter.getList()

        verify(exactly = 1) { view.onFailure(any()) }

    }

}
package com.kevicsalazar.sample.tdd.features.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.kevicsalazar.sample.tdd.data.repository.Data
import com.kevicsalazar.sample.tdd.domain.usecases.GetUserListUseCase
import com.kevicsalazar.sample.tdd.features.BaseFeatureTest
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class UserListViewModelTest : BaseFeatureTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var userListViewModel: UserListViewModel

    private val getUserListUseCase = mockk<GetUserListUseCase>()

    private val observer = mockk<Observer<UserListViewState>>(relaxed = true)

    @Before
    fun setup() {
        userListViewModel = UserListViewModel(getUserListUseCase)
        userListViewModel.viewState.observeForever(observer)
    }

    @Test
    fun `When getList method is called return a not empty list`() = runBlockingTest {

        // Given
        val slot = slot<UserListViewState>()
        every { observer.onChanged(capture(slot)) } answers { nothing }
        coEvery { getUserListUseCase.getUserList(any()) } returns Data.userList

        // When
        userListViewModel.getList()

        Thread.sleep(1000)

        // Then
        with(slot.captured as UserListViewState.ShowList) {
            list.shouldNotBeEmpty()
        }

    }

    @Test
    fun `When getList method fail return a failed message`() = runBlockingTest {

        // Given
        val slot = slot<UserListViewState>()
        every { observer.onChanged(capture(slot)) } answers { nothing }
        coEvery { getUserListUseCase.getUserList(any()) } throws Exception("Error")

        // When
        userListViewModel.getList()

        Thread.sleep(1000)

        // Then
        with(slot.captured as UserListViewState.Failure) {
            message.shouldNotBeEmpty()
        }

    }

}
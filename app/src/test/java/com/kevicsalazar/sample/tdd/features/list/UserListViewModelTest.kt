package com.kevicsalazar.sample.tdd.features.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class UserListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var userListViewModel: UserListViewModel

    private val observer = mockk<Observer<UserListViewState>>(relaxed = true)

    @Before
    fun setup() {
        userListViewModel = UserListViewModel()
        userListViewModel.viewState.observeForever(observer)
    }

    @Test
    fun `When getList method is called return a not empty list`() {

        // Given
        val slot = slot<UserListViewState>()
        every { observer.onChanged(capture(slot)) } answers { nothing }

        // When
        userListViewModel.getList()

        // Then
        with(slot.captured as UserListViewState.ShowList) {
            list.shouldNotBeEmpty()
        }

    }

    @Test
    fun `When getList method fail return a failed message`() {

        // Given
        val slot = slot<UserListViewState>()
        every { observer.onChanged(capture(slot)) } answers { nothing }

        // When
        userListViewModel.getList()

        // Then
        with(slot.captured as UserListViewState.Failure) {
            message.shouldNotBeEmpty()
        }

    }

}
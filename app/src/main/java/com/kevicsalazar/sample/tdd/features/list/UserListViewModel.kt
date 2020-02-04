package com.kevicsalazar.sample.tdd.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler


class UserListViewModel : ViewModel() {

    val viewState: LiveData<UserListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<UserListViewState>()

    private val handler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }

    fun getList() = Unit

    private fun onError(throwable: Throwable) = Unit

}
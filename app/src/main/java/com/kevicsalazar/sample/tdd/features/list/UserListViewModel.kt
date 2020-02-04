package com.kevicsalazar.sample.tdd.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevicsalazar.sample.tdd.domain.usecases.GetUserListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class UserListViewModel(
    private val useCase: GetUserListUseCase
) : ViewModel() {

    val viewState: LiveData<UserListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<UserListViewState>()

    private val handler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }

    fun getList(query: String = "") {
        viewModelScope.launch(handler) {
            val userList = useCase.getUserList(query)
            _viewState.postValue(UserListViewState.ShowList(userList))
        }
    }

    private fun onError(throwable: Throwable) {
        _viewState.postValue(UserListViewState.Failure(throwable.message!!))
    }

}
package com.kevicsalazar.sample.tdd.features.list

import com.kevicsalazar.sample.tdd.domain.usecases.GetUserListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserListPresenter(
    private val view: UserListView,
    private val useCase: GetUserListUseCase
) {

    fun getList(query: String = "") {
        GlobalScope.launch {
            try {
                val userList = useCase.getUserList(query)
                view.showList(userList)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun onError(throwable: Throwable) {
        view.onFailure(throwable.message!!)
    }

}
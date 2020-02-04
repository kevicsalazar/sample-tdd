package com.kevicsalazar.sample.tdd.features.list

import com.kevicsalazar.sample.tdd.domain.entities.User


sealed class UserListViewState {

    class ShowList(val list: List<User>) : UserListViewState()

    class Failure(val message: String) : UserListViewState()

}
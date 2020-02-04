package com.kevicsalazar.sample.tdd.features.list

import com.kevicsalazar.sample.tdd.domain.entities.User


interface UserListView {

    fun showList(list: List<User>)

    fun onFailure(message: String)

}
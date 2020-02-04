package com.kevicsalazar.sample.tdd.data.repository

import com.kevicsalazar.sample.tdd.domain.entities.User
import com.kevicsalazar.sample.tdd.domain.repository.UserRepository


class UserDataRepository : UserRepository {

    override suspend fun getUserList(): List<User> {
        return Data.userList
    }
}
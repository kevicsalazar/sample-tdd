package com.kevicsalazar.sample.tdd.domain.usecases

import com.kevicsalazar.sample.tdd.domain.entities.User
import com.kevicsalazar.sample.tdd.domain.repository.UserRepository


class GetUserListUseCase(
    private val repository: UserRepository
) {

    suspend fun getUserList(query: String = ""): List<User> {
        return repository.getUserList()
            .filter { it.name.contains(query, ignoreCase = true) }
    }

}
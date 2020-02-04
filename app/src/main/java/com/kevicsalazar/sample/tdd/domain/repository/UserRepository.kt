package com.kevicsalazar.sample.tdd.domain.repository

import com.kevicsalazar.sample.tdd.domain.entities.User


interface UserRepository {

    suspend fun getUserList(): List<User>

}
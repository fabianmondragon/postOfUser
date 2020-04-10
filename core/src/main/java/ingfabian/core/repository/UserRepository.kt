package ingfabian.core.repository

import ingfabian.core.usecases.entity.UserEntity

interface UserRepository {

    suspend fun addUser ( userEntity: UserEntity) : Long

    suspend fun getUser (userEntity: UserEntity): UserEntity?
}
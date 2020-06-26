package ingfabian.core.repository

import ingfabian.core.Result
import ingfabian.core.models.JWTUser
import ingfabian.core.models.JWToken
import ingfabian.core.usecases.entity.UserEntity

interface UserRepository {

    suspend fun addUser ( userEntity: UserEntity) : Result<JWToken?>

    suspend fun getUser (userEntity: UserEntity): UserEntity?
}
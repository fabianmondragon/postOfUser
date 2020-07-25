package ingfabian.core.repository


import ingfabian.core.Result
import ingfabian.core.models.*
import ingfabian.core.usecases.entity.UserEntity

interface UserRepository {

    suspend fun addUser ( userEntity: UserEntity) :  Result<BaseResponse<RegisterResponse>>

    suspend fun getUser (userEntity: UserEntity): UserEntity?

    suspend fun login (userEntity: UserEntity): Result<BaseResponse<UserResponse>>
}
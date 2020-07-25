package ingfabian.core.datasource

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.JWToken
import ingfabian.core.models.RegisterResponse
import ingfabian.core.models.UserResponse
import ingfabian.core.usecases.entity.UserEntity

interface RemoteDataSource {

   suspend fun registerUser (userEntity: UserEntity):  Result<BaseResponse<RegisterResponse>>
   suspend fun login(username: String, password: String): Result<BaseResponse<UserResponse>>

}
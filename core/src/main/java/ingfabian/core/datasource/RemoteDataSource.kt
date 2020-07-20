package ingfabian.core.datasource

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.JWToken
import ingfabian.core.usecases.entity.UserEntity

interface RemoteDataSource {

   suspend fun registerUser (userEntity: UserEntity):  Result<BaseResponse<JWToken>>
}
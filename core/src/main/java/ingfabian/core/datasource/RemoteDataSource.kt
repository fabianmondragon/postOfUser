package ingfabian.core.datasource

import ingfabian.core.Result
import ingfabian.core.models.JWTUser
import ingfabian.core.models.JWToken
import ingfabian.core.usecases.entity.UserEntity

interface RemoteDataSource {

   suspend fun registerUser (userEntity: UserEntity): Result<JWToken>
}
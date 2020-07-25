package ingfabian.core.usecases

import ingfabian.core.Result
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.UserResponse
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity

class Login (val userRepository: UserRepository) {
    suspend fun login (userEntity: UserEntity): Result<BaseResponse<UserResponse>> {
        return userRepository.login(userEntity)
    }
}
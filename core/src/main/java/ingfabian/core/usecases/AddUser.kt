package ingfabian.core.usecases

import ingfabian.core.Result
import ingfabian.core.models.JWTUser
import ingfabian.core.models.JWToken
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity

class AddUser (val userRepository: UserRepository) {

    suspend fun addUser(userEntity: UserEntity): Result<JWToken?> {

        return userRepository.addUser(userEntity)
    }
}
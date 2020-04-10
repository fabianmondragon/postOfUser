package ingfabian.core.usecases

import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity

class Login (val userRepository: UserRepository) {




    suspend fun login (userEntity: UserEntity): UserEntity?{
        return userRepository.getUser(userEntity)


    }
}
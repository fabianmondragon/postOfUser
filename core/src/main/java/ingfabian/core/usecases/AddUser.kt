package ingfabian.core.usecases

import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity

class AddUser (val userRepository: UserRepository) {

    suspend  fun addUser(userEntity: UserEntity):Long{
        return userRepository.addUser(userEntity)
    }
}
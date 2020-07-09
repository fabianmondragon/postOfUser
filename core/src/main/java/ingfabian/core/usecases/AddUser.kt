package ingfabian.core.usecases

import ingfabian.core.Result
import ingfabian.core.Result.Companion.success
import ingfabian.core.models.JWTUser
import ingfabian.core.models.JWToken
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity

class AddUser  (val userRepository: UserRepository) {

    suspend fun addUser(userEntity: UserEntity)= userRepository.addUser(userEntity)





        /*var result = userRepository.addUser(userEntity)
         when (result.status) {
            Result.Status.SUCCESS -> return 0
            Result.Status.ERROR -> return 1
            else -> return 2
        }*/

        //}

}
package ingfabian.userpost.network

import ingfabian.core.usecases.entity.UserEntity

class UserApiHelper (private val apiUser: UserServicee) {

    suspend fun getUser () = apiUser.getUsers()

    suspend fun registerUser(userEntity: UserNetwork) = apiUser.registerUser(userEntity)
}


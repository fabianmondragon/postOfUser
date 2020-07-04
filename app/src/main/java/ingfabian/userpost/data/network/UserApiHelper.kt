package ingfabian.userpost.data.network

import javax.inject.Inject

class UserApiHelper @Inject constructor(private val apiUser: UserServicee) {

    suspend fun getUser () = apiUser.getUsers()

    suspend fun registerUser(userEntity: UserNetwork) = apiUser.registerUser(userEntity)
}


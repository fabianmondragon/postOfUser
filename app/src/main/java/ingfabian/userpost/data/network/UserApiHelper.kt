package ingfabian.userpost.data.network

import javax.inject.Inject

class UserApiHelper @Inject constructor(private val apiUser: UserServicee) {

    suspend fun getUser() = apiUser.getUsers()

    suspend fun registerUser(userEntity: UserNetwork) = apiUser.registerUser(
        userName = userEntity.userName,
        displayName = userEntity.displayName,
        email = userEntity.userEmail,
        password = userEntity.password
    )

    suspend fun login(loginNetwork: LoginNetwork) = apiUser.login(
        userName = loginNetwork.userName,
        password = loginNetwork.password
    )
}


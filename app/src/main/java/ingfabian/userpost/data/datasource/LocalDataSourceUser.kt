package ingfabian.userpost.data.datasource

import ingfabian.userpost.data.frameworks.UserDB

interface LocalDataSourceUser {

    fun addUser (userDB: UserDB): Long

    fun getUser (uderId: Int)


}
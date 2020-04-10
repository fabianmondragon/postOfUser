package ingfabian.core.datasource

import ingfabian.core.usecases.entity.UserEntity

interface LocalDataSourceUser {

    fun addUser (userEntity: UserEntity): Long

    fun getUser (uderId: Int)

    fun getUser (userName: String, password: String):UserEntity?


}
package ingfabian.userpost.data.repository

import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.datasource.LocalDataSourceUser
import ingfabian.userpost.data.frameworks.UserDB

class UserRepositoryImpl (val localDataSourceUser : LocalDataSourceUser): UserRepository {

    lateinit var userDB: UserDB

    override suspend fun addUser(userEntity: UserEntity): Long {
        userDB = UserDB(userEntity.id, userEntity.name, userEntity.userName, userEntity.password)
        return localDataSourceUser.addUser (userDB)
    }
}
package ingfabian.core.repository

import ingfabian.core.datasource.LocalDataSourceUser
import ingfabian.core.usecases.entity.UserEntity

class UserRepositoryImpl (val localDataSourceUser : LocalDataSourceUser): UserRepository {

    override suspend fun getUser(userEntity: UserEntity): UserEntity? {
        return localDataSourceUser.getUser(userEntity.userName, userEntity.password)
    }


    override suspend fun addUser(userEntity: UserEntity): Long {
        return localDataSourceUser.addUser (userEntity)
    }

}
package ingfabian.userpost.data.repository

import ingfabian.core.Result
import ingfabian.core.datasource.LocalDataSourceUser
import ingfabian.core.datasource.RemoteDataSource
import ingfabian.core.models.JWToken
import ingfabian.core.repository.UserRepository
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.network.UserApiHelper
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val localDataSourceUser: LocalDataSourceUser, val remoteDataSource: RemoteDataSource): UserRepository {


    override suspend fun addUser(userEntity: UserEntity): Result<JWToken?> {
        val userApiHelper: UserApiHelper
        //remoteDataSource = RemoteDataSourceImpl(userApiHelper)
        val result = remoteDataSource.registerUser(userEntity)
        return when (result.status) {
            Result.Status.SUCCESS -> success(result.data)
            Result.Status.ERROR -> error("", null)
            else -> error("", null)
        }
    }

    override suspend fun getUser(userEntity: UserEntity): UserEntity? {
        return localDataSourceUser.getUser(userEntity.userName, userEntity.password)
    }

    fun <T> success(data: T): Result<T> {
        return Result(
            Result.Status.SUCCESS,
            data,
            null
        )
    }

    fun <T> error(message: String, data: T? = null): Result<T> {
        return Result(
            Result.Status.ERROR,
            data,
            message
        )
    }

    /* override suspend fun addUser(userEntity: UserEntity): ingfabian.core.Result<JWToken>{




 /*
         val result2: ingfabian.core.Result<JWToken> = remoteDataSource.registerUser(userEntity) as ingfabian.core.Result<JWToken>

         val result: Result<JWToken> = remoteDataSource.registerUser(userEntity)

         when (result.is)


         if(checkType(remoteDataSource.registerUser(userEntity))){
             var hola = ""
         }
         else {
             var hola = ""
         }

         //if (!localDataSourceUser.isUserRegistered(userEntity.userName, userEntity.password)) {

         //}
         return localDataSourceUser.addUser(userEntity)*/
     }*/

    fun checkType(x: Any?): Boolean {
        when (x) {
            is JWToken -> return true
        }
        return false
    }

}
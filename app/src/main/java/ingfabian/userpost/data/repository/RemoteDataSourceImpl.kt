package ingfabian.userpost.data.repository

import ingfabian.core.Result
import ingfabian.core.datasource.RemoteDataSource
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.UserResponse
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.network.*
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val userApiHelper: UserApiHelper) : RemoteDataSource,
    BaseDataSource() {

    override suspend fun registerUser(userEntity: UserEntity) = getResult {

        val mapper = MapperNetwork()
        val resultMapper = mapper.mapperDomainToNetwork(userEntity, Constant.KEY_USER)
        userApiHelper.registerUser(resultMapper as UserNetwork)
    }

    override suspend fun login(
        username: String,
        password: String
    ) = getResult {
        val loginNetwork = LoginNetwork(username, password)
        userApiHelper.login(loginNetwork)
    }
    // return response


}
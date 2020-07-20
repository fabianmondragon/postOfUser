package ingfabian.userpost.data.repository

import ingfabian.core.Result
import ingfabian.userpost.data.network.*
import ingfabian.core.datasource.RemoteDataSource
import ingfabian.core.models.BaseResponse
import ingfabian.core.models.JWToken
import ingfabian.core.usecases.entity.UserEntity
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val userApiHelper: UserApiHelper) : RemoteDataSource, BaseDataSource() {

    override suspend fun registerUser(userEntity: UserEntity) = getResult {

            val mapper = MapperNetwork()
            val resultMapper = mapper.mapperDomainToNetwork(userEntity, Constant.KEY_USER)
            userApiHelper.registerUser(resultMapper as UserNetwork)
        }
       // return response




}
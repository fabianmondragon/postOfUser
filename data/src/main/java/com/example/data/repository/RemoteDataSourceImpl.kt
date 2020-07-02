package com.example.data.repository

import com.example.data.network.*
import ingfabian.core.Result
import ingfabian.core.datasource.RemoteDataSource
import ingfabian.core.models.JWToken
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.network.*

class RemoteDataSourceImpl (val userApiHelper: UserApiHelper) : RemoteDataSource, BaseDataSource()  {

    override suspend fun registerUser(userEntity: UserEntity)= getResult {

        val mapper = MapperNetwork()
        val resultMapper = mapper.mapperDomainToNetwork(userEntity, Constant.KEY_USER)


        userApiHelper.registerUser(resultMapper as UserNetwork)

    }


}
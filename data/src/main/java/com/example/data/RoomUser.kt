package com.example.data

import ingfabian.core.datasource.LocalDataSourceUser
import ingfabian.core.usecases.entity.UserEntity
import com.example.data.frameworks.DataBasePost

class RoomUser : LocalDataSourceUser{
    lateinit var mapperPostData: com.example.data.MapperPostData
    val userDao = com.example.data.frameworks.DataBasePost.getInstance(context).userDBDAO()


    override fun getUser(userName: String, password: String): UserEntity? {
        mapperPostData = com.example.data.MapperPostData()
        val userdb= userDao.getUser(userName, password)
        userdb?.let {
           // return mapperPostData.converUserFromDBToDamin(it)
        }
        return null
    }

    override fun isUserRegistered(userName: String, password: String): Boolean {
        TODO("Not yet implemented")
    }


    override fun addUser(userEntity: UserEntity):Long {
        mapperPostData = com.example.data.MapperPostData()
        //var userDB = mapperPostData.convertUserFromDomainToDB(userEntity)
       // var l=  userDao.addUser(userDB)
        return 1
    }

    override fun getUser(uderId: Int) {

    }

}
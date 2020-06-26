package ingfabian.userpost.data

import android.content.Context
import ingfabian.core.datasource.LocalDataSourceUser
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.frameworks.DataBasePost

class RoomUser (context: Context): LocalDataSourceUser{
    lateinit var mapperPostData: MapperPostData
    val userDao = DataBasePost.getInstance(context).userDBDAO()


    override fun getUser(userName: String, password: String): UserEntity? {
        mapperPostData = MapperPostData()
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
        mapperPostData = MapperPostData()
        //var userDB = mapperPostData.convertUserFromDomainToDB(userEntity)
       // var l=  userDao.addUser(userDB)
        return 1
    }

    override fun getUser(uderId: Int) {

    }

}
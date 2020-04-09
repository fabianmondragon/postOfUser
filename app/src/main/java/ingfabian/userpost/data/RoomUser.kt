package ingfabian.userpost.data

import android.content.Context
import ingfabian.core.datasource.LocalDataSourceUser
import ingfabian.core.usecases.entity.UserEntity
import ingfabian.userpost.data.frameworks.DataBasePost

class RoomUser (context: Context): LocalDataSourceUser{

    lateinit var mapperPostData: MapperPostData
    val userDao = DataBasePost.getInstance(context).userDBDAO()

    override fun addUser(userEntity: UserEntity):Long {
        mapperPostData = MapperPostData()
        var userDB = mapperPostData.convertUserFromDomainToDB(userEntity)
        var l=  userDao.addUser(userDB)
        return l
    }

    override fun getUser(uderId: Int) {

    }

}
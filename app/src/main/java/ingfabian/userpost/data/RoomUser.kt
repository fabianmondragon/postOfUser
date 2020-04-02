package ingfabian.userpost.data

import android.content.Context
import ingfabian.userpost.data.datasource.LocalDataSourceUser
import ingfabian.userpost.data.frameworks.DataBasePost
import ingfabian.userpost.data.frameworks.UserDB

class RoomUser (context: Context): LocalDataSourceUser{

    val userDao = DataBasePost.getInstance(context).userDBDAO()

    override fun addUser(userDB: UserDB):Long {
        return userDao.addUser(userDB)
    }

    override fun getUser(uderId: Int) {

    }

}
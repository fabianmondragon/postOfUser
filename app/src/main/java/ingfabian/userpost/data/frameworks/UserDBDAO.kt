package ingfabian.userpost.data.frameworks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDBDAO {

    @Insert()
    fun addUser( userDB: UserDB): Long


    @Query("SELECT * FROM users WHERE user_name = :userName AND password = :password" )
    fun getUser (userName: String, password: String): UserDB?

}
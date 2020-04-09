package ingfabian.userpost.data.frameworks

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDBDAO {

    @Insert()
    fun addUser( postDB: UserDB): Long

}
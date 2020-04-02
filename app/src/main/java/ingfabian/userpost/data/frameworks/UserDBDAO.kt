package ingfabian.userpost.data.frameworks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserDBDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser( postDB: UserDB): Long

}
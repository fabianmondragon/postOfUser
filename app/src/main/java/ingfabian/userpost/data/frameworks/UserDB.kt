package ingfabian.userpost.data.frameworks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDB (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name="user_id")val userDBId: Int,
    @ColumnInfo(name = "name") val firstName: String?,
    @ColumnInfo(name = "user_name") val userName: String?,
    @ColumnInfo(name = "password")  val password: String?
)
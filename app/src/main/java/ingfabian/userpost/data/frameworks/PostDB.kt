package ingfabian.userpost.data.frameworks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys =
        arrayOf(ForeignKey(entity = UserDB::class,
                parentColumns = arrayOf("user_id"),
            childColumns = arrayOf("fk_user"),
            onDelete = ForeignKey.CASCADE))
    )

data class PostDB (

    @PrimaryKey (autoGenerate = true)
    val postDBId: Int,
    @ColumnInfo(name = "title") val firstName: String?,
    @ColumnInfo(name = "description") val lastName: String?,
    @ColumnInfo (name = "fk_user") val userId: Int
)


package com.example.data.frameworks

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

 class PostDB ()
{
    @PrimaryKey(autoGenerate = true)
    var postDBId: Int = -1

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "description")
    var description: String = ""

    @ColumnInfo(name = "fk_user")
    var userId: Int = -1

    constructor( title:String, description: String, fk_user: Int): this (){
        this.title = title
        this.description = description
        this.userId = fk_user
    }

}




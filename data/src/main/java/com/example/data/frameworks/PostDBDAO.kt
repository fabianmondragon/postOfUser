package com.example.data.frameworks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDBDAO {

    @Query("SELECT * FROM postdb WHERE fk_user = :userId" )
    fun getPostByUser( userId: Int): List<PostDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPost( postDB: PostDB): Long


}
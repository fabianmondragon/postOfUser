package ingfabian.userpost.data.frameworks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostDB::class, UserDB::class], version = 1)
abstract class DataBasePost : RoomDatabase() {

    abstract fun postDBDAO(): PostDBDAO
    abstract fun userDBDAO(): UserDBDAO


    companion object {
        private const val DATABASE_NAME = "post.db"
        private var instance: DataBasePost? = null

        private fun create(context: Context): DataBasePost =
            Room.databaseBuilder(context, DataBasePost::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): DataBasePost =
            (instance ?: create(context)).also { instance = it }

    }
}


package ingfabian.userpost.data

import com.google.gson.Gson
import ingfabian.core.usecases.entity.PostEntity
import ingfabian.userpost.data.frameworks.PostDB


 class MapperPost {
    var gson: Gson

    init {
        gson = Gson()
    }

     private fun toStringModelMapper(value: Any): String {
        return gson.toJson(value)
    }

    fun fromDBtoDomainPost(entityTask: PostDB): PostEntity {
        return gson.fromJson(toStringModelMapper(entityTask), PostEntity::class.java)
    }

    fun fromDomaintoEntityPost(task: PostEntity): PostDB {
        return gson.fromJson(toStringModelMapper(task), PostDB::class.java)
    }

    fun fromListDBtoListDomainPost(entityTaskList: List<PostDB>): List<PostEntity> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(entityTaskList), Array<PostEntity>::class.java).toList()
    }

    fun fromListDomaintoListDB(taskList: List<PostEntity>): List<PostDB> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(taskList), Array<PostDB>::class.java).toList()
    }

}
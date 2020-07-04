package ingfabian.userpost.data

import com.google.gson.Gson
import ingfabian.core.usecases.entity.PostEntity


class MapperPost {
    var gson: Gson

    init {
        gson = Gson()
    }

     private fun toStringModelMapper(value: Any): String {
        return gson.toJson(value)
    }

    fun fromDBtoDomainPost(entityTask: ingfabian.userpost.data.frameworks.PostDB): PostEntity {
        return gson.fromJson(toStringModelMapper(entityTask), PostEntity::class.java)
    }

    fun fromDomaintoEntityPost(task: PostEntity): ingfabian.userpost.data.frameworks.PostDB {
        return gson.fromJson(toStringModelMapper(task), ingfabian.userpost.data.frameworks.PostDB::class.java)
    }

    fun fromListDBtoListDomainPost(entityTaskList: List<ingfabian.userpost.data.frameworks.PostDB>): List<PostEntity> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(entityTaskList), Array<PostEntity>::class.java).toList()
    }

    fun fromListDomaintoListDB(taskList: List<PostEntity>): List<ingfabian.userpost.data.frameworks.PostDB> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(taskList), Array<ingfabian.userpost.data.frameworks.PostDB>::class.java).toList()
    }

}
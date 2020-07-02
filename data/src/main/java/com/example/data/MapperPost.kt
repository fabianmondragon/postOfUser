package com.example.data

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

    fun fromDBtoDomainPost(entityTask: com.example.data.frameworks.PostDB): PostEntity {
        return gson.fromJson(toStringModelMapper(entityTask), PostEntity::class.java)
    }

    fun fromDomaintoEntityPost(task: PostEntity): com.example.data.frameworks.PostDB {
        return gson.fromJson(toStringModelMapper(task), com.example.data.frameworks.PostDB::class.java)
    }

    fun fromListDBtoListDomainPost(entityTaskList: List<com.example.data.frameworks.PostDB>): List<PostEntity> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(entityTaskList), Array<PostEntity>::class.java).toList()
    }

    fun fromListDomaintoListDB(taskList: List<PostEntity>): List<com.example.data.frameworks.PostDB> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(taskList), Array<com.example.data.frameworks.PostDB>::class.java).toList()
    }

}
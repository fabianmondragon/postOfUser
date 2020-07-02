package com.example.data.network

import android.service.autofill.UserData
import com.google.gson.Gson
import com.google.gson.GsonBuilder


class MapperNetwork {

    fun mapperDomainToNetwork(origin: Any, destiny: Any): Any? {
        var jsonOrigin = origin.toJson()
        when (destiny){
            Constant.KEY_USER -> return Gson().fromJson(jsonOrigin, UserNetwork::class.java)
        }
        return null

    }

    private fun Any.toJson(): String {
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()
        val jsonPretty: String = gsonPretty.toJson(this)
        return jsonPretty
    }
}



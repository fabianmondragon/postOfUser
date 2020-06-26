package com.example.data.api

import com.google.gson.annotations.SerializedName

data class Respoonse<T> (

        @SerializedName("results")
        val results: T
    )

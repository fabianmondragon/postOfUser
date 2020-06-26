package com.example.data.models

import javax.print.attribute.standard.JobOriginatingUserName

data class UserData (
    val userName: String,
    val email:String,
    val password: String,
    val displayName: String
)
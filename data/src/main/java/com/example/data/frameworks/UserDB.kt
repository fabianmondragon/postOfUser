package com.example.data.frameworks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
 class UserDB (){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name="user_id")
    var userDBId: Int = 0


    @ColumnInfo(name = "name")
    var firstName: String = ""

    @ColumnInfo(name = "user_name")
    var userName: String = ""

    @ColumnInfo(name = "password")
    var password: String =""

    @ColumnInfo(name = "age")
    var age: Int =-1

    constructor(firstName: String, userName: String, password: String, age: Int): this (){
        this.firstName = firstName
        this.userName = userName
        this.password = password
        this.age = age
    }
}

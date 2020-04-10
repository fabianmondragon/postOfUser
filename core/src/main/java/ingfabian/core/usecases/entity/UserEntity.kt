package ingfabian.core.usecases.entity

data class UserEntity ( var id: Int = -1, var name: String, var userName: String,  var age: Int = 0, var password: String
                        ){

    constructor(userName: String, password: String):this(name = "",userName = userName, password = password)



}
package ingfabian.core.usecases.entity

data class UserEntity(val userName: String, val password: String) {

    lateinit var email: String
    lateinit var displayName: String

    constructor(userName: String, password: String, email: String, displayName: String) : this(
        userName,
        password
    ) {
        this.email = email
        this.displayName = displayName

    }
}








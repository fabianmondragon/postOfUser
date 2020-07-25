package ingfabian.userpost.data.network

import com.google.gson.annotations.SerializedName

class LoginNetwork(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("password")
    val password: String
)
package ingfabian.userpost.data.network

import com.google.gson.annotations.SerializedName

data class UserNetwork(
    @SerializedName("avatar")
    val image: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("id")
    val userId: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("password")
    val password: String

    )

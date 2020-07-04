package ingfabian.userpost.data.network

import com.google.gson.annotations.SerializedName

data class UserNetwork (@SerializedName("avatar")
                  val image: String,
                        @SerializedName("email")
                  val userEmail: String,
                        @SerializedName("id")
                  val userId: String,
                        @SerializedName("name")
                  val userName: String)

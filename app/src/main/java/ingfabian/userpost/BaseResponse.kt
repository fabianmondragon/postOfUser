package ingfabian.userpost

import com.google.gson.annotations.SerializedName

class BaseResponse<T> (
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: T)

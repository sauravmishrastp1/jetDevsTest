package com.imaginato.homeworkmvvm.data.remote.demo.response
import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("errorCode")
    var errorCode: String,
    @SerializedName("errorMessage")
    var errorMessage: String
)

data class Data(
    @SerializedName("isDeleted")
    var isDeleted: Boolean,
    @SerializedName("userId")
    var userId: String,
    @SerializedName("userName")
    var userName: String
)
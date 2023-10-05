package com.example.todoapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @field:SerializedName("userId")
    val userId: Int? = null,

    @field:SerializedName("completed")
    val completed: List<ResponseItem>? = null,

    @field:SerializedName("title")
    val pending:List<ResponseItem>? = null

) : Parcelable
package com.eldmandate.todoapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("completed")
	val completed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
) : Parcelable

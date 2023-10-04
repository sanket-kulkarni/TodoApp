package com.eldmandate.todoapp.networkRepo

import com.eldmandate.todoapp.model.ResponseItem
import retrofit2.http.GET

interface NetworkingService {
    @GET("v1/03a0513c-98d9-4309-8b6f-52f45af7fd09")
    suspend fun getResponse(): List<ResponseItem>
}
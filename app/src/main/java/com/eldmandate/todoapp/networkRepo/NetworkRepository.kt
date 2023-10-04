package com.eldmandate.todoapp.networkRepo

import com.eldmandate.todoapp.model.ResponseItem
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val networkingService: NetworkingService) {
    suspend fun getResponse(): List<ResponseItem> = networkingService.getResponse()
}
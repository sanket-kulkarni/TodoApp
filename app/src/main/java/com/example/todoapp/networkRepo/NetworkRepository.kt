package com.example.todoapp.networkRepo

import com.example.todoapp.model.ResponseItem
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val networkingService: NetworkingService) {
    suspend fun getResponse(): List<ResponseItem> = networkingService.getResponse()
}
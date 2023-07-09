package com.example.data.Repository

import com.example.Domain.model.InitModel
import com.example.Domain.repository.InitRepository
import com.example.data.ApiService
import javax.inject.Inject

class InitRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : InitRepository {
    override suspend fun init(): InitModel {
        return apiService.init()
    }
}
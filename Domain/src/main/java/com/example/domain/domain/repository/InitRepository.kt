package com.example.Domain.repository

import com.example.Domain.model.InitModel

interface InitRepository {
    suspend fun init() : InitModel
}
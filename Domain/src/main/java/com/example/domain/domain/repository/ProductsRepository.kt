package com.example.Domain.repository

import com.example.Domain.model.ProductsModel

interface ProductsRepository {
    suspend fun getProducts() : ProductsModel
}
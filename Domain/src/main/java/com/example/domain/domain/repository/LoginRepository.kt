package com.example.Domain.repository

import com.example.Domain.model.LoginModel.LoginModel
import com.example.Domain.param.LoginParam

interface LoginRepository {
    suspend fun login(loginParam: LoginParam) : LoginModel
}
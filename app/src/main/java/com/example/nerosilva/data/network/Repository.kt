package com.example.nerosilva.data.network

import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun registerUser(request: RegisterRequest) = apiService.registerUser(request)
    suspend fun loginUser(request: LoginRequest) = apiService.loginUser(request)
    suspend fun verifyToken(token: String) = apiService.verifyToken(token)
    suspend fun getPlants() = apiService.getPlants()
    suspend fun createPlan(token: String, request: PlanRequest) = apiService.createPlan(token, request)
    suspend fun getUserPlans(token: String, userId: String) = apiService.getUserPlans(token, userId)
}
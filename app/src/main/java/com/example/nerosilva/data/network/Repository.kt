package com.example.nerosilva.data.network

class Repository {
    private val apiService = RetrofitInstance.api

    suspend fun registerUser(request: RegisterRequest) = apiService.registerUser(request)
    suspend fun loginUser(request: LoginRequest) = apiService.loginUser(request)
    suspend fun verifyToken(token: String) = apiService.verifyToken(token)
    suspend fun getPlants() = apiService.getPlants()
    suspend fun createPlan(token: String, request: PlanRequest) = apiService.createPlan(token, request)
    suspend fun getUserPlans(token: String, userId: String) = apiService.getUserPlans(token, userId)
}

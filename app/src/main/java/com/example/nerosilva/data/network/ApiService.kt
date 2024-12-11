package com.example.nerosilva.data.network

import retrofit2.Response
import retrofit2.http.*

data class RegisterRequest(val fullname: String, val email: String, val password: String)
data class LoginRequest(val email: String, val password: String)
data class PlanRequest(val user_id: String, val plant_id: String, val count: String)

data class RegisterResponse(val status: String, val message: String, val data: Map<String, String>?)
data class LoginResponse(val status: String, val message: String, val token: String)
data class PlantResponse(val id: String, val name: String, val description: String)

interface ApiService {
    @POST("/register")
    suspend fun registerUser(@Body request: RegisterRequest): RegisterResponse

    @POST("/login")
    suspend fun loginUser(@Body request: LoginRequest): LoginResponse

    @POST("/verify")
    suspend fun verifyToken(@Header("Authorization") token: String): Map<String, String>

    @GET("/plant")
    suspend fun getPlants(): List<PlantResponse>

    @POST("/plan")
    suspend fun createPlan(
        @Header("Authorization") token: String,
        @Body request: PlanRequest
    ): Response<Unit>

    @POST("/plan/{id}")
    suspend fun getUserPlans(@Header("Authorization") token: String, @Path("id") userId: String): List<Map<String, String>>
}
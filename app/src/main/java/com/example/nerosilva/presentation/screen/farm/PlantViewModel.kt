package com.example.nerosilva.presentation.screen.farm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nerosilva.data.network.PlanRequest
import com.example.nerosilva.data.network.Repository
import com.example.nerosilva.data.network.PlantResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PlanViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _plants = MutableStateFlow<List<PlantResponse>>(emptyList())
    val plants: StateFlow<List<PlantResponse>> = _plants

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchPlants()
    }

    private fun fetchPlants() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val plantList = repository.getPlants()
                _plants.value = plantList
            } catch (e: Exception) {
                _error.value = "Failed to fetch plants: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun createPlan(token: String, userId: String, plantId: String, count: String) {
        if (token.isEmpty() || userId.isEmpty()) {
            _error.value = "Token or user ID is invalid"
            return
        }
        viewModelScope.launch {
            try {
                val planRequest = PlanRequest(userId, plantId, count)
                val response = repository.createPlan(token, planRequest)
                if (!response.isSuccessful) {
                    _error.value = "Failed to create plan: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Failed to create plan: ${e.message}"
            }
        }
    }
}

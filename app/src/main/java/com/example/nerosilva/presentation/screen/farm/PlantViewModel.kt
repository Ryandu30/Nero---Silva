package com.example.nerosilva.presentation.screen.farm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nerosilva.data.network.PlanRequest
import com.example.nerosilva.data.network.Repository
import com.example.nerosilva.data.network.PlantResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    // List of plants state
    private val _plants = MutableStateFlow<List<PlantResponse>>(emptyList())
    val plants: StateFlow<List<PlantResponse>> get() = _plants

    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    // Error and success states
    private val _state = MutableStateFlow<PlanState>(PlanState.Idle)
    val state: StateFlow<PlanState> get() = _state

    init {
        fetchPlants()
    }

    private fun fetchPlants() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val plantList = repository.getPlants()
                _plants.value = plantList
                _state.value = PlanState.PlantsFetched(plantList)
            } catch (e: Exception) {
                _state.value = PlanState.Error("Failed to fetch plants: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun createPlan(token: String, userId: String, plantId: String, count: String) {
        if (token.isBlank() || userId.isBlank() || plantId.isBlank() || count.isBlank()) {
            _state.value = PlanState.Error("All fields must be filled out")
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                val planRequest = PlanRequest(user_id = userId, plant_id = plantId, count = count)
                val response = repository.createPlan(token = token, request = planRequest)
                if (response.isSuccessful) {
                    _state.value = PlanState.Success("Plan created successfully!")
                } else {
                    _state.value = PlanState.Error("Failed to create plan: ${response.message()}")
                }
            } catch (e: Exception) {
                _state.value = PlanState.Error("Failed to create plan: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Sealed class for different states (loading, error, success, etc.)
    sealed class PlanState {
        object Idle : PlanState()
        object Loading : PlanState()
        data class Error(val message: String) : PlanState()
        data class Success(val message: String) : PlanState()
        data class PlantsFetched(val plants: List<PlantResponse>) : PlanState()
    }
}


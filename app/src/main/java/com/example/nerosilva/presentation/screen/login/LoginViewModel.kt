package com.example.nerosilva.presentation.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.nerosilva.data.firebase.AuthRepository
import com.example.nerosilva.data.firebase.Resource
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun loginUser (email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.loginUser (email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = LoginState(success = "Login Berhasil")
                        home()
                    }
                    is Resource.Loading -> {
                        _state.value = LoginState(loading = true)
                    }
                    is Resource.Error -> {
                        _state.value = LoginState(error = result.message)
                    }
                }
            }
        }
    }

    fun registerUser (email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.registerUser (email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = LoginState(success = "Register Berhasil")
                        home()
                    }
                    is Resource.Loading -> {
                        _state.value = LoginState(loading = true)
                    }
                    is Resource.Error -> {
                        _state.value = LoginState(error = result.message)
                    }
                }
            }
        }
    }
}
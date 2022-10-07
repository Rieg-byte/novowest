package com.example.novowest.ui.view

import androidx.lifecycle.ViewModel
import com.example.novowest.data.userEmail
import com.example.novowest.data.userPassword
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _signInUiState = MutableStateFlow(SignInUiState())
    val signInUiState: StateFlow<SignInUiState> = _signInUiState.asStateFlow()
    val email: MutableStateFlow<String> = MutableStateFlow("")
    val password: MutableStateFlow<String> = MutableStateFlow("")
    fun onLoginPressed(){

    }
    fun checkUserEmailOrPassword(): Boolean {
        return if (email.value == userEmail && password.value == userPassword) {
            _signInUiState.update { currentState ->
                currentState.copy(isWrong = false)
            }
            true
        } else {
            _signInUiState.update { currentState ->
                currentState.copy(isWrong = true)
            }
            false
        }
    }
}
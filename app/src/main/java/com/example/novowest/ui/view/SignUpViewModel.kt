package com.example.novowest.ui.view

import androidx.lifecycle.ViewModel
import com.example.novowest.data.userEmail
import com.example.novowest.data.userPassword
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {
    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState: StateFlow<SignUpUiState> = _signUpUiState.asStateFlow()
    val email: MutableStateFlow<String> = MutableStateFlow("")
    val password: MutableStateFlow<String> = MutableStateFlow("")
    val login: MutableStateFlow<String> = MutableStateFlow("")
    fun onRegistrationPressed(){
    }
    fun checkField() {
        return if (email.value.isBlank() && password.value.isBlank()) {
            _signUpUiState.update { currentState ->
                currentState.copy(isWrong = true)
            }
        } else {
            _signUpUiState.update { currentState ->
                currentState.copy(isWrong = false)
            }
        }
    }
}
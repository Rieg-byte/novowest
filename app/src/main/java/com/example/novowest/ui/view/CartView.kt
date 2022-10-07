package com.example.novowest.ui.view

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.novowest.data.cartList
import com.example.novowest.model.Dish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CartView: ViewModel() {
    private val _cartUiState = MutableStateFlow(CartUiState())
    fun addI(item: Dish){
        cartList.add(item)
    }
    fun removeI(item: Dish){
        cartList.remove(item)
    }
    fun addInCart(item: Dish){
        if (cartList.isEmpty()){
            if (!cartList.contains(item)){
                cartList.add(item)
                _cartUiState.update {
                        currentState ->
                    currentState.copy(isEmpty = false)
                }
            }
        }
        else{
            if (!cartList.contains(item)){
                cartList.add(item)
                _cartUiState.update {
                        currentState ->
                    currentState.copy(isEmpty = false)
                }
            }
        }
    }
}


package com.example.novowest.data

import com.example.novowest.model.Dish

val cartList: MutableList<Dish> = mutableListOf<Dish>()
fun getPrice(cartList: MutableList<Dish>): Int {
    var price = 0
    return if (cartList.isNotEmpty()) {
        for (i in cartList) {
            price += i.price
        }
        price
    } else {
        0
    }
}
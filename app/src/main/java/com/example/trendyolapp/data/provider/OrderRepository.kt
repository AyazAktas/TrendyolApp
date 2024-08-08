package com.example.trendyolapp.data.provider

import com.example.trendyolapp.data.entity.Order

object OrderRepository {
    private val orderList = mutableListOf<Order>()

    fun addOrder(order: Order) {
        orderList.add(order)
    }

    fun getOrders(): List<Order> {
        return orderList
    }
}
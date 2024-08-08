package com.example.trendyolapp.data.entity

data class Order(val orderCode: String,
                 val date: String,
                 val time: String,
                 val products: List<Urun>)

package com.example.trendyolapp.data.provider

import com.example.trendyolapp.data.entity.Kupon

object KuponDataProvider {
    fun getKuponlarListesi(): ArrayList<Kupon> {
        val kuponlarListesi = ArrayList<Kupon>()
        kuponlarListesi.add(Kupon(1, "kuponbir"))
        kuponlarListesi.add(Kupon(2, "kuponiki"))
        return kuponlarListesi
    }
}
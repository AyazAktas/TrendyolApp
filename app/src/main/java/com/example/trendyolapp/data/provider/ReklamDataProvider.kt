package com.example.trendyolapp.data.provider


import com.example.trendyolapp.data.entity.Reklam

object ReklamDataProvider {
    fun getReklamlarListesi(): ArrayList<Reklam> {
        val reklamlarListesi = ArrayList<Reklam>()
        reklamlarListesi.add(Reklam(1, "reklam_bir"))
        reklamlarListesi.add(Reklam(2, "reklam"))
        reklamlarListesi.add(Reklam(3, "reklam_uc"))
        reklamlarListesi.add(Reklam(4, "reklam_dort"))
        return reklamlarListesi
    }
}
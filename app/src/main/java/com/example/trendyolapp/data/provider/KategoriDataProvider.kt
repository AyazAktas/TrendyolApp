package com.example.trendyolapp.data.provider
import com.example.trendyolapp.data.entity.Kategori


object KategoriDataProvider {
    fun getKategoriListesi(): ArrayList<Kategori> {
        val kategoriListesi = ArrayList<Kategori>()
        kategoriListesi.add(Kategori(1,"Sweatshirt","sweatshirt"))
        kategoriListesi.add(Kategori(2,"Dış Giyim","disgiyim"))
        kategoriListesi.add(Kategori(3,"Cilt Bakım","ciltbakim"))
        kategoriListesi.add(Kategori(4,"Sofra & Mutfak","sofra"))
        kategoriListesi.add(Kategori(5,"Sneaker","sneaker"))
        kategoriListesi.add(Kategori(6,"Bahçe ve Yapı Market","bahce"))
        kategoriListesi.add(Kategori(7,"Ev Tekstili","evtekstili"))
        kategoriListesi.add(Kategori(8,"Elektrikli Ev Aletleri","elektriklievaletleri"))
        kategoriListesi.add(Kategori(9,"Mobilya","koltuk"))
        kategoriListesi.add(Kategori(10,"Bot & Bootie","bot"))
        return kategoriListesi
    }
}
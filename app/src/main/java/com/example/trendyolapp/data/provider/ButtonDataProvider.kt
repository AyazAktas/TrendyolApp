package com.example.trendyolapp.data.provider

import com.example.trendyolapp.data.entity.Butonlar

object ButtonDataProvider {
    fun getButonlarListesi(): ArrayList<Butonlar> {
        val butonlarListesi = ArrayList<Butonlar>()
        butonlarListesi.add(Butonlar(1, "Erkek"))
        butonlarListesi.add(Butonlar(2, "Kadın"))
        butonlarListesi.add(Butonlar(3, "Ev & Yaşam"))
        butonlarListesi.add(Butonlar(4, "Spor&Outdoor"))
        butonlarListesi.add(Butonlar(5, "Elektronik"))
        butonlarListesi.add(Butonlar(6, "Moda"))
        butonlarListesi.add(Butonlar(7, "Süpermarket"))
        butonlarListesi.add(Butonlar(8, "Saat & Aksesuar"))
        butonlarListesi.add(Butonlar(9, "Oto & Yapı Market"))
        butonlarListesi.add(Butonlar(10, "Anne & Çocuk"))
        butonlarListesi.add(Butonlar(11, "Kozmetik"))
        butonlarListesi.add(Butonlar(12, "Ayakkabı & Çanta"))
        butonlarListesi.add(Butonlar(13, "Luxury"))
        butonlarListesi.add(Butonlar(14, "Dolap"))
        butonlarListesi.add(Butonlar(15, "Kitap & Kırtasiye"))
        butonlarListesi.add(Butonlar(16, "Hobi & Müzik"))
        butonlarListesi.add(Butonlar(17, "İş Yerine Özel"))
        return butonlarListesi
    }
}
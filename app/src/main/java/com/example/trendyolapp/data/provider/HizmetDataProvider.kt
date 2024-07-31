package com.example.trendyolapp.data.provider

import com.example.trendyolapp.data.entity.Hizmet

object HizmetDataProvider {
    fun getHizmetListesi(): ArrayList<Hizmet> {
        val hizmetListesi = ArrayList<Hizmet>()
        hizmetListesi.add(Hizmet(1, "Hızlı Market", "hizlimarket"))
        hizmetListesi.add(Hizmet(2, "Yemek", "yemek"))
        hizmetListesi.add(Hizmet(3, "Futbol Aşkı", "futbolaski"))
        hizmetListesi.add(Hizmet(4, "Al, Sat, Kazan", "alsatkazan"))
        hizmetListesi.add(Hizmet(5, "Trendyol Pozitif", "trendeyolpozitif"))
        hizmetListesi.add(Hizmet(6, "Spora Başla", "sporabasla"))
        hizmetListesi.add(Hizmet(7, "Finansal Çözüm", "finansalcozumler"))
        hizmetListesi.add(Hizmet(8, "Kuponlar", "kuponlar"))
        hizmetListesi.add(Hizmet(9, "Kredi Kartı", "kredikarti"))
        hizmetListesi.add(Hizmet(10, "Kategoriler", "kategoriler"))
        return hizmetListesi
    }
}
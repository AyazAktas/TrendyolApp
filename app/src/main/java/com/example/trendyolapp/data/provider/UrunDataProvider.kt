// UrunDataProvider.kt
package com.example.trendyolapp.data.provider

import com.example.trendyolapp.data.entity.Urun

object UrunDataProvider {
    fun getUrunListesi(): ArrayList<Urun> {
        val urunlistesi = ArrayList<Urun>()
        urunlistesi.add(Urun(1, "GIVENCHY", "Givenchy Gentleman Edp 100 ml Erkek Parfüm", "givenchy", 4954))
        urunlistesi.add(Urun(2, "Bershka", "Kısa kollu Machine Gun Kelly baskılı boxy fit t-shirt", "mgktisort", 450))
        urunlistesi.add(Urun(3, "Mitra Yayınları", "Agnostisizm ve İlahi Tragedya - Diamond Tema, Kağıt Kapak ", "diokitap", 415))
        urunlistesi.add(Urun(4, "Wilson", "Wilson Blade 25 V8 Tenis Raketi WR079310", "tenisraketi", 6260))
        urunlistesi.add(Urun(5, "İletişim Yayınları", "Oğuz Atay - Tehlikeli Oyunlar", "tehlikelioyunlar", 230))
        urunlistesi.add(Urun(6, "YAMAHA", "Yamaha Pacifica PA112VBL Elektro Gitar (Siyah)", "elektrogitar", 16487))
        return urunlistesi
    }
}

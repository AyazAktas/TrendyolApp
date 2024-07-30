package com.example.trendyolapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendyolapp.data.entity.Urun

class UrunViewModel : ViewModel() {
    private val _favoriUrunler = MutableLiveData<MutableList<Urun>>(mutableListOf())
    val favoriUrunler: LiveData<MutableList<Urun>> get() = _favoriUrunler

    private val _sepetUrunler = MutableLiveData<MutableList<Urun>>(mutableListOf())
    val sepetUrunler: LiveData<MutableList<Urun>> get() = _sepetUrunler

    fun urunEkle(urun: Urun) {
        val mevcutFavoriUrunler = _favoriUrunler.value ?: mutableListOf()
        if (urun !in mevcutFavoriUrunler) {
            mevcutFavoriUrunler.add(urun)
            _favoriUrunler.value = mevcutFavoriUrunler
        }
    }

    fun urunKaldir(urun: Urun) {
        val mevcutFavoriUrunler = _favoriUrunler.value ?: mutableListOf()
        if (urun in mevcutFavoriUrunler) {
            mevcutFavoriUrunler.remove(urun)
            _favoriUrunler.value = mevcutFavoriUrunler
        }
    }

    fun urunSepeteEkle(urun: Urun) {
        val mevcutSepetUrunler = _sepetUrunler.value ?: mutableListOf()
        if (urun !in mevcutSepetUrunler) {
            mevcutSepetUrunler.add(urun)
            _sepetUrunler.value = mevcutSepetUrunler
        }
    }

    fun urunSepettenKaldir(urun: Urun) {
        val mevcutSepetUrunler = _sepetUrunler.value ?: mutableListOf()
        if (urun in mevcutSepetUrunler) {
            mevcutSepetUrunler.remove(urun)
            _sepetUrunler.value = mevcutSepetUrunler
        }
    }

    fun getSepetUrunleri(): List<Urun> {
        return _sepetUrunler.value ?: listOf()
    }
    fun getSepetUrunSayisi(): Int {
        return _sepetUrunler.value?.size ?: 0
    }
    fun getToplamFiyat(): Int {
        return _sepetUrunler.value?.sumOf { it.urunFiyat } ?: 0
    }
}

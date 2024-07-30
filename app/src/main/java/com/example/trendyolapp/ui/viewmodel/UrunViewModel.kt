package com.example.trendyolapp.ui.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendyolapp.data.entity.Urun

class UrunViewModel : ViewModel() {
    private val _favoriUrunler = MutableLiveData<MutableList<Urun>>(mutableListOf())
    val favoriUrunler: LiveData<MutableList<Urun>> get() = _favoriUrunler

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
}

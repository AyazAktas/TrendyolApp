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

    private val _siparisUrunler = MutableLiveData<MutableList<Urun>>(mutableListOf())
    val siparisUrunler: LiveData<MutableList<Urun>> get() = _siparisUrunler

    fun urunEkle(urun: Urun): Boolean {
        val mevcutFavoriUrunler = _favoriUrunler.value ?: mutableListOf()
        return if (mevcutFavoriUrunler.none { it.id == urun.id }) {
            mevcutFavoriUrunler.add(urun)
            _favoriUrunler.value = mevcutFavoriUrunler
            true
        } else {
            false
        }
    }

    fun urunKaldir(urun: Urun) {
        val mevcutFavoriUrunler = _favoriUrunler.value ?: mutableListOf()
        if (mevcutFavoriUrunler.any { it.id == urun.id }) {
            mevcutFavoriUrunler.removeAll { it.id == urun.id }
            _favoriUrunler.value = mevcutFavoriUrunler
        }
    }

    fun urunSepeteEkle(urun: Urun) {
        val mevcutSepetUrunler = _sepetUrunler.value ?: mutableListOf()
        mevcutSepetUrunler.add(urun)
        _sepetUrunler.value = mevcutSepetUrunler
    }

    fun urunSepettenKaldir(urun: Urun) {
        val mevcutSepetUrunler = _sepetUrunler.value ?: mutableListOf()
        mevcutSepetUrunler.remove(urun)
        _sepetUrunler.value = mevcutSepetUrunler
    }

    fun urunSipariseEkle(urun: Urun) {
        val mevcutSiparisUrunler = mutableListOf<Urun>()
        mevcutSiparisUrunler.add(urun)
        _siparisUrunler.value = mevcutSiparisUrunler
    }

    fun urunSiparistenKaldir(urun: Urun) {
        val mevcutSiparisUrunler = _siparisUrunler.value ?: mutableListOf()
        mevcutSiparisUrunler.remove(urun)
        _siparisUrunler.value = mevcutSiparisUrunler
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
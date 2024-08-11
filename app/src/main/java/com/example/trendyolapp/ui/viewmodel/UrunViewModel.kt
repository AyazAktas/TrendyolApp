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

    private val _sepetOnaylandi = MutableLiveData<Boolean>()
    val sepetOnaylandi: LiveData<Boolean> get() = _sepetOnaylandi

    fun urunEkle(urun: Urun): Boolean {
        return urunEkle(_favoriUrunler, urun)
    }

    fun urunKaldir(urun: Urun) {
        urunKaldir(_favoriUrunler, urun)
    }

    fun urunSepeteEkle(urun: Urun) {
        urunSepeteEkle(_sepetUrunler, urun)
    }

    fun urunSepettenKaldir(urun: Urun) {
        urunSepettenKaldir(_sepetUrunler, urun)
    }

    fun urunSipariseEkle(urun: Urun) {
        _siparisUrunler.value = mutableListOf(urun)
    }

    fun urunSiparistenKaldir(urun: Urun) {
        urunKaldir(_siparisUrunler, urun)
    }

    fun getToplamSepetUrunSayisi(): Int {
        return _sepetUrunler.value?.sumOf { it.quantity } ?: 0
    }

    fun getToplamFiyat(): Int {
        return _sepetUrunler.value?.sumOf { it.urunFiyat * it.quantity } ?: 0
    }

    fun sepetiOnayla() {
        _siparisUrunler.value = _sepetUrunler.value?.toMutableList() ?: mutableListOf()
        _sepetOnaylandi.value = true
    }

    fun sepetOnayDurumunuSifirla() {
        _sepetOnaylandi.value = false
    }

    private fun urunEkle(liveData: MutableLiveData<MutableList<Urun>>, urun: Urun): Boolean {
        val mevcutUrunler = liveData.value ?: mutableListOf()
        return if (mevcutUrunler.none { it.id == urun.id }) {
            mevcutUrunler.add(urun)
            liveData.value = mevcutUrunler
            true
        } else {
            false
        }
    }

    private fun urunKaldir(liveData: MutableLiveData<MutableList<Urun>>, urun: Urun) {
        val mevcutUrunler = liveData.value ?: mutableListOf()
        mevcutUrunler.removeAll { it.id == urun.id }
        liveData.value = mevcutUrunler
    }

    private fun urunSepeteEkle(liveData: MutableLiveData<MutableList<Urun>>, urun: Urun) {
        val mevcutUrunler = liveData.value ?: mutableListOf()
        val mevcutUrun = mevcutUrunler.find { it.id == urun.id }
        if (mevcutUrun != null) {
            mevcutUrun.quantity += 1
        } else {
            urun.quantity = 1
            mevcutUrunler.add(urun)
        }
        liveData.value = mevcutUrunler
    }

    private fun urunSepettenKaldir(liveData: MutableLiveData<MutableList<Urun>>, urun: Urun) {
        val mevcutUrunler = liveData.value ?: mutableListOf()
        val mevcutUrun = mevcutUrunler.find { it.id == urun.id }
        if (mevcutUrun != null) {
            if (mevcutUrun.quantity > 1) {
                mevcutUrun.quantity -= 1
            } else {
                mevcutUrunler.remove(mevcutUrun)
            }
            liveData.value = mevcutUrunler
        }
    }
}

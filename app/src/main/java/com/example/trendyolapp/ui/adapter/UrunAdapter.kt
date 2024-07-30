package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.CardViewUrunlerBinding
import com.example.trendyolapp.ui.fragment.AnasayfaFragmentDirections
import com.example.trendyolapp.ui.fragment.TumUrunlerFragmentDirections

class UrunAdapter(
    private val mContext: Context,
    private var urunListesi: List<Urun>,
    private val fromFragment: String
) : RecyclerView.Adapter<UrunAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardViewUrunlerBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardViewUrunlerBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return urunListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunListesi[position]
        val u = holder.tasarim
        u.urunResim.setImageResource(mContext.resources.getIdentifier(urun.urunResim, "drawable", mContext.packageName))
        u.urunMarka.text = urun.urunMarka
        u.urunFiyat.text = "${urun.urunFiyat} TL"
        u.urunaciklama.text = urun.urunAciklama

        u.urunlercv.setOnClickListener {
            val navController = Navigation.findNavController(it)
            val action = when (fromFragment) {
                "Anasayfa" -> AnasayfaFragmentDirections.urunGecis(urun = urun)
                "TumUrunler" -> TumUrunlerFragmentDirections.tumdenUruneGecis(urun = urun)
                else -> null
            }
            action?.let {
                navController.navigate(it)
            }
        }

    }

    fun updateData(newUrunListesi: List<Urun>) {
        urunListesi = newUrunListesi
        notifyDataSetChanged()
    }
}

package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Kategori
import com.example.trendyolapp.databinding.CardViewKategoriBinding


class KategoriAdapter(private val mContext: Context, private var kategoriListesi: List<Kategori>):RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(val tasarim:CardViewKategoriBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding=CardViewKategoriBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kategoriListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kategori=kategoriListesi[position]
        val k=holder.tasarim
        k.textViewKategoriAd.text=kategori.katogoriAd
        k.imageViewKategoriResim.setImageResource(mContext.resources.getIdentifier(kategori.kategoriResim, "drawable", mContext.packageName))
    }
}
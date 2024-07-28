package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.databinding.CardViewButonBinding
import com.example.trendyolapp.data.entity.Butonlar

class ButtonAdapter(private val mContext: Context, private var butonListesi: List<Butonlar>) : RecyclerView.Adapter<ButtonAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(val tasarim: CardViewButonBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardViewButonBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimHolder(binding)
    }

    override fun getItemCount(): Int {
        return butonListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val buton = butonListesi[position]
        val b = holder.tasarim

        b.buttonKategori.text = buton.katogoriAd
    }

}

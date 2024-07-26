package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Hizmet
import com.example.trendyolapp.databinding.CardViewHizmetBinding
import com.example.trendyolapp.databinding.CardViewReklamlarBinding

class HizmetAdapter(private val mContext:Context,private val hizmetListesi:List<Hizmet>):RecyclerView.Adapter<HizmetAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(val tasarim: CardViewHizmetBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding=CardViewHizmetBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return hizmetListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val hizmet=hizmetListesi[position]
        val h=holder.tasarim
        h.imageViewHizmet.setImageResource(mContext.resources.getIdentifier(hizmet.hizmetResim,"drawable",mContext.packageName))
        h.textViewHizmetAdi.text=hizmet.hizmetAd
    }
}
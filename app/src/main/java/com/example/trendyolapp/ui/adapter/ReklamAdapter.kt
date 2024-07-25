package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Reklam
import com.example.trendyolapp.databinding.CardViewReklamlarBinding
import java.security.interfaces.RSAMultiPrimePrivateCrtKey

class ReklamAdapter(private val mContext:Context,private val reklamListesi:List<Reklam>):RecyclerView.Adapter<ReklamAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(val tasarim:CardViewReklamlarBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding=CardViewReklamlarBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return reklamListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val reklam=reklamListesi[position]
        val r=holder.tasarim
        r.imageViewReklam.setImageResource(mContext.resources.getIdentifier(reklam.reklamAd,"drawable",mContext.packageName))
    }

}
package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Kupon
import com.example.trendyolapp.databinding.CardViewKuponlarBinding


class KuponAdapter(private val mContext: Context,private val kuponListesi:List<Kupon>):RecyclerView.Adapter<KuponAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(val tasarim:CardViewKuponlarBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding=CardViewKuponlarBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kuponListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kupon=kuponListesi[position]
        val k=holder.tasarim
        k.imageViewkupon.setImageResource(mContext.resources.getIdentifier(kupon.kuponResim,"drawable",mContext.packageName))
    }

}
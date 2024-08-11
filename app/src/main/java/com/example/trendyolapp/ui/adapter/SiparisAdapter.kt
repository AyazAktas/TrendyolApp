package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Order
import com.example.trendyolapp.databinding.CardViewSiparisBinding

class SiparisAdapter(private val mContext: Context, private val siparisler: List<Order>) : RecyclerView.Adapter<SiparisAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardViewSiparisBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardViewSiparisBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return siparisler.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val siparis = siparisler[position]
        val s = holder.tasarim
        s.textViewFiyat.text = "${siparis.totalPrice.toString()} TL"
        s.textViewSaat.text = siparis.time
        s.textViewTarih.text = siparis.date
        s.textViewUrunAdet.text = "${siparis.products.size} adet ürün sipariş edildi."
        s.textViewOrderCode.text = siparis.orderCode

        val urunAdapter = UrunAdapter(mContext, siparis.products, "Siparis")
        s.urunlerRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        s.urunlerRecyclerView.adapter = urunAdapter
    }
}

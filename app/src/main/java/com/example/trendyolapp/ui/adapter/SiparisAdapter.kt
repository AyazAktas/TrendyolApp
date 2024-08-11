package com.example.trendyolapp.ui.adapter
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Order
import com.example.trendyolapp.databinding.CardViewSiparisBinding

class SiparisAdapter(private val mContext: Context,private val siparisler: List<Order>):RecyclerView.Adapter<SiparisAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(val tasarim:CardViewSiparisBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding= CardViewSiparisBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return siparisler.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val siparis=siparisler[position]
        val s =holder.tasarim
        s.textViewFiyat.text="${siparis.totalPrice.toString()} TL"
        s.textViewSaat.text=siparis.time
        s.textViewTarih.text=siparis.date
        val resourceId = mContext.resources.getIdentifier(siparis.products[0].urunResim, "drawable", mContext.packageName)
        val bitmap = BitmapFactory.decodeResource(mContext.resources, resourceId)
        s.imageViewUrunResmi.setImageBitmap(bitmap)
        s.textViewUrunAdet.text="${siparis.products.size.toString()} adet ürün sipariş edildi."
        s.textViewOrderCode.text=siparis.orderCode
    }
}
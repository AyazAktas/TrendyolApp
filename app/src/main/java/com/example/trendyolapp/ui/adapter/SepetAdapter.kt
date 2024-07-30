package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.CardViewSepetBinding
import com.example.trendyolapp.ui.fragment.FavorilerimFragmentDirections
import com.example.trendyolapp.ui.fragment.SepetimFragmentDirections
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(
    private val mContext: Context,
    private var urunListesi: List<Urun>,
    private val urunViewModel: UrunViewModel
) : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardViewSepetBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardViewSepetBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return urunListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunListesi[position]
        val u = holder.tasarim
        u.imageViewSepettenKaldir.setOnClickListener {
            Snackbar.make(it,"${urun.urunMarka}'i sepetten kaldırmak istediğinize emin misiniz?",
                Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    urunViewModel.urunSepettenKaldir(urun)
                }.show()
        }
        holder.tasarim.textViewMarka.text = urun.urunMarka
        holder.tasarim.textViewMarkaDetay.text=urun.urunMarka
        holder.tasarim.textViewFiyat.text = "${urun.urunFiyat} TL"
        holder.tasarim.textViewAciklama.text=urun.urunAciklama
        u.cardViewSepet.setOnClickListener {
            val gecis = SepetimFragmentDirections.sepetDetayGecis(urun = urun)
            Navigation.findNavController(it).navigate(gecis)
        }
        holder.tasarim.imageView2.setImageResource(mContext.resources.getIdentifier(urun.urunResim, "drawable", mContext.packageName))

    }

    fun updateUrunListesi(yeniUrunListesi: List<Urun>) {
        urunListesi = yeniUrunListesi
        notifyDataSetChanged()
    }
}

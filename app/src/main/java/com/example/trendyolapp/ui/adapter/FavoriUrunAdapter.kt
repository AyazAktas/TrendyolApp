package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.CardViewFavorilerBinding
import com.example.trendyolapp.ui.fragment.AnasayfaFragmentDirections
import com.example.trendyolapp.ui.fragment.FavorilerimFragmentDirections
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.snackbar.Snackbar

class FavoriUrunAdapter(private val mContext: Context, private var urunListesi: List<Urun>, private val urunViewModel: UrunViewModel) : RecyclerView.Adapter<FavoriUrunAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardViewFavorilerBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardViewFavorilerBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return urunListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunListesi[position]
        val u = holder.tasarim
        u.imageViewResim.setImageResource(mContext.resources.getIdentifier(urun.urunResim, "drawable", mContext.packageName))
        u.textViewMarka.text = urun.urunMarka
        u.textViewFiyat.text = "${urun.urunFiyat} TL"
        u.textViewAciklama.text = urun.urunAciklama
        u.cardViewFavoriler.setOnClickListener {
            val gecis = FavorilerimFragmentDirections.favoriUrunGecis(urun = urun)
            Navigation.findNavController(it).navigate(gecis)
        }
        u.buttonSepet.setOnClickListener {
            urunViewModel.urunSepeteEkle(urun)
            Snackbar.make(it, "Ürün sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }
        u.imageViewKaldR.setOnClickListener {
            Snackbar.make(it,"${urun.urunMarka}'i favorilerinizden kaldırmak istediğinize emin misiniz?",Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    urunViewModel.urunKaldir(urun)
                }.show()
        }
    }

    fun updateData(newUrunListesi: List<Urun>) {
        urunListesi = newUrunListesi
        notifyDataSetChanged()
    }
}

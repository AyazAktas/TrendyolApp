package com.example.trendyolapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.CardViewOdemeBinding
import com.example.trendyolapp.ui.fragment.AnasayfaFragmentDirections
import com.example.trendyolapp.ui.fragment.FavorilerimFragmentDirections
import com.example.trendyolapp.ui.fragment.OdemeSayfasiFragmentDirections
import com.example.trendyolapp.ui.fragment.SiparisOnaylandiFragmentDirections
import com.example.trendyolapp.ui.fragment.TumUrunlerFragmentDirections
import com.example.trendyolapp.ui.viewmodel.UrunViewModel

class OdemeAdapter(private val mContext: Context, private var urunListesi: List<Urun>, private val urunViewModel: UrunViewModel,private val fromFragment: String):RecyclerView.Adapter<OdemeAdapter.CardViewTutucu>(){
    inner class CardViewTutucu(val tasarim:CardViewOdemeBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTutucu {
        val binding=CardViewOdemeBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardViewTutucu(binding)
    }

    override fun getItemCount(): Int {
        return urunListesi.size
    }

    override fun onBindViewHolder(holder: CardViewTutucu, position: Int) {
        val urun=urunListesi[position]
        val u =holder.tasarim
        u.imageViewUrunResmi.setImageResource(mContext.resources.getIdentifier(urun.urunResim, "drawable", mContext.packageName))
        u.textViewMarka.text=urun.urunMarka
        u.textViewFiyat.text="${urun.urunFiyat} TL"
        u.textViewAciklama.text=urun.urunAciklama
        u.saticiAdi.text=urun.urunMarka
        u.odemeuruncv.setOnClickListener {
            val navController = Navigation.findNavController(it)
            val action = when (fromFragment) {
                "OdemeSayfasi" -> OdemeSayfasiFragmentDirections.actionOdemeSayfasiFragmentToUrunDetayFragment(urun = urun)
                "SiparisOnaylandi" -> SiparisOnaylandiFragmentDirections.actionSiparisOnaylandiFragmentToUrunDetayFragment(urun = urun)
                else -> null
            }
            action?.let {
                navController.navigate(it)
            }
        }
    }
    fun setUrunler(urunler: List<Urun>) {
        urunListesi = urunler
        notifyDataSetChanged()
    }
}
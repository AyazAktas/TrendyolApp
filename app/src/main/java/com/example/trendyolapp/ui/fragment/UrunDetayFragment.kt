// UrunDetayFragment.kt
package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentUrunDetayBinding
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.snackbar.Snackbar

class UrunDetayFragment : Fragment() {
    private lateinit var binding: FragmentUrunDetayBinding
    private val urunViewModel: UrunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUrunDetayBinding.inflate(inflater, container, false)

        val bundle: UrunDetayFragmentArgs by navArgs()
        val urun = bundle.urun
        binding.textViewMarka.text = urun.urunMarka
        binding.imageViewUrun.setImageResource(resources.getIdentifier(urun.urunResim, "drawable", requireContext().packageName))
        binding.textViewAciklama.text = urun.urunAciklama
        binding.textViewfiyat.text = "${urun.urunFiyat} TL"

        binding.imageViewMesajlar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sepeteGecis)
        }
        binding.imageViewBildirimler.setOnClickListener {
            Snackbar.make(it, "Ürün bağlantısı kopyalandı.", Snackbar.LENGTH_SHORT).show()
        }

        binding.imageButton.setOnClickListener {
            urunViewModel.urunEkle(urun)
            Snackbar.make(it, "Ürün favorilere eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
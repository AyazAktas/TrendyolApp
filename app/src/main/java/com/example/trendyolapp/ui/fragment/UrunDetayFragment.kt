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
    private val args: UrunDetayFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUrunDetayBinding.inflate(inflater, container, false)

        val urun = args.urun
        binding.textViewMarka.text = urun.urunMarka
        binding.imageViewUrun.setImageResource(resources.getIdentifier(urun.urunResim, "drawable", requireContext().packageName))
        binding.textViewAciklama.text = urun.urunAciklama
        binding.textViewfiyat.text = "${urun.urunFiyat} TL"

        binding.imageViewBildirimler.setOnClickListener {
            Snackbar.make(it, "Ürün bağlantısı kopyalandı.", Snackbar.LENGTH_SHORT).show()
        }

        binding.imageButton.setOnClickListener {
            val eklendi = urunViewModel.urunEkle(urun)
            if (eklendi) {
                Snackbar.make(it, "Ürün favorilere eklendi.", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(it, "Ürün zaten favorilerde.", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.imageViewMesajlar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.resim_sepete_gecis)
        }

        binding.buttonSepeteEkle.setOnClickListener {
            urunViewModel.urunSepeteEkle(urun)
            Snackbar.make(it, "Ürün sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }
}

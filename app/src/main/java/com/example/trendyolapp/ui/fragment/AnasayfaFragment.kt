package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentManager
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.data.entity.Butonlar
import com.example.trendyolapp.data.entity.Hizmet
import com.example.trendyolapp.data.entity.Kupon
import com.example.trendyolapp.data.entity.Reklam
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.FragmentAnasayfaBinding
import com.example.trendyolapp.data.provider.UrunDataProvider
import com.example.trendyolapp.data.provider.ButtonDataProvider
import com.example.trendyolapp.data.provider.KuponDataProvider
import com.example.trendyolapp.data.provider.ReklamDataProvider
import com.example.trendyolapp.data.provider.HizmetDataProvider
import com.example.trendyolapp.ui.adapter.ButtonAdapter
import com.example.trendyolapp.ui.adapter.KuponAdapter
import com.example.trendyolapp.ui.adapter.ReklamAdapter
import com.example.trendyolapp.ui.adapter.HizmetAdapter
import com.example.trendyolapp.ui.adapter.UrunAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val urunlistesi = UrunDataProvider.getUrunListesi()
        val butonlarListesi = ButtonDataProvider.getButonlarListesi()
        val kuponlarListesi = KuponDataProvider.getKuponlarListesi()
        val reklamlarListesi = ReklamDataProvider.getReklamlarListesi()
        val hizmetListesi = HizmetDataProvider.getHizmetListesi()

        setupRecyclerViews(urunlistesi, butonlarListesi, kuponlarListesi, reklamlarListesi, hizmetListesi)



        binding.textViewTumUrunler.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("urunListesi", ArrayList(urunlistesi))  // Yeni bir ArrayList oluşturun
            Navigation.findNavController(it).navigate(R.id.tum_urunler_gecis, bundle)
        }
        binding.buttonKategoriler.setOnClickListener {
            val bundle=Bundle()
            bundle.putSerializable("butonlarListesi",ArrayList(butonlarListesi))
            Navigation.findNavController(it).navigate(R.id.kategoriler_gecis,bundle)
        }
        return binding.root

    }

    private fun setupRecyclerViews(
        urunlistesi: ArrayList<Urun>,
        butonlarListesi: ArrayList<Butonlar>,
        kuponlarListesi: ArrayList<Kupon>,
        reklamlarListesi: ArrayList<Reklam>,
        hizmetListesi: ArrayList<Hizmet>
    ) {

        binding.butonkategorirv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.reklamlarrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.hizmetrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.urunlerrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.kuponlarrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Adapter'ları ayarla
        val butonAdapter = ButtonAdapter(requireContext(), butonlarListesi)
        binding.butonkategorirv.adapter = butonAdapter

        val reklamAdapter = ReklamAdapter(requireContext(), reklamlarListesi)
        binding.reklamlarrv.adapter = reklamAdapter

        val hizmetAdapter = HizmetAdapter(requireContext(), hizmetListesi)
        binding.hizmetrv.adapter = hizmetAdapter

        val urunAdapter = UrunAdapter(requireContext(), urunlistesi, "Anasayfa")
        binding.urunlerrv.adapter = urunAdapter

        val kuponAdapter = KuponAdapter(requireContext(), kuponlarListesi)
        binding.kuponlarrv.adapter = kuponAdapter
    }
}

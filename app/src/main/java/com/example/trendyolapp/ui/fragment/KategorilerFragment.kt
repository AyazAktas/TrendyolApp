package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.data.entity.Butonlar
import com.example.trendyolapp.data.entity.Kategori
import com.example.trendyolapp.databinding.FragmentKategorilerBinding
import com.example.trendyolapp.data.provider.ButtonDataProvider
import com.example.trendyolapp.data.provider.KategoriDataProvider
import com.example.trendyolapp.ui.adapter.ButtonAdapter
import com.example.trendyolapp.ui.adapter.KategoriAdapter

class KategorilerFragment : Fragment() {
    private lateinit var binding: FragmentKategorilerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKategorilerBinding.inflate(inflater, container, false)

        val butonlarListesi = ButtonDataProvider.getButonlarListesi()
        val kategoriListesi = KategoriDataProvider.getKategoriListesi()

        setupRecyclerViews(butonlarListesi, kategoriListesi)

        binding.imageView10.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_kategorilerFragment_to_anasayfaFragment)
        }

        return binding.root
    }

    private fun setupRecyclerViews(
        butonlarListesi: ArrayList<Butonlar>,
        kategoriListesi: ArrayList<Kategori>
    ) {
        binding.butonrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.kategorirv.layoutManager = GridLayoutManager(requireContext(),2)
        val butonAdapter = ButtonAdapter(requireContext(), butonlarListesi)
        binding.butonrv.adapter = butonAdapter
        val kategoriAdapter = KategoriAdapter(requireContext(), kategoriListesi)
        binding.kategorirv.adapter = kategoriAdapter
    }
}
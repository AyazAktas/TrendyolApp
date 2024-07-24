package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentAnasayfaBinding
import com.example.trendyolapp.data.entity.Butonlar
import com.example.trendyolapp.ui.adapter.ButtonAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        // RecyclerView için LayoutManager ayarlama
        binding.butonkategorirv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        val butonlarListesi=ArrayList<Butonlar>()
        val b1=Butonlar(1,"Erkek")
        val b2=Butonlar(2,"Kadın")
        val b3=Butonlar(3,"Ev & Yaşam")
        val b4=Butonlar(4,"Spor&Outdoor")
        val b5=Butonlar(5,"Moda")
        val b6=Butonlar(6,"Elektronik")
        butonlarListesi.add(b1)
        butonlarListesi.add(b2)
        butonlarListesi.add(b3)
        butonlarListesi.add(b4)
        butonlarListesi.add(b5)
        butonlarListesi.add(b6)

        val butonAdapter=ButtonAdapter(requireContext(),butonlarListesi)
        binding.butonkategorirv.adapter=butonAdapter


        return binding.root
    }
}
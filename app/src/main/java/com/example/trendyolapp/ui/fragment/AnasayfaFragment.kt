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
        val b5=Butonlar(5,"Elektronik")
        val b6=Butonlar(6,"Moda")
        val b7=Butonlar(6,"Süpermarket")
        val b8=Butonlar(6,"Saat & Aksesuar")
        val b9=Butonlar(6,"Oto & Yapı Market")
        val b10=Butonlar(6,"Anne & Çocuk")
        val b11=Butonlar(6,"Kozmetik")
        val b12=Butonlar(6,"Ayakkabı & Çanta")
        val b13=Butonlar(6,"Luxury")
        val b14=Butonlar(6,"Dolap")
        val b15=Butonlar(6,"Kitap & Kırtasiye")
        val b16=Butonlar(6,"Hobi & Müzik")
        val b17=Butonlar(6,"İş Yerine Özel")

        butonlarListesi.add(b1)
        butonlarListesi.add(b2)
        butonlarListesi.add(b3)
        butonlarListesi.add(b4)
        butonlarListesi.add(b5)
        butonlarListesi.add(b6)
        butonlarListesi.add(b7)
        butonlarListesi.add(b8)
        butonlarListesi.add(b9)
        butonlarListesi.add(b10)
        butonlarListesi.add(b11)
        butonlarListesi.add(b12)
        butonlarListesi.add(b13)
        butonlarListesi.add(b14)
        butonlarListesi.add(b15)
        butonlarListesi.add(b16)
        butonlarListesi.add(b17)

        val butonAdapter=ButtonAdapter(requireContext(),butonlarListesi)
        binding.butonkategorirv.adapter=butonAdapter


        return binding.root
    }
}
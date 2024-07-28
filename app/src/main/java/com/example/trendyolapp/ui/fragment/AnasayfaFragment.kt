package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentAnasayfaBinding
import com.example.trendyolapp.data.entity.Butonlar
import com.example.trendyolapp.data.entity.Hizmet
import com.example.trendyolapp.data.entity.Kupon
import com.example.trendyolapp.data.entity.Reklam
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.ui.adapter.ButtonAdapter
import com.example.trendyolapp.ui.adapter.HizmetAdapter
import com.example.trendyolapp.ui.adapter.KuponAdapter
import com.example.trendyolapp.ui.adapter.ReklamAdapter
import com.example.trendyolapp.ui.adapter.UrunAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
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



        binding.reklamlarrv.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val reklamlarListesi=ArrayList<Reklam>()
        val r1=Reklam(1,"reklam_bir")
        val r2=Reklam(2,"reklam")
        val r3=Reklam(3,"reklam_uc")
        val r4=Reklam(4,"reklam_dort")


        reklamlarListesi.add(r1)
        reklamlarListesi.add(r2)
        reklamlarListesi.add(r3)
        reklamlarListesi.add(r4)

        val reklamAdapter=ReklamAdapter(requireContext(),reklamlarListesi)
        binding.reklamlarrv.adapter=reklamAdapter


        binding.hizmetrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val hizmetListesi=ArrayList<Hizmet>()
        val h1=Hizmet(1,"Hızlı Market","hizlimarket")
        val h2=Hizmet(2,"Yemek","yemek")
        val h3=Hizmet(3,"Futbol Aşkı","futbolaski")
        val h4=Hizmet(4,"Al, Sat, Kazan","alsatkazan")
        val h5=Hizmet(5,"Trendyol Pozitif","trendeyolpozitif")
        val h6=Hizmet(6,"Spora Başla","sporabasla")
        val h7=Hizmet(7,"Finansal Çözüm","finansalcozumler")
        val h8=Hizmet(8,"Kuponlar","kuponlar")
        val h9=Hizmet(9,"Kredi Kartı","kredikarti")
        val h10=Hizmet(10,"Kategoriler","kategoriler")
        hizmetListesi.add(h1)
        hizmetListesi.add(h2)
        hizmetListesi.add(h3)
        hizmetListesi.add(h4)
        hizmetListesi.add(h5)
        hizmetListesi.add(h6)
        hizmetListesi.add(h7)
        hizmetListesi.add(h8)
        hizmetListesi.add(h9)
        hizmetListesi.add(h10)

        val hizmetAdapter=HizmetAdapter(requireContext(),hizmetListesi)
        binding.hizmetrv.adapter=hizmetAdapter



        binding.urunlerrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val urunlistesi=ArrayList<Urun>()
        val u1=Urun(1,"GIVENCHY","Givenchy Gentleman Edp 100 ml Erkek Parfüm","givenchy",4954)
        val u2=Urun(2,"Bershka","Kısa kollu Machine Gun Kelly baskılı boxy fit t-shirt","mgktisort",450)
        val u3=Urun(3,"Mitra Yayınları","Agnostisizm ve İlahi Tragedya - Diamond Tema, Kağıt Kapak ","diokitap",415)
        val u4=Urun(4,"Wilson","Wilson Blade 25 V8 Tenis Raketi WR079310","tenisraketi",6260)
        val u5=Urun(5,"İletişim Yayınları","Oğuz Atay - Tehlikeli Oyunlar","tehlikelioyunlar",230)
        val u6=Urun(6,"YAMAHA","Yamaha Pacifica PA112VBL Elektro Gitar (Siyah)","elektrogitar",16487)

        urunlistesi.add(u1)
        urunlistesi.add(u2)
        urunlistesi.add(u3)
        urunlistesi.add(u4)
        urunlistesi.add(u5)
        urunlistesi.add(u6)

        val urunAdapter=UrunAdapter(requireContext(),urunlistesi)
        binding.urunlerrv.adapter=urunAdapter



        binding.kuponlarrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val kuponlarListesi=ArrayList<Kupon>()
        val k1=Kupon(1,"kuponbir")
        val k2=Kupon(2,"kuponiki")

        kuponlarListesi.add(k1)
        kuponlarListesi.add(k2)

        val kuponAdapter=KuponAdapter(requireContext(),kuponlarListesi)
        binding.kuponlarrv.adapter=kuponAdapter


        return binding.root
    }

}
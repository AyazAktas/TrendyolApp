package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentSepetimBinding
import com.example.trendyolapp.ui.adapter.SepetAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class SepetimFragment : Fragment() {
    private lateinit var binding: FragmentSepetimBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var sepetimadapter: SepetAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetimBinding.inflate(inflater, container, false)
        sepetimadapter = SepetAdapter(requireContext(), arrayListOf(), urunViewModel)
        binding.sepetimrv.layoutManager = LinearLayoutManager(requireContext())
        binding.sepetimrv.adapter = sepetimadapter
        binding.textViewUrunSayisi.text = "(${urunViewModel.getToplamSepetUrunSayisi()} ürün)"
        urunViewModel.sepetUrunler.observe(viewLifecycleOwner) { urunler ->
            sepetimadapter.updateUrunListesi(urunler)
        }
        binding.textViewToplamFiyat.text = "${urunViewModel.getToplamFiyat()} TL"
        binding.butonSepetiOnayla.setOnClickListener {
            urunViewModel.sepetiOnayla()
            findNavController().navigate(R.id.sepetOnaylaGecis)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}

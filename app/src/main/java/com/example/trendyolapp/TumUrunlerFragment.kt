package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trendyolapp.databinding.FragmentTumUrunlerBinding
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.ui.adapter.UrunAdapter

class TumUrunlerFragment : Fragment() {
    private lateinit var binding: FragmentTumUrunlerBinding
    private lateinit var urunAdapter: UrunAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTumUrunlerBinding.inflate(inflater, container, false)
        val urunlistesi = arguments?.getSerializable("urunListesi") as? ArrayList<Urun> ?: arrayListOf()
        urunAdapter = UrunAdapter(requireContext(), urunlistesi, "TumUrunler")
        binding.tumurunlerrv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.tumurunlerrv.adapter = urunAdapter

        return binding.root
    }
}

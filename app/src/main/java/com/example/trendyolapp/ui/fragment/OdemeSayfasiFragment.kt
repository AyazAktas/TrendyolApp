package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.databinding.FragmentOdemeSayfasiBinding
import com.example.trendyolapp.ui.adapter.OdemeAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel

class OdemeSayfasiFragment : Fragment() {
    private lateinit var binding: FragmentOdemeSayfasiBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var odemeAdapter: OdemeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOdemeSayfasiBinding.inflate(inflater, container, false)

        odemeAdapter = OdemeAdapter(requireContext(), arrayListOf(), urunViewModel)
        binding.alinanurunlerrv.layoutManager = LinearLayoutManager(requireContext())
        binding.alinanurunlerrv.adapter = odemeAdapter

        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { urunler ->
            odemeAdapter.setUrunler(urunler)
        })

        return binding.root
    }
}

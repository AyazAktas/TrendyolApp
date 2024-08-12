package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.databinding.FragmentSiparisOnaylandiBinding
import com.example.trendyolapp.ui.adapter.OdemeAdapter
import com.example.trendyolapp.ui.adapter.SimdiAlAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel

class SiparisOnaylandiFragment : Fragment() {
    private lateinit var binding: FragmentSiparisOnaylandiBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var odemeAdapter: OdemeAdapter
    private lateinit var simdiAlAdapter: SimdiAlAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSiparisOnaylandiBinding.inflate(inflater, container, false)
        if (urunViewModel.isFromSimdiAlFragment) {
            simdiAlAdapter = SimdiAlAdapter(requireContext(), listOf(), urunViewModel, "SiparisOnaylandi")
            binding.siparisrv.layoutManager = LinearLayoutManager(requireContext())
            binding.siparisrv.adapter = simdiAlAdapter
        } else {
            odemeAdapter = OdemeAdapter(requireContext(), listOf(), urunViewModel, "SiparisOnaylandi")
            binding.siparisrv.layoutManager = LinearLayoutManager(requireContext())
            binding.siparisrv.adapter = odemeAdapter
        }

        binding.buttonAlisveriseDevamEt.setOnClickListener {
            val gecis = SiparisOnaylandiFragmentDirections.actionSiparisOnaylandiFragmentToAnasayfaFragment()
            findNavController().navigate(gecis)
        }

        binding.ButtonSiparislereGit.setOnClickListener {
            val gecis = SiparisOnaylandiFragmentDirections.actionSiparisOnaylandiFragmentToSiparislerimFragment()
            findNavController().navigate(gecis)
        }

        binding.siparislerimegittv.setOnClickListener {
            val gecis = SiparisOnaylandiFragmentDirections.actionSiparisOnaylandiFragmentToSiparislerimFragment()
            findNavController().navigate(gecis)
        }

        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { urunler ->
            if (urunViewModel.isFromSimdiAlFragment) {
                simdiAlAdapter.setUrunler(urunler)
            } else {
                odemeAdapter.setUrunler(urunler)
            }
        })

        return binding.root
    }
}

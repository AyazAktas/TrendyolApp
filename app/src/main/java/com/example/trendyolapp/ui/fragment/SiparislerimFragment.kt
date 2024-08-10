package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.data.provider.OrderRepository
import com.example.trendyolapp.databinding.FragmentSiparislerimBinding
import com.example.trendyolapp.ui.adapter.SiparisAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel

class SiparislerimFragment : Fragment() {
    private lateinit var binding: FragmentSiparislerimBinding
    private val urunViewModel: UrunViewModel by activityViewModels() // UrunViewModel ile sipariş bilgilerini alacağız

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSiparislerimBinding.inflate(inflater, container, false)

        setupRecyclerView()
        observeOrders()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.siparislerimrv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeOrders() {
        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { siparisler ->
            val adapter = SiparisAdapter(requireContext(), OrderRepository.getOrders())
            binding.siparislerimrv.adapter = adapter
        })
    }
}

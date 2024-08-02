package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentSiparisOnaylandiBinding
import com.example.trendyolapp.ui.adapter.OdemeAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class SiparisOnaylandiFragment : Fragment() {
    private lateinit var binding: FragmentSiparisOnaylandiBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var odemeAdapter: OdemeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSiparisOnaylandiBinding.inflate(inflater, container, false)

        odemeAdapter = OdemeAdapter(requireContext(), listOf(), urunViewModel)
        binding.siparisrv.layoutManager = LinearLayoutManager(requireContext())
        binding.siparisrv.adapter = odemeAdapter

        binding.buttonAlisveriseDevamEt.setOnClickListener {
            val gecis = SiparisOnaylandiFragmentDirections.actionSiparisOnaylandiFragmentToAnasayfaFragment()
            findNavController().navigate(gecis)
        }

        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { urunler ->
            odemeAdapter.setUrunler(urunler)
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView?.visibility = View.GONE
        Log.d("SiparisOnaylandiFragment", "BottomNavigationView hidden onResume")
    }

    override fun onPause() {
        super.onPause()
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView?.visibility = View.VISIBLE
        Log.d("SiparisOnaylandiFragment", "BottomNavigationView shown onPause")
    }
}
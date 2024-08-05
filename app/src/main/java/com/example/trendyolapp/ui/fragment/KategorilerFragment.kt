package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.data.entity.Butonlar
import com.example.trendyolapp.databinding.FragmentKategorilerBinding
import com.example.trendyolapp.ui.adapter.ButtonAdapter

class KategorilerFragment : Fragment() {
    private lateinit var binding: FragmentKategorilerBinding
    private lateinit var butonAdapter: ButtonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKategorilerBinding.inflate(inflater, container, false)

        val butonListesi = arguments?.getSerializable("butonlarListesi") as? ArrayList<Butonlar> ?: arrayListOf()
        butonAdapter = ButtonAdapter(requireContext(), butonListesi)

        binding.butonrv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.butonrv.adapter = butonAdapter

        binding.imageView10.setOnClickListener {
            val gecis=KategorilerFragmentDirections.actionKategorilerFragmentToAnasayfaFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}
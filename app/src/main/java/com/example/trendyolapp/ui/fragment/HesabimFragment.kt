package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentHesabimBinding


class HesabimFragment : Fragment() {
    private lateinit var binding: FragmentHesabimBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentHesabimBinding.inflate(inflater,container,false)
        binding.S.setOnClickListener {
            val gecis=HesabimFragmentDirections.actionHesabimFragmentToSiparislerimFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}
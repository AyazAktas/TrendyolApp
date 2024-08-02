package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trendyolapp.R
import com.example.trendyolapp.databinding.FragmentSiparisOnaylandiBinding

class SiparisOnaylandiFragment : Fragment() {
    private lateinit var binding:FragmentSiparisOnaylandiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentSiparisOnaylandiBinding.inflate(inflater,container,false)
        return binding.root
    }

}
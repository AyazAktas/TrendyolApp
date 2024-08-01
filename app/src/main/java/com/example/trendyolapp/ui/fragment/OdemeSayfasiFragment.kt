package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.databinding.FragmentOdemeSayfasiBinding
import com.example.trendyolapp.ui.adapter.OdemeAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import java.text.SimpleDateFormat
import java.util.Locale

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
            updateTotalPrice(urunler)
            val totalPrice = urunler.sumOf { it.urunFiyat.toDouble()}
                binding.textViewUrunFiyat2.text = "${totalPrice} TL"
        })



        return binding.root
    }

    private fun updateTotalPrice(urunler: List<Urun>) {
        val totalPrice = urunler.sumOf { it.urunFiyat  }
        binding.textViewUrunFiyat.text = "${totalPrice} TL"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView.visibility = View.VISIBLE
    }
}

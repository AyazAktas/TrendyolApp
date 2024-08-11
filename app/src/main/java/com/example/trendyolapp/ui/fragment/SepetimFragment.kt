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
import com.google.android.material.snackbar.Snackbar

class SepetimFragment : Fragment() {
    private lateinit var binding: FragmentSepetimBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var sepetimAdapter: SepetAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetimBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sepetimAdapter = SepetAdapter(requireContext(), arrayListOf(), urunViewModel)
        binding.sepetimrv.layoutManager = LinearLayoutManager(requireContext())
        binding.sepetimrv.adapter = sepetimAdapter

        urunViewModel.sepetUrunler.observe(viewLifecycleOwner) { urunler ->
            sepetimAdapter.updateUrunListesi(urunler)
            updateUI()
        }

        updateUI()

        binding.butonSepetiOnayla.setOnClickListener {
            val sepetUrunler = urunViewModel.sepetUrunler.value
            if (sepetUrunler.isNullOrEmpty()) {
                Snackbar.make(binding.root, "Sepetinizde ürün bulunmamaktadır. Ürün ekleyiniz!", Snackbar.LENGTH_SHORT).show()
            } else {
                urunViewModel.sepetiOnayla()
                findNavController().navigate(R.id.sepetOnaylaGecis)
            }
        }
    }

    private fun updateUI() {
        val toplamFiyat = urunViewModel.getToplamFiyat()
        val toplamAdet = urunViewModel.getToplamSepetUrunSayisi()

        binding.textViewToplamFiyat.text = "${toplamFiyat} TL"
        binding.textViewUrunSayisi.text = "($toplamAdet ürün)"
    }
}

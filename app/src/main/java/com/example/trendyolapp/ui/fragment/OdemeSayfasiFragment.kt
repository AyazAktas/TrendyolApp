package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.R
import com.example.trendyolapp.data.entity.Order
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.data.provider.OrderRepository
import com.example.trendyolapp.databinding.FragmentOdemeSayfasiBinding
import com.example.trendyolapp.ui.adapter.OdemeAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class OdemeSayfasiFragment : Fragment() {
    private lateinit var binding: FragmentOdemeSayfasiBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var odemeAdapter: OdemeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOdemeSayfasiBinding.inflate(inflater, container, false)

        odemeAdapter = OdemeAdapter(requireContext(), arrayListOf(), urunViewModel, "OdemeSayfasi")
        binding.alinanurunlerrv.layoutManager = LinearLayoutManager(requireContext())
        binding.alinanurunlerrv.adapter = odemeAdapter

        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { urunler ->
            odemeAdapter.setUrunler(urunler)
            updateTotalPrice(urunler)
            val totalPrice = urunler.sumOf { it.urunFiyat.toDouble() }
            binding.textViewUrunFiyat2.text = "${totalPrice} TL"
        })

        binding.buttonOnayla.setOnClickListener {
            if (validateInputs()) {
                val (date, time) = getCurrentDateTime()
                val orderCode = generateOrderCode()
                val order = Order(
                    orderCode = orderCode,
                    date = date,
                    time = time,
                    products = urunViewModel.siparisUrunler.value ?: emptyList()
                )
                OrderRepository.addOrder(order)

                Log.d("OdemeSayfasiFragment", "Sipariş Oluşturuldu: $order")

                val gecis = OdemeSayfasiFragmentDirections.siparisOnaylandi()
                findNavController().navigate(gecis)
            }
        }

        return binding.root
    }

    private fun updateTotalPrice(urunler: List<Urun>) {
        val totalPrice = urunler.sumOf { it.urunFiyat }
        binding.textViewUrunFiyat.text = "${totalPrice} TL"
    }

    private fun validateInputs(): Boolean {
        val cardNumber = binding.editTextKartNo.text.toString().trim()
        val adres = binding.editTextAdres.text.toString().trim()
        val expiryDate = binding.editTextSonKullanmaTarihi.text.toString().trim()
        val cvv = binding.editTextNumber2.text.toString().trim()

        return when {
            adres.isEmpty() -> {
                showSnackbar("Adres girmediniz.")
                false
            }
            cardNumber.isEmpty() -> {
                showSnackbar("Kart numarası girmediniz.")
                false
            }
            expiryDate.isEmpty() -> {
                showSnackbar("Son kullanma tarihini girmediniz.")
                false
            }
            cvv.isEmpty() -> {
                showSnackbar("CVV kodunu girmediniz.")
                false
            }
            else -> true
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun generateOrderCode(): String {
        return UUID.randomUUID().toString()
    }

    private fun getCurrentDateTime(): Pair<String, String> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentDate = Date()
        return Pair(dateFormat.format(currentDate), timeFormat.format(currentDate))
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

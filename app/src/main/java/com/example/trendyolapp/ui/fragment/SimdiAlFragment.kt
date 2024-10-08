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
import com.example.trendyolapp.data.entity.Order
import com.example.trendyolapp.data.entity.Urun
import com.example.trendyolapp.data.provider.OrderRepository
import com.example.trendyolapp.databinding.FragmentSimdiAlBinding
import com.example.trendyolapp.ui.adapter.SimdiAlAdapter
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class SimdiAlFragment : Fragment() {
    private lateinit var binding: FragmentSimdiAlBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var simdiAlAdapter: SimdiAlAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSimdiAlBinding.inflate(inflater, container, false)
        simdiAlAdapter = SimdiAlAdapter(requireContext(), arrayListOf(), urunViewModel, "SimdiAl")
        binding.alinanurunlerrv.layoutManager = LinearLayoutManager(requireContext())
        binding.alinanurunlerrv.adapter = simdiAlAdapter
        urunViewModel.isFromSimdiAlFragment = true

        urunViewModel.siparisUrunler.observe(viewLifecycleOwner, { urun ->
            simdiAlAdapter.setUrunler(urun)
            Log.d("Urunler","${urun}")
            val totalPrice = urun.sumOf {it.urunFiyat}
            binding.textViewUrunFiyat2.text = "${totalPrice} TL"
            updateTotalPrice(urun)
        })

        binding.buttonOnayla.setOnClickListener {
            if (validateInputs()) {
                val (date, time) = getCurrentDateTime()
                val orderCode = generateOrderCode()
                val urunler = urunViewModel.siparisUrunler.value ?: emptyList()
                val totalPrice = urunler.sumOf { it.urunFiyat }

                val order = Order(
                    orderCode = orderCode,
                    date = date,
                    time = time,
                    products = urunler,
                    totalPrice = totalPrice.toDouble()
                )

                OrderRepository.addOrder(order)

                Log.d("SimdiAlFragment", "Sipariş Oluşturuldu: $order")

                val gecis = SimdiAlFragmentDirections.actionSimdiAlFragment2ToSiparisOnaylandiFragment()
                findNavController().navigate(gecis)

            }
        }

        return binding.root
    }

    private fun updateTotalPrice(urunler: List<Urun>) {
        val totalPrice = urunler.sumOf {it.urunFiyat}
        Log.d("SimdiAlFragment", "Toplam Fiyat: $totalPrice TL")
        binding.textViewUrunFiyat.text = "${totalPrice} TL"
    }

    private fun validateInputs(): Boolean {
        val cardNumber = binding.editTextKartNo.text.toString().trim()
        val adres = binding.editTextAdres.text.toString().trim()
        val expiryDate = binding.editTextSonKullanmaTarihi.text.toString().trim()
        val cvv = binding.editTextNumber2.text.toString().trim()
        val expiryDateRegex = """^(0[1-9]|1[0-2])\/\d{2}$""".toRegex()
        return when {
            adres.isEmpty() -> {
                showSnackbar("Adres girmediniz.")
                false
            }
            adres.length < 10 -> {
                showSnackbar("Adres en az 10 karakter uzunluğunda olmalıdır.")
                false
            }
            adres.length > 100 -> {
                showSnackbar("Adres en fazla 100 karakter uzunluğunda olmalıdır.")
                false
            }
            cardNumber.isEmpty() -> {
                showSnackbar("Kart numarası girmediniz.")
                false
            }
            cardNumber.length != 16 -> {
                showSnackbar("Lütfen geçerli bir kart numarası giriniz!")
                false
            }
            expiryDate.isEmpty() -> {
                showSnackbar("Son kullanma tarihini girmediniz.")
                false
            }
            !expiryDateRegex.matches(expiryDate) -> {
                showSnackbar("Son kullanma tarihi MM/YY formatında olmalıdır.")
                false
            }
            cvv.isEmpty() -> {
                showSnackbar("CVV kodunu girmediniz.")
                false
            }
            cvv.length!=3->{
                showSnackbar("Lütfen geçerli CVV numarası giriniz !")
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
}

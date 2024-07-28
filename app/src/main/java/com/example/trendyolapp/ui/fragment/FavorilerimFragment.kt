package com.example.trendyolapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendyolapp.databinding.FragmentFavorilerimBinding
import com.example.trendyolapp.ui.viewmodel.UrunViewModel
import com.example.trendyolapp.ui.adapter.FavoriUrunAdapter

class FavorilerimFragment : Fragment() {
    private lateinit var binding: FragmentFavorilerimBinding
    private val urunViewModel: UrunViewModel by activityViewModels()
    private lateinit var favoriUrunAdapter: FavoriUrunAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavorilerimBinding.inflate(inflater, container, false)

        favoriUrunAdapter = FavoriUrunAdapter(requireContext(), arrayListOf())
        binding.favorilerrv.layoutManager = LinearLayoutManager(requireContext())
        binding.favorilerrv.adapter = favoriUrunAdapter

        urunViewModel.favoriUrunler.observe(viewLifecycleOwner) { urunler ->
            favoriUrunAdapter.updateData(urunler)
        }

        return binding.root
    }
}
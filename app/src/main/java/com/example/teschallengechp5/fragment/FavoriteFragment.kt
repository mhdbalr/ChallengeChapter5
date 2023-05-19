package com.example.teschallengechp5.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teschallengechp5.adapter.FavoriteAdapter
import com.example.teschallengechp5.databinding.FragmentFavoriteBinding
import com.example.teschallengechp5.viewModel.FavoritViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var favoritViewModel: FavoritViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    override fun onStart() {
        super.onStart()
        favoritViewModel = ViewModelProvider(this)[FavoritViewModel::class.java]
        favoritViewModel.getFavoriteMovie().observe(this) {
            favoriteAdapter = FavoriteAdapter(it)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvFavMovie.layoutManager = layoutManager
            binding.rvFavMovie.adapter = FavoriteAdapter(it)
        }


    }

}
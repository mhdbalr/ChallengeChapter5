package com.example.teschallengechp5.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.teschallengechp5.databinding.FragmentDetailBinding
import com.example.teschallengechp5.model.Movie
import com.example.teschallengechp5.viewModel.FavoritViewModel
import com.example.teschallengechp5.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(var favoritViewModel: FavoritViewModel) : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var filmViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritViewModel = ViewModelProvider(this).get(FavoritViewModel::class.java)

        val list = arguments?.getParcelable<Movie>("data_movie") as Movie
        val title = list.title
        val date = list.releaseDate
        val overview = list.overview
        val imagepath = list.imagePath
        val id = list.id

        binding.tvTitle.text = title.toString()
        binding.tvDateRelease.text = date
        binding.tvDesc.text = overview
        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${imagepath}")
            .into(binding.imgMovie)
        binding.imgFav.setOnClickListener {
            favoritViewModel.insertMovie(id, title, date, imagepath)
            Toast.makeText(context, "Ditambahkan", Toast.LENGTH_SHORT).show()

        }
    }

}
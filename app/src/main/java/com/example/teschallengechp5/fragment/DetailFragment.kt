package com.example.teschallengechp5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chapterlima.model.Movie
import com.example.chapterlima.viewModel.MovieViewModel
import com.example.teschallengechp5.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
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

        val list = arguments?.getParcelable<Movie>("data_movie") as Movie
        val title = list.title
        val date = list.releaseDate
        val overview = list.overview
        val imagepath = list.imagePath

        binding.tvTitle.text = title
        binding.tvTglRelease.text = date
        binding.tvDesc.text = overview
        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${imagepath}").into(binding.imgMovie)

    }


}
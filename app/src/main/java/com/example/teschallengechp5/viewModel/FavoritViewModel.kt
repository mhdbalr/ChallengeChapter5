package com.example.teschallengechp5.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teschallengechp5.room.FavoritDao
import com.example.teschallengechp5.room.FavoritNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritViewModel @Inject constructor(private val favoriteDAO: FavoritDao): ViewModel( ){

    //insert favorite movie
    suspend fun insertFavoriteMovie( favorite: FavoritNote) = favoriteDAO.insertFilmFavorites(favorite)

    fun insertMovie (id: String, title: Int, date:String, image:String){
        viewModelScope.launch {
            val movie = FavoritNote(id,title,date,image)
            favoriteDAO.insertFilmFavorites(movie)
        }
    }
    fun getFavoriteMovie() = favoriteDAO.getAllFilmFavorites()

}
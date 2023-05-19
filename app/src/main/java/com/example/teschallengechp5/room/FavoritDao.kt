package com.example.teschallengechp5.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritDao {
    @Query("SELECT * FROM FavoritNote")
    fun getAllFilmFavorites() : LiveData<List<FavoritNote>>

    @Insert
    suspend fun insertFilmFavorites(filmFavorites: FavoritNote)
}
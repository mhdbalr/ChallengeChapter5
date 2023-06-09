package com.example.teschallengechp5.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teschallengechp5.model.ResponseMovie
import com.example.teschallengechp5.model.Result
import com.example.teschallengechp5.network.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltViewModel
class MovieViewModel : ViewModel() {
    lateinit var liveDataMovie : MutableLiveData<List<Result>>
    lateinit var liveDetailMovie : MutableLiveData<ResponseMovie>
    val key = "2b66746a9a705b1acae562b4b4d07704"

    init {
        liveDataMovie = MutableLiveData()
        liveDetailMovie = MutableLiveData()
    }

    fun getDataFilm() : MutableLiveData<List<Result>>{
        return liveDataMovie
    }
    fun getDetailMovie() : MutableLiveData<ResponseMovie>{
        return liveDetailMovie
    }

    fun getApiMovie() {
        RetrofitClient.instance.getTrendingMovie(key).enqueue(object :
            Callback<ResponseMovie> {
            @SuppressLint("NullSafeMutableLiveData")
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                if (response.isSuccessful){
                    liveDataMovie.postValue(response.body()!!.results)
                } else {
                    liveDataMovie.postValue(null)
                }
            }

            @SuppressLint("NullSafeMutableLiveData")
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                liveDataMovie.postValue(null)
            }

        })
    }

}


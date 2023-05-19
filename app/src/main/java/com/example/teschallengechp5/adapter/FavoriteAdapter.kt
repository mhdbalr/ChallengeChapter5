package com.example.teschallengechp5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teschallengechp5.databinding.ItemFavoriteBinding
import com.example.teschallengechp5.room.FavoritNote

class FavoriteAdapter(private var listFav : List<FavoritNote>): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    class ViewHolder ( val binding: ItemFavoriteBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteAdapter.ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listFav[position]
        holder.binding.etJudul.text = list.title
        holder.binding.etTanggal.text = list.tanggal

        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w200/${list.poster_path}").fitCenter().into(holder.binding.imgMovie)
    }

    override fun getItemCount(): Int {
        return listFav.size
    }
}

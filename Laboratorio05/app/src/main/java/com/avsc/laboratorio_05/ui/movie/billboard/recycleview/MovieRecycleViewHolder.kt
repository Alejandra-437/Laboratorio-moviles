package com.avsc.laboratorio_05.ui.movie.billboard.recycleview

import androidx.recyclerview.widget.RecyclerView
import com.avsc.laboratorio_05.data.model.MovieModel
import com.avsc.laboratorio_05.databinding.MovieItemBinding


class MovieRecycleViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie : MovieModel, clickListener: (MovieModel) -> Unit){
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }

}
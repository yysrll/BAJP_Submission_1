package com.yusril.bajp_submission_1.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.databinding.ItemsMovieBinding
import com.yusril.bajp_submission_1.ui.detail.DetailActivity
import com.yusril.bajp_submission_1.ui.movie.MovieAdapter

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    class FavoriteMovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvYear.text = movie.year
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/"+movie.poster)
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMovieAdapter.FavoriteMovieViewHolder {
        val binding =
        ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieAdapter.FavoriteMovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FavoriteMovieAdapter.FavoriteMovieViewHolder,
        position: Int
    ) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size
}
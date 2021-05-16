package com.yusril.bajp_submission_1.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.databinding.ItemsMovieBinding
import com.yusril.bajp_submission_1.ui.detail.DetailActivity

class FavoriteMovieAdapter :
    PagedListAdapter<MovieEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    class FavoriteMovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvYear.text = movie.year
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/" + movie.poster)
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
    ): FavoriteMovieViewHolder {
        val binding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FavoriteMovieViewHolder,
        position: Int
    ) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

}
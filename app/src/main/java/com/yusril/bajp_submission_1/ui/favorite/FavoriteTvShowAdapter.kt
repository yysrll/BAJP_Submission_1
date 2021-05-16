package com.yusril.bajp_submission_1.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.databinding.ItemsMovieBinding
import com.yusril.bajp_submission_1.ui.detail.DetailActivity

class FavoriteTvShowAdapter :
    PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    class FavoriteTvShowViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvYear.text = tvShow.year
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/" + tvShow.poster)
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TVSHOW, tvShow)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

}
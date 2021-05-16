package com.yusril.bajp_submission_1.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow
import com.yusril.bajp_submission_1.databinding.ItemsMovieBinding
import com.yusril.bajp_submission_1.ui.detail.DetailActivity
import com.yusril.bajp_submission_1.ui.movie.TvShowAdapter

class FavoriteTvShowAdapter : RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvShowViewHolder>() {

    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShow(tvShow: List<TvShowEntity>?) {
        if (tvShow == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShow)
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
        return FavoriteTvShowAdapter.FavoriteTvShowViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

}
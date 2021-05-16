package com.yusril.bajp_submission_1.ui.detail

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.databinding.ActivityDetailBinding
import com.yusril.bajp_submission_1.ui.favorite.FavoriteViewModel
import com.yusril.bajp_submission_1.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var binding: ActivityDetailBinding
    private var isFavorite: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<MovieEntity>("movie")
        val tvShow = intent.getParcelableExtra<TvShowEntity>("tvShow")

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        binding.collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]
        val favViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        buttonChecked()

        if (movie != null) {
            binding.collapsingToolbarLayout.title = movie.title
            viewModel.id = movie.id

            favViewModel.getFavoriteMovieById(movie.id).observe(this, { favMovie ->
                if (favMovie.isNotEmpty()) {
                    isFavorite = true
                    buttonChecked()
                }
            })


            binding.fabAdd.setOnClickListener {
                isFavorite = !isFavorite
                when (isFavorite) {
                    true -> {
                        favViewModel.insertFavoriteMovie(movie)
                        Toast.makeText(this, getString(R.string.insert_success), Toast.LENGTH_SHORT).show()
                        buttonChecked()
                    }
                    false -> {
                        favViewModel.deleteFavoriteMovie(movie.id)
                        Toast.makeText(this, getString(R.string.delete_success), Toast.LENGTH_SHORT).show()
                        buttonChecked()
                    }
                }
            }

            viewModel.getDetailMovie().observe(this, { detailMovie ->
                populateDetailMovie(detailMovie)
            })
        } else {
            binding.collapsingToolbarLayout.title = tvShow.title
            viewModel.id = tvShow.id

            favViewModel.getFavoriteTvShowById(tvShow.id).observe(this, { favTvShow ->
                if (favTvShow.isNotEmpty()) {
                    isFavorite = true
                    buttonChecked()
                }
            })


            binding.fabAdd.setOnClickListener {
                isFavorite = !isFavorite
                when (isFavorite) {
                    true -> {
                        favViewModel.insertFavoriteTvShow(tvShow)
                        Toast.makeText(this, getString(R.string.insert_success), Toast.LENGTH_SHORT).show()
                        buttonChecked()
                    }
                    false -> {
                        favViewModel.deleteFavoriteTvShow(tvShow.id)
                        Toast.makeText(this, getString(R.string.delete_success), Toast.LENGTH_SHORT).show()
                        buttonChecked()
                    }
                }
            }

            viewModel.getDetailTvShow().observe(this, { DetailTvShow ->
                populateDetailTvShow(DetailTvShow)
            })
        }


        binding.collapsingToolbarLayout.post {
            binding.collapsingToolbarLayout.requestLayout()
        }
    }

    private fun buttonChecked() {
        if (isFavorite) {
            binding.fabAdd.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.fabAdd.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun populateDetailMovie(movie: MovieEntity) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.poster)
            .into(binding.imgPoster)
        binding.imgPoster.contentDescription = movie.poster.toString()
        binding.detailMovie.tvYear.text = movie.year
        binding.detailMovie.tvScore.text = movie.score.toString()
        binding.detailMovie.tvLanguage.text = movie.language
        binding.detailMovie.tvSummary.text = movie.summary
    }

    private fun populateDetailTvShow(tvShow: TvShowEntity) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + tvShow.poster)
            .into(binding.imgPoster)
        binding.imgPoster.contentDescription = tvShow.poster
        binding.detailMovie.tvYear.text = tvShow.year
        binding.detailMovie.tvScore.text = tvShow.score.toString()
        binding.detailMovie.tvLanguage.text = tvShow.language
        binding.detailMovie.tvSummary.text = tvShow.summary
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_MOVIE = "movie"
        const val EXTRA_TVSHOW = "tvShow"
    }
}
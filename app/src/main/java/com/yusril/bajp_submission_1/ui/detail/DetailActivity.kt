package com.yusril.bajp_submission_1.ui.detail

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.databinding.ActivityDetailBinding
import com.yusril.bajp_submission_1.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var binding: ActivityDetailBinding


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

        if (movie != null) {
            binding.collapsingToolbarLayout.title = movie.title
            viewModel.id = movie.id

            viewModel.getDetailMovie().observe(this, { detailMovie ->
                populateDetailMovie(detailMovie)
            })
        } else {
            binding.collapsingToolbarLayout.title = tvShow.title
            viewModel.id = tvShow.id

            viewModel.getDetailTvShow().observe(this, { DetailTvShow ->
                populateDetailTvShow(DetailTvShow)
            })
        }


        binding.collapsingToolbarLayout.post {
            binding.collapsingToolbarLayout.requestLayout()
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
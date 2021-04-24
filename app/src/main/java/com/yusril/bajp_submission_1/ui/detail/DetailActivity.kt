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
import com.yusril.bajp_submission_1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<MovieEntity>("movie")

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbarLayout.title = movie.title
        binding.collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        binding.collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        viewModel.setSelectedMovie(movie.id)
        val movies = viewModel.getDetailMovie()
        populateDetailMovie(movies)




        binding.collapsingToolbarLayout.post {
            binding.collapsingToolbarLayout.requestLayout()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateDetailMovie(movie: MovieEntity) {
        Glide.with(this)
            .load(movie.poster)
            .into(binding.imgPoster)
        binding.imgPoster.contentDescription = movie.poster.toString()
        binding.detailMovie.tvYear.text = movie.year.toString()
        binding.detailMovie.tvScore.text = movie.score.toString() + "/100"
        binding.detailMovie.tvLanguage.text = movie.language
        binding.detailMovie.tvDuration.text = movie.duration
        binding.detailMovie.tvSummary.text = movie.summary
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
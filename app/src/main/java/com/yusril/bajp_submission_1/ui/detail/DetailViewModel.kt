package com.yusril.bajp_submission_1.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getDetailMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntities = DataDummy.generateDummyMovies()
        val tvShowEntities = DataDummy.generateDummyTvShow()

        for (movieEntity in moviesEntities) {
            if (movieEntity.id == movieId) {
                movie = movieEntity
            } else {
                for (tvEntity in tvShowEntities) {
                    if (tvEntity.id == movieId) {
                        movie = tvEntity
                    }
                }
            }
        }
        return movie
    }

}
package com.yusril.bajp_submission_1.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yusril.bajp_submission_1.data.source.MovieRepository
import com.yusril.bajp_submission_1.di.Injection
import com.yusril.bajp_submission_1.ui.detail.DetailViewModel
import com.yusril.bajp_submission_1.ui.favorite.FavoriteViewModel
import com.yusril.bajp_submission_1.ui.movie.MovieViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}
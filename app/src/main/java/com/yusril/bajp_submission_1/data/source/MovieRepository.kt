package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.LocalRepository
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository

class MovieRepository private constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) :
    MovieDataSource {


    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(
            remoteRepository: RemoteRepository,
            localRepository: LocalRepository
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteRepository, localRepository).apply {
                    instance = this
                }
            }
    }

    override fun getMoviesCatalogue(): LiveData<List<MovieEntity>> {
        return remoteRepository.loadMoviesCatalogue()
    }

    override fun getTvShowsCatalogue(): LiveData<List<TvShowEntity>> {
        return remoteRepository.loadTvShowsCatalogue()
    }

    override fun getDetailMovie(id: Int): LiveData<MovieEntity> {
        return remoteRepository.loadDetailMovie(id)
    }

    override fun getDetailTvShow(id: Int): LiveData<TvShowEntity> {
        return remoteRepository.loadDetailTvShow(id)
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteMovieById(id: Int): LiveData<List<MovieEntity>> {
        return localRepository.getFavoriteMovieById(id)
    }

    override fun insertFavoriteMovie(movie: MovieEntity) {
        return localRepository.insertFavoriteMovie(movie)
    }

    override fun deleteFavoriteMovie(id: Int) {
        return localRepository.deleteFavoriteMovie(id)
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getFavoriteTvShow(), config).build()
    }

    override fun getFavoriteTvShowById(id: Int): LiveData<List<TvShowEntity>> {
        return localRepository.getFavoriteTvShowById(id)
    }

    override fun insertFavoriteTvShow(tvShow: TvShowEntity) {
        return localRepository.insertFavoriteTvShow(tvShow)
    }

    override fun deleteFavoriteTvShow(id: Int) {
        return localRepository.deleteFavoriteTvShow(id)
    }
}
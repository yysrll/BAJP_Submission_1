package com.yusril.bajp_submission_1.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.LocalRepository
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository
import com.yusril.bajp_submission_1.utils.DataDummy
import com.yusril.bajp_submission_1.utils.LiveDataTestUtil
import com.yusril.bajp_submission_1.utils.PagedListUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private val remote = mock(RemoteRepository::class.java)
    private val local = mock(LocalRepository::class.java)
    private val movieRepository = FakeMovieRepository(remote, local)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movie = movieResponses[0]
    private val tvShowResponses = DataDummy.generateDummyTvShow()
    private val tvShow = tvShowResponses[0]

    @Test
    fun getMoviesCatalogue() {
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = movieResponses

        `when`(movieRepository.getMoviesCatalogue()).thenReturn(movies)
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMoviesCatalogue())
        verify(remote).loadMoviesCatalogue()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getTvShowsCatalogue() {
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = tvShowResponses

        `when`(movieRepository.getTvShowsCatalogue()).thenReturn(tvShows)
        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getTvShowsCatalogue())
        verify(remote).loadTvShowsCatalogue()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        val detailMovie = MutableLiveData<MovieEntity>()
        detailMovie.value = movie

        `when`(movieRepository.getDetailMovie(movie.id)).thenReturn(detailMovie)
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movie.id))
        verify(remote).loadDetailMovie(movie.id)
        assertNotNull(movieEntities)
        assertEquals(movie.id, movieEntities.id)
    }

    @Test
    fun getDetailTvShow() {
        val detailTvShow = MutableLiveData<TvShowEntity>()
        detailTvShow.value = tvShow

        `when`(movieRepository.getDetailTvShow(tvShow.id)).thenReturn(detailTvShow)
        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getDetailTvShow(tvShow.id))
        verify(remote).loadDetailTvShow(tvShow.id)
        assertNotNull(tvShowEntities)
        assertEquals(tvShow.id, tvShowEntities.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovie()

        val movieEntities = PagedListUtil.mockPagedList(movieResponses)
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getFavoriteMovieById() {
        val movieById = MutableLiveData<List<MovieEntity>>()
        movieById.value = listOf(movie)

        `when`(movieRepository.getFavoriteMovieById(movie.id)).thenReturn(movieById)
        val movieEntities =
            LiveDataTestUtil.getValue(movieRepository.getFavoriteMovieById(movie.id))
        verify(local).getFavoriteMovieById(movie.id)
        assertNotNull(movieEntities)
        assertEquals(movie.id, movieEntities[0].id)
    }

    @Test
    fun insertFavoriteMovie() {
        doNothing().`when`(local).insertFavoriteMovie(movie)
        movieRepository.insertFavoriteMovie(movie)
        verify(local, times(1)).insertFavoriteMovie(movie)
    }

    @Test
    fun deleteFavoriteMovie() {
        doNothing().`when`(local).deleteFavoriteMovie(movie.id)
        movieRepository.deleteFavoriteMovie(movie.id)
        verify(local, times(1)).deleteFavoriteMovie(movie.id)
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShow()

        val tvShowEntities = PagedListUtil.mockPagedList(tvShowResponses)
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getFavoriteTvShowById() {
        val tvShowById = MutableLiveData<List<TvShowEntity>>()
        tvShowById.value = listOf(tvShow)

        `when`(movieRepository.getFavoriteTvShowById(tvShow.id)).thenReturn(tvShowById)
        val tvShowEntities =
            LiveDataTestUtil.getValue(movieRepository.getFavoriteTvShowById(tvShow.id))
        verify(local).getFavoriteTvShowById(tvShow.id)
        assertNotNull(tvShowEntities)
        assertEquals(tvShow.id, tvShowEntities[0].id)
    }

    @Test
    fun insertFavoriteTvShow() {
        doNothing().`when`(local).insertFavoriteTvShow(tvShow)
        movieRepository.insertFavoriteTvShow(tvShow)
        verify(local, times(1)).insertFavoriteTvShow(tvShow)
    }

    @Test
    fun deleteFavoriteTvShow() {
        doNothing().`when`(local).deleteFavoriteTvShow(tvShow.id)
        movieRepository.deleteFavoriteTvShow(tvShow.id)
        verify(local, times(1)).deleteFavoriteTvShow(tvShow.id)
    }


}
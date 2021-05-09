package com.yusril.bajp_submission_1.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository
import com.yusril.bajp_submission_1.utils.DataDummy
import com.yusril.bajp_submission_1.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteRepository::class.java)
    private val movieRepository = FakeMovieRepository(remote)

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
}
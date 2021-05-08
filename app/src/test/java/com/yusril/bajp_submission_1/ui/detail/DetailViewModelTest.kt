package com.yusril.bajp_submission_1.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.mockito.Mockito.verify
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.MovieRepository
import com.yusril.bajp_submission_1.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovie
        viewModel.id = dummyMovie.id

        `when`(movieRepository.getDetailMovie(dummyMovie.id)).thenReturn(movies)
        val movieEntity = viewModel.getDetailMovie().value as MovieEntity
        verify(movieRepository).getDetailMovie(dummyMovie.id)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.summary, movieEntity.summary)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.score, movieEntity.score, 0.9)
        assertEquals(dummyMovie.language, movieEntity.language)
        assertEquals(dummyMovie.poster, movieEntity.poster)

        viewModel.getDetailMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTvShow() {
        val tvShows = MutableLiveData<TvShowEntity>()
        tvShows.value = dummyTvShow
        viewModel.id = dummyTvShow.id

        `when`(movieRepository.getDetailTvShow(dummyTvShow.id)).thenReturn(tvShows)
        val tvShowEntity = viewModel.getDetailTvShow().value as TvShowEntity
        verify(movieRepository).getDetailTvShow(dummyTvShow.id)
        assertNotNull(tvShowEntity)

        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.summary, tvShowEntity.summary)
        assertEquals(dummyTvShow.year, tvShowEntity.year)
        assertEquals(dummyTvShow.score, tvShowEntity.score, 0.9)
        assertEquals(dummyTvShow.language, tvShowEntity.language)
        assertEquals(dummyTvShow.poster, tvShowEntity.poster)

        viewModel.getDetailTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}
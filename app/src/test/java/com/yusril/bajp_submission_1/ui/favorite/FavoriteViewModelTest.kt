package com.yusril.bajp_submission_1.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
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
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel
    private val movieDummies = DataDummy.generateDummyMovies()
    private val movieDummiesByOne = DataDummy.generateDummyMovies()[0]
    private val tvShowDummies = DataDummy.generateDummyTvShow()
    private val tvShowDummiesByOne = DataDummy.generateDummyTvShow()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<List<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<List<TvShowEntity>>

    @Mock
    private lateinit var observerPagedListMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerPagedListTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummies = pagedListMovie
        `when`(dummies.size).thenReturn(2)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummies

        `when`(movieRepository.getFavoriteMovie()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies().value
        Mockito.verify(movieRepository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(2, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observerPagedListMovie)
        Mockito.verify(observerPagedListMovie).onChanged(dummies)
    }

    @Test
    fun getFavoriteMovieById() {
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = listOf(movieDummiesByOne)

        `when`(movieRepository.getFavoriteMovieById(movieDummiesByOne.id)).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovieById(movieDummiesByOne.id).value
        verify(movieRepository).getFavoriteMovieById(movieDummiesByOne.id)
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        viewModel.getFavoriteMovieById(movieDummiesByOne.id).observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(listOf(movieDummiesByOne))
    }

    @Test
    fun insertFavoriteMovie() {
        doNothing().`when`(movieRepository).insertFavoriteMovie(movieDummiesByOne)
        viewModel.insertFavoriteMovie(movieDummiesByOne)
        verify(movieRepository, times(1)).insertFavoriteMovie(movieDummiesByOne)
    }

    @Test
    fun deleteFavoriteMovie() {
        doNothing().`when`(movieRepository).deleteFavoriteMovie(movieDummiesByOne.id)
        viewModel.deleteFavoriteMovie(movieDummiesByOne.id)
        verify(movieRepository, times(1)).deleteFavoriteMovie(movieDummiesByOne.id)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummies = pagedListTvShow
        `when`(dummies.size).thenReturn(2)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummies

        `when`(movieRepository.getFavoriteTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavoriteTvShows().value
        Mockito.verify(movieRepository).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(2, tvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observerPagedListTvShow)
        Mockito.verify(observerPagedListTvShow).onChanged(dummies)
    }

    @Test
    fun getFavoriteTvShowById() {
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = listOf(tvShowDummiesByOne)

        `when`(movieRepository.getFavoriteTvShowById(tvShowDummiesByOne.id)).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavoriteTvShowById(tvShowDummiesByOne.id).value
        verify(movieRepository).getFavoriteTvShowById(tvShowDummiesByOne.id)
        assertNotNull(tvShowEntities)
        assertEquals(1, tvShowEntities?.size)

        viewModel.getFavoriteTvShowById(tvShowDummiesByOne.id).observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(listOf(tvShowDummiesByOne))
    }

    @Test
    fun insertFavoriteTvShow() {
        doNothing().`when`(movieRepository).insertFavoriteTvShow(tvShowDummiesByOne)
        viewModel.insertFavoriteTvShow(tvShowDummiesByOne)
        verify(movieRepository, times(1)).insertFavoriteTvShow(tvShowDummiesByOne)
    }

    @Test
    fun deleteFavoriteTvShow() {
        doNothing().`when`(movieRepository).deleteFavoriteTvShow(tvShowDummiesByOne.id)
        viewModel.deleteFavoriteTvShow(tvShowDummiesByOne.id)
        verify(movieRepository, times(1)).deleteFavoriteTvShow(tvShowDummiesByOne.id)
    }
}
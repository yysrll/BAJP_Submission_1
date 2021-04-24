package com.yusril.bajp_submission_1.ui.detail

import com.yusril.bajp_submission_1.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val movie = DataDummy.generateDummyMovies()[0]
    private val movieId = movie.id

    private val tvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = tvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getDetailMovie() {
        viewModel.setSelectedMovie(movie.id)
        val movieEntity = viewModel.getDetailMovie()
        assertNotNull(movieEntity)
        assertEquals(movie.id, movieEntity.id)
        assertEquals(movie.title, movieEntity.title)
        assertEquals(movie.summary, movieEntity.summary)
        assertEquals(movie.year, movieEntity.year)
        assertEquals(movie.score, movieEntity.score)
        assertEquals(movie.duration, movieEntity.duration)
        assertEquals(movie.language, movieEntity.language)
        assertEquals(movie.poster, movieEntity.poster)


        viewModel.setSelectedMovie(tvShow.id)
        val tvShowEntity = viewModel.getDetailMovie()
        assertNotNull(tvShowEntity)
        assertEquals(tvShow.id, tvShowEntity.id)
        assertEquals(tvShow.title, tvShowEntity.title)
        assertEquals(tvShow.summary, tvShowEntity.summary)
        assertEquals(tvShow.year, tvShowEntity.year)
        assertEquals(tvShow.score, tvShowEntity.score)
        assertEquals(tvShow.duration, tvShowEntity.duration)
        assertEquals(tvShow.language, tvShowEntity.language)
        assertEquals(tvShow.poster, tvShowEntity.poster)
    }
}
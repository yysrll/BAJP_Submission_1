package com.yusril.bajp_submission_1.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusril.bajp_submission_1.databinding.FragmentMoviesBinding
import com.yusril.bajp_submission_1.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    companion object {
        private const val ARG_SECTION_NUMBER = "number"

        @JvmStatic
        fun newInstance(index: Int) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        Log.d("index", index.toString())


        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(
            this,
            factory
        )[MovieViewModel::class.java]

        fragmentMoviesBinding.progressBar.visibility = View.VISIBLE

        if (index == 1) {
            viewModel.getMovies().observe(this, { movies ->
                val adapter = MovieAdapter()
                adapter.setMovies(movies)
                adapter.notifyDataSetChanged()
                fragmentMoviesBinding.rvMovies.adapter = adapter
                fragmentMoviesBinding.progressBar.visibility = View.GONE
            })
        } else {
            viewModel.getTvShows().observe(this, { tvShows ->
                val adapter = TvShowAdapter()
                adapter.setTvShow(tvShows)
                adapter.notifyDataSetChanged()
                fragmentMoviesBinding.rvMovies.adapter = adapter
                fragmentMoviesBinding.progressBar.visibility = View.GONE
            })
        }

        with(fragmentMoviesBinding.rvMovies) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

    }

}
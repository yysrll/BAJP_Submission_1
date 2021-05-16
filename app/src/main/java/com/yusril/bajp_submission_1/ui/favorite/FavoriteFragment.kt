package com.yusril.bajp_submission_1.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.databinding.FragmentFavoriteBinding
import com.yusril.bajp_submission_1.ui.movie.MovieAdapter
import com.yusril.bajp_submission_1.ui.movie.MoviesFragment
import com.yusril.bajp_submission_1.ui.movie.TvShowAdapter
import com.yusril.bajp_submission_1.viewmodel.ViewModelFactory

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    companion object {
        private const val ARG_SECTION_NUMBER = "number"

        @JvmStatic
        fun newInstance(index: Int) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        if (index == 1) {
            viewModel.getFavoriteMovies().observe(this, { movies ->
                val adapter = FavoriteMovieAdapter()
                adapter.setMovies(movies)
                adapter.notifyDataSetChanged()
                if (movies.isEmpty()){
                    binding.empty.visibility = View.VISIBLE
                }
                binding.rvFavorite.adapter = adapter
                binding.progressBar.visibility = View.GONE
            })
        } else {
            viewModel.getFavoriteTvShows().observe(this, { tvShows ->
                val adapter = FavoriteTvShowAdapter()
                adapter.setTvShow(tvShows)
                adapter.notifyDataSetChanged()
                if (tvShows.isEmpty()){
                    binding.empty.visibility = View.VISIBLE
                }
                binding.rvFavorite.adapter = adapter
                binding.progressBar.visibility = View.GONE
            })
        }

        with(binding.rvFavorite) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}
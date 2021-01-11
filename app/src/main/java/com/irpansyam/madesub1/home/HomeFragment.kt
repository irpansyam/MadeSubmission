package com.irpansyam.madesub1.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.irpansyam.madesub1.R
import com.irpansyam.madesub1.core.data.Resource
import com.irpansyam.madesub1.core.ui.MovieAdapter
import com.irpansyam.madesub1.databinding.FragmentHomeBinding
import com.irpansyam.madesub1.detail.DetailMovieActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.movie.observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> binding.progressbar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressbar.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                        }
                        is Resource.Error -> {
                            binding.progressbar.visibility = View.GONE
                            binding.viewError.root.visibility =View.VISIBLE
                            binding.viewError.tvError.text = movie.message ?: getString(R.string.text_error)
                        }
                    }
                }
            })

            with(binding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
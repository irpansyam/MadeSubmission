package com.irpansyam.madesub1.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.irpansyam.madesub1.core.data.Resource
import com.irpansyam.madesub1.core.domain.model.Movie
import com.irpansyam.madesub1.core.ui.MovieAdapter
import com.irpansyam.madesub1.detail.DetailMovieActivity
import com.irpansyam.madesub1.favorite.databinding.ActivityFavoriteBinding
import com.irpansyam.madesub1.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)
        supportActionBar?.title ="Your favorite movie !"

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = {selectedData ->
            val intent = Intent(this, DetailMovieActivity::class.java)
            intent .putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        binding.progressBar.visibility = View.VISIBLE
        favoriteViewModel.favoriteMovie.observe(this, { movie ->
            if (movie != null) {
                Log.d("Favorite Activity", "Data result size = ${movie.size}" )

                val listMovie:MutableList<Movie> = movie as MutableList<Movie>
                if (listMovie.isNotEmpty()){
                    binding.progressBar.visibility = View.GONE
                    movieAdapter.setData(listMovie)
                }else if (listMovie.isEmpty()){
                    binding.progressBar.visibility = View.GONE
                    listMovie.clear()
                    movieAdapter.setData(listMovie)
                    movieAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "Data favorite still empty", Toast.LENGTH_SHORT).show()
                }


                /**
                when(movie) {
                    is Resource.Loadin-> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Log.d("FavoriteActivity", "Data result ${movie.data.toString()}")
                        movieAdapter.setData(movie.data )
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text = movie.message ?: getString(R.string.text_error)
                    }
                }
                **/

            }
        })

        with(binding.rvFavorite) {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}
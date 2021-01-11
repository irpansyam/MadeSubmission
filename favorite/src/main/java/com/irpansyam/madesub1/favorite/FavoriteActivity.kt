package com.irpansyam.madesub1.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
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

        favoriteViewModel.favoriteMovie.observe(this, { movie ->
            movieAdapter.setData(movie)
            if (movie.isNotEmpty()){
                binding.viewNoData.visibility = View.GONE
                binding.tvNodata.visibility = View.GONE
            }else{
                binding.viewNoData.visibility = View.VISIBLE
                binding.tvNodata.visibility = View.VISIBLE
                Toast.makeText(this, "Data favorite still empty", Toast.LENGTH_SHORT).show()
            }

        })

        with(binding.rvFavorite) {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}
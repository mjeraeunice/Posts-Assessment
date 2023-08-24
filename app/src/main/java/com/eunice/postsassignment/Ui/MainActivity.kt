package com.eunice.postsassignment.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunice.postsassignment.PostsAdapter
import com.eunice.postsassignment.ViewModel.PostsViewModel
import com.eunice.postsassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val postsViewModel: PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        postsViewModel.fetchPosts()
        postsViewModel.postsLiveData.observe(this, Observer { postslist ->
            var productAdapter = PostsAdapter(postslist ?: emptyList())
            binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvRecycler.adapter = productAdapter

            Toast.makeText(
                baseContext,
                "fetched ${postslist?.size}products",
                Toast.LENGTH_LONG
            ).show()
        })
        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()
        })


    }
}


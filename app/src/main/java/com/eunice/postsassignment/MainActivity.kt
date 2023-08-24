package com.eunice.postsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunice.postsassignment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getPosts()
    }

    fun getPosts() {
        val apiclient = ApiClient.buildClient(ApiInterface::class.java)
        val request = apiclient.getPosts()
        request.enqueue(object : Callback<PostsResponse> {
            override fun onResponse(
                call: Call<PostsResponse>,
                response: Response<PostsResponse>
            ) {
                if (response.isSuccessful) {

                    var posts = response.body()?.post
                    var adapterHolder =ProductAdapter(posts?: emptyList())
                    binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvRecycler.adapter = adapterHolder
                    Toast.makeText(
                        baseContext,
                        "fetched ${posts?.size} products",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

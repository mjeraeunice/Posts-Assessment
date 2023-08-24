package Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunice.postsassignment.ApiClient
import com.eunice.postsassignment.ApiInterface
import com.eunice.postsassignment.Posts
import com.eunice.postsassignment.PostsAdapter
import com.eunice.postsassignment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getItems()
    }
     override fun onResume() {
        super.onResume()

    }

    private fun getItems() {
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getPosts()

        request.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response:
            Response<List<Posts>>) {
                if (response.isSuccessful) {
                    val items = response.body()

                    val itemAdapter =PostsAdapter(items ?: emptyList())
                    binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvRecycler.adapter = itemAdapter

                    Toast.makeText(
                        baseContext,
                        "Fetched ${items?.size} items",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext,
                        response.errorBody()?.string(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}




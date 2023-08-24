package Repository

import com.eunice.postsassignment.ApiClient
import com.eunice.postsassignment.ApiInterface
import com.eunice.postsassignment.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val apiClient= ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getPosts(): Response<PostsResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}
package ViewModels

import Repository.PostsRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eunice.postsassignment.Posts
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel() {
     var postsrepo = PostsRepository()
    var postsLiveData = MutableLiveData<List<Posts>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = postsrepo.getPosts()

            if (response.isSuccessful) {
                postsLiveData.postValue(response.body()?.post)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }


        }
    }
}
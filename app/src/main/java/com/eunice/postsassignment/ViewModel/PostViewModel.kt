package com.eunice.postsassignment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eunice.postsassignment.Posts
import com.eunice.postsassignment.Repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel (){
    var postsRepo= PostsRepository()
    var postsLiveData= MutableLiveData<List<Posts>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch{
            val response=postsRepo.getPosts()
            if(response.isSuccessful){
                val postsList = response.body() ?: emptyList()
                postsLiveData.postValue(postsList as
                        List<Posts>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
package com.eunice.postsassignment

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Posts>>


}
package com.eunice.postsassignment

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {    @GET("/product")
    fun getPosts(): Response<PostsResponse>
    @GET("/product/{id}")
    suspend fun getPostById(@Path("id")productId:Int):Response<Posts>


}
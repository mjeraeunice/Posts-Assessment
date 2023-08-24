package com.eunice.postsassignment

data class PostsResponse(
    var post:List<Posts>,
    var total:Int,
    var skip:Int,
    var limit:String
)

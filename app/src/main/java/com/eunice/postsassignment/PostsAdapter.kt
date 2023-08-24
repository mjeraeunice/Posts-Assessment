package com.eunice.postsassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunice.postsassignment.databinding.PostslistBinding

class PostsAdapter(var postslist: List<Posts>) : RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostslistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }
override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
    val currentPost = postslist[position]
    val binding = holder.binding
    binding.tvid.text = currentPost.id.toString()
    binding.tvdescription.text = currentPost.body
    binding.tvUserId.text = currentPost.title
}

    override fun getItemCount(): Int {
        return postslist.size
    }
}
class PostsViewHolder(val binding: PostslistBinding):RecyclerView.ViewHolder(binding.root)


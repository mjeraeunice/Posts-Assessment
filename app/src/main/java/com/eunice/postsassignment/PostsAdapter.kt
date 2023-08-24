package com.eunice.postsassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunice.postsassignment.databinding.PostslistBinding
import com.squareup.picasso.Picasso

class ProductAdapter (var postslist:List<Posts>): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding=PostslistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  PostsViewHolder(binding)
    }



    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost=postslist[position]
        val binding=holder.binding
        binding.tvid.text=currentPost.toString()
        binding.tvdescription.text=currentPost.body
        binding.tvUserId.text=currentPost.title
        Picasso
            .get()
            .load(currentPost.thumbnail)
            .resize(80,80)
            .centerCrop()
            .into(binding.tvthumbnail)

    }
    override fun getItemCount(): Int {
        return postslist.size
    }
}
class PostsViewHolder(val binding: PostslistBinding):RecyclerView.ViewHolder(binding.root)


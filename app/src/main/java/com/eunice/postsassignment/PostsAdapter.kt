package com.eunice.postsassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunice.postsassignment.databinding.PostslistBinding
import com.squareup.picasso.Picasso

class PostsAdapter(var postslist:List<Posts>):RecyclerView.Adapter<PostsViewHolder>() {
    lateinit var binding:PostslistBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding=PostslistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost=postslist[position]
        val binding=holder.binding
        binding.tvid.text=currentPost.id.toString()
        binding.tvUserId.text=currentPost.title
        binding.tvdescription.text=currentPost.body
    }

    override fun getItemCount(): Int {
        return postslist.size
    }
}
class PostsViewHolder(var binding: PostslistBinding):RecyclerView.ViewHolder(binding.root){

}

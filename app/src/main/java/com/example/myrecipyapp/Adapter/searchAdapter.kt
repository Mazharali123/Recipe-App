package com.example.myrecipyapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipyapp.RecipyActivity
import com.example.myrecipyapp.SearchActivity
import com.example.myrecipyapp.databinding.SearchRvItemBinding
import com.example.myrecipyapp.room.recipy
import com.example.myrecipyapp.textActivity

class searchAdapter(val context : SearchActivity, var searchList : ArrayList<recipy>) :RecyclerView.Adapter<searchAdapter.viewHolder>(){

    inner class viewHolder(var binding : SearchRvItemBinding) : RecyclerView.ViewHolder(binding.root){
        val sImg = binding.searchImg
        val stxt = binding.searchTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       return viewHolder(SearchRvItemBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount() = searchList.size


    fun filterList(filterList : ArrayList<recipy>){
        searchList = filterList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        Glide.with(context).load(searchList[position].img).into(holder.sImg)
        holder.stxt.text = searchList[position].tittle

        holder.binding.searchItem.setOnClickListener {
            val intent = Intent(context, textActivity::class.java)
            intent.putExtra("img", searchList.get(position).img)
            intent.putExtra("tittle", searchList.get(position).tittle)
            intent.putExtra("ing", searchList.get(position).ing)
            intent.putExtra("des", searchList.get(position).des)
            context.startActivity(intent)
        }
    }
}
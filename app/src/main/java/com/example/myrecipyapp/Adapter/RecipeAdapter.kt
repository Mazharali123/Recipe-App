package com.example.myrecipyapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecipyapp.ActivityHome
import com.example.myrecipyapp.RecipyActivity
import com.example.myrecipyapp.databinding.PopularItemRvBinding
import com.example.myrecipyapp.room.recipy
import com.example.myrecipyapp.textActivity

class RecipeAdapter(val context: ActivityHome, val recipeList: ArrayList<recipy>) : RecyclerView.Adapter<RecipeAdapter.viewHolder>() {

    inner class viewHolder(var binding: PopularItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        val popImg = binding.popularImage
        val popTxt = binding.popularTxt
        val popTime = binding.timeTxt

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(PopularItemRvBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount() = recipeList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.popTxt.text = recipeList.get(position).tittle
        val time = recipeList.get(position).ing.split("\n".toRegex()).dropLastWhile {it.isEmpty()}.toTypedArray()
        holder.popTime.text = time[0]
        Glide.with(context).load(recipeList.get(position).img).into(holder.popImg)

        holder.binding.popularImage.setOnClickListener {
            val intent = Intent(context, textActivity::class.java)
            intent.putExtra("img", recipeList.get(position).img)
            intent.putExtra("tittle", recipeList.get(position).tittle)
            intent.putExtra("ing", recipeList.get(position).ing)
            intent.putExtra("des", recipeList.get(position).des)
            context.startActivity(intent)


    }
  }
}
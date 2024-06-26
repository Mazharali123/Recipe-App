package com.example.myrecipyapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myrecipyapp.CategoryActivity
import com.example.myrecipyapp.RecipyActivity
import com.example.myrecipyapp.databinding.CategoryItemBinding
import com.example.myrecipyapp.room.recipy
import com.example.myrecipyapp.textActivity

class categoryAdapter(
    private var categoryList: ArrayList<recipy>,
    private val context: CategoryActivity
) : RecyclerView.Adapter<categoryAdapter.viewHolder>() {

    inner class viewHolder(var binding: CategoryItemBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(
        CategoryItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
    )

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        Glide.with(context).load(categoryList.get(position).img).into(holder.binding.categoryImage)
        holder.binding.categoryName.text = categoryList.get(position).tittle
        var time =
            categoryList.get(position).ing.split("\n").dropLastWhile { it.isEmpty() }.toTypedArray()
        holder.binding.categoryTime.text = time[0]

        holder.binding.detailOfCatry.setOnClickListener {
            val intent = Intent(context, textActivity::class.java)
            intent.putExtra("img", categoryList.get(position).img)
            intent.putExtra("tittle", categoryList.get(position).tittle)
            intent.putExtra("ing", categoryList.get(position).ing)
            intent.putExtra("des", categoryList.get(position).des)
            context.startActivity(intent)
        }

    }
}
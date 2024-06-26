package com.example.myrecipyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myrecipyapp.Adapter.categoryAdapter
import com.example.myrecipyapp.databinding.ActivityCategoryBinding
import com.example.myrecipyapp.room.RecipeDb
import com.example.myrecipyapp.room.recipy

class CategoryActivity : AppCompatActivity() {

    private val binding: ActivityCategoryBinding by lazy {
        ActivityCategoryBinding.inflate(layoutInflater)
    }

    private lateinit var rvAdapter: categoryAdapter
    private lateinit var catgoryData :ArrayList<recipy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       //title = intent.getStringExtra("TITTLE")
        binding.dishCategory.text = intent.getStringExtra("TITTLE")
       setUpRecyclerView()

        binding.sBack.setOnClickListener {
            finish()
        }

    }
    private fun setUpRecyclerView() {
        catgoryData = ArrayList()
        rvAdapter = categoryAdapter( catgoryData,this)
        binding.rvCategory.layoutManager = LinearLayoutManager(this )
        binding.rvCategory.adapter = rvAdapter

        val db = Room.databaseBuilder(this, RecipeDb::class.java, "recipe.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()

        val recipeDao = db.getDao()
        val recipe = recipeDao.getAll()
        for (i in recipe.indices) {

            if (recipe[i].category.contains(intent.getStringExtra("category")!!)) {
                catgoryData.add(recipe[i])
            }
            rvAdapter.notifyDataSetChanged()
        }
    }
}
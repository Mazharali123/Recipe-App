package com.example.myrecipyapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myrecipyapp.Adapter.searchAdapter
import com.example.myrecipyapp.databinding.ActivitySearchBinding
import com.example.myrecipyapp.room.RecipeDb
import com.example.myrecipyapp.room.recipy

class SearchActivity : AppCompatActivity() {

    private val binding: ActivitySearchBinding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }

    private lateinit var searchAdapter: searchAdapter
    private lateinit var recipyData: ArrayList<recipy>
    private lateinit var recipe: List<recipy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.searchSearch.requestFocus()
        val db = Room.databaseBuilder(this, RecipeDb::class.java, "recipy.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()

        val recipeDao = db.getDao()
        recipe = recipeDao.getAll()
        setUpRecyclerView()

        binding.searchSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != null) {
                    filter(p0.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun filter(filteredText: String) {

        val filteredList = ArrayList<recipy>()
        for (i in recipe.indices) {
            if (recipe[i].tittle.lowercase().contains(filteredText.lowercase())) {
                filteredList.add(recipe[i])
            }

            searchAdapter.filterList(filteredList)
        }
    }

    fun setUpRecyclerView() {
        recipyData = ArrayList()
        searchAdapter = searchAdapter(this, recipyData)
        binding.rvSearch.layoutManager = LinearLayoutManager(this)
        binding.rvSearch.adapter = searchAdapter

        for (i in recipe.indices) {

            if (recipe[i].category.contains("Popular")) {
                recipyData.add(recipe[i])
            }
            searchAdapter.notifyDataSetChanged()
        }
    }
}
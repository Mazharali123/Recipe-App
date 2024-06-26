package com.example.myrecipyapp

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.HorizontalScrollView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room.databaseBuilder
import com.example.myrecipyapp.Adapter.RecipeAdapter
import com.example.myrecipyapp.databinding.ActivityHomeBinding
import com.example.myrecipyapp.room.RecipeDb
import com.example.myrecipyapp.room.recipy

class ActivityHome : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipyData: ArrayList<recipy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpRecyclerView()
        binding.searchBar.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }



       binding.salad.setOnClickListener {
          val intent = Intent(this, CategoryActivity::class.java)
          intent.putExtra("category", "Salad")
          intent.putExtra("TITTLE", "Salad")
          startActivity(intent)
       }

        binding.drinks.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Drinks")
            intent.putExtra("TITTLE", "Drinks")
            startActivity(intent)
        }

        binding.dessert.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Desserts")
            intent.putExtra("TITTLE", "Desserts")
            startActivity(intent)
        }

        binding.dishMain.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "Dish")
            intent.putExtra("TITTLE", "Main Dish")
            startActivity(intent)
        }

        binding.menu.setOnClickListener {

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.bottom_nav)
            dialog.show()
            dialog.window?.setLayout(

                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT

            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setGravity(Gravity.BOTTOM)

        }

    }

    private fun setUpRecyclerView() {
        recipyData = ArrayList()
        recipeAdapter = RecipeAdapter(this, recipyData)
        binding.popularRv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.popularRv.adapter = recipeAdapter

        val db = databaseBuilder(this, RecipeDb::class.java, "recipe.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()

        val recipeDao = db.getDao()
        val recipe = recipeDao.getAll()
        for (i in recipe.indices) {

            if (recipe[i].category.contains("Popular")) {
                recipyData.add(recipe[i])
            }
            recipeAdapter.notifyDataSetChanged()
        }
    }
}

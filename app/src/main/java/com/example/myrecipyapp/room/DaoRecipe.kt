package com.example.myrecipyapp.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface  DaoRecipe {

    @Query("SELECT * FROM recipe")
    fun getAll(): List<recipy>

}
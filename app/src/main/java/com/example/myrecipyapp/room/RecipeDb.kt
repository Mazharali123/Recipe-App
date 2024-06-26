package com.example.myrecipyapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [recipy::class], version = 1)
abstract class RecipeDb() :RoomDatabase() {
    abstract fun getDao() : DaoRecipe
}
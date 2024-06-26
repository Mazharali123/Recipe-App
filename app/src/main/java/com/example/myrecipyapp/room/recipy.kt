package com.example.myrecipyapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
class recipy(

       val img :String,
       val tittle :String,
       val des :String,
       val ing :String,
       val category :String,

       ) {

    @JvmField()
    @PrimaryKey(autoGenerate = true)
    var uid = 0
}
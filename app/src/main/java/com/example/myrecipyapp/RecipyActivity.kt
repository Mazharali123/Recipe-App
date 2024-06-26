package com.example.myrecipyapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myrecipyapp.databinding.ActivityRecipyBinding

class RecipyActivity : AppCompatActivity() {

    private val binding :ActivityRecipyBinding by lazy {
        ActivityRecipyBinding.inflate(layoutInflater)
    }

    var imgCorp =true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipy)




//        for (i in 1 until time?.size!!) {
//            binding.ingData.text =
//                """
//                ${binding.ingData.text} 🟢 ${time[i]}
//            """.trimIndent()
//
//        }
//
//        binding.stepsBtn.background = null
//        binding.ingredientsBtn.setTextColor(getColor(R.color.black))
//        binding.stepsBtn.setOnClickListener {
//            binding.stepsBtn.setBackgroundResource(R.drawable.btn_ing)
//            binding.stepsBtn.setTextColor(getColor(R.color.white))
//            binding.ingredientsBtn.setTextColor(getColor(R.color.black))
//            binding.ingredientsBtn.background = null
//            binding.stepScroll.visibility = View.VISIBLE
//            binding.ingredientsBtn.visibility = View.GONE
//
//        }
//
//        binding.ingredientsBtn.setOnClickListener {
//            binding.ingredientsBtn.setBackgroundResource(R.drawable.btn_ing)
//            binding.ingredientsBtn.setTextColor(getColor(R.color.white))
//            binding.stepsBtn.setTextColor(getColor(R.color.white))
//            binding.stepsBtn.background = null
//            binding.gradientScroll.visibility = View.VISIBLE
//            binding.ingredientsBtn.visibility = View.GONE
//
//        }
//
//        binding.fullScreen.setOnClickListener {
//            if (imgCorp) {
//                binding.itemImage.scaleType = ImageView.ScaleType.FIT_CENTER
//                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
//                binding.fullScreen.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
//                binding.ingredientsBtn.visibility = View.GONE
//                imgCorp = !imgCorp
//            } else {
//                binding.itemImage.scaleType = ImageView.ScaleType.CENTER_CROP
//                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
//                binding.fullScreen.setColorFilter(null)
//                binding.ingredientsBtn.visibility = View.GONE
//                imgCorp = !imgCorp
//            }
//        }
//
//        binding.backBtn.setOnClickListener {
//            finish()
//        }

    }
}

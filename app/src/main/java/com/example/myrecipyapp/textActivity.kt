//package com.example.myrecipyapp
//
//import android.annotation.SuppressLint
//import android.graphics.Color
//import android.graphics.PorterDuff
//import android.os.Bundle
//import android.text.SpannableStringBuilder
//import android.util.Log
//import android.util.TypedValue
//import android.view.View
//import android.view.View.GONE
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.core.view.isVisible
//import com.bumptech.glide.Glide
//import com.example.myrecipyapp.databinding.ActivityTextBinding
//
//class textActivity : AppCompatActivity() {
//
//    private val binding by lazy {
//        ActivityTextBinding.inflate(layoutInflater) }
//
//    var  imgCorp = true
//    var isExpanded = false
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//
//        binding.ingData.text = ""
//
//        Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
//        binding.title.text = intent.getStringExtra("tittle")
//        var timeArray = intent.getStringExtra("ing")!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//        binding.recipeTime.text = timeArray[0]
//       // binding.ingData.text = intent.getStringExtra("des")
//
////        for (i in 1 until timeArray?.size!!) {
////            binding.ingData.text=
////                """${binding.ingData.text} 🟢 ${timeArray[i]}
////
////            """.trimIndent()
////
////        }
//
//        val ingredientsBuilder = SpannableStringBuilder()
//        for (i in 1 until timeArray.size) {
//            if (i > 1) {
//                ingredientsBuilder.append("\n")
//            }
//            ingredientsBuilder.append("🟢 ${timeArray[i]}")
//        }
//        binding.ingData.text = ingredientsBuilder
//
//        binding.stepsBtn.setOnClickListener {
//            binding.ingredientsBtn.setBackgroundResource(R.drawable.btn_ing)
//            binding.ingredientsBtn.setTextColor(getColor(R.color.white))
//            binding.stepsBtn.setTextColor(getColor(R.color.white))
//            binding.stepsBtn.background = null
//            binding.stepScroll.visibility = View.GONE
//            binding.gradientScroll.isVisible = true
//            binding.gradientScroll.visibility = View.VISIBLE
//            binding.ingredientsBtn.visibility = View.VISIBLE
//
//        }
//
//
//        binding.stepsBtn.background = null
//        binding.ingredientsBtn.setTextColor(getColor(R.color.black))
//        binding.ingredientsBtn.setOnClickListener {
//            binding.stepsBtn.setBackgroundResource(R.drawable.btn_ing)
//            binding.gradientScroll.isVisible = false
//            binding.stepsBtn.setTextColor(getColor(R.color.white))
//            binding.ingredientsBtn.setTextColor(getColor(R.color.black))
//            binding.ingredientsBtn.background = null
//            binding.stepScroll.visibility = View.VISIBLE
//            binding.ingredientsBtn.visibility = GONE
//            binding.ingStepsData.text = intent.getStringExtra("des")
//
//        }
//
//
//
//        binding.fullScreen.setOnClickListener {
//
//            if (imgCorp){
//                binding.itemImage.scaleType = ImageView.ScaleType.FIT_CENTER
//                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
//                binding.fullScreen.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
//                imgCorp = !imgCorp
//            }else{
//                binding.itemImage.scaleType = ImageView.ScaleType.CENTER_CROP
//                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
//                binding.fullScreen.setColorFilter(null)
//                imgCorp = !imgCorp
//            }
//        }
//
//        binding.backBtn.setOnClickListener {
//            finish()
//        }
//
//        Log.d("Before" , "${binding.itemImage.height}")
//
//      binding.extendedView.setOnClickListener {
//          toggleLayoutExpansion()
//          Log.d("OnClicked" , "${binding.itemImage.height}")
//      }
//
//
//
//    }
//
//
//
//    private fun toggleLayoutExpansion() {
//        isExpanded = !isExpanded
//
//       // val itemImageHeight = binding.itemImage.height // Get the height of item_image
//
//        val params = binding.expln.layoutParams as ConstraintLayout.LayoutParams
//        params.height = if (isExpanded) {
//            binding.expln.height + 600  // Expand to half the height of item_image
//        } else {
//            ConstraintLayout.LayoutParams.WRAP_CONTENT // Contract to original height
//        }
//        binding.expln.layoutParams = params
//
//        val rotationAngle = if (isExpanded) 180f else 0f
//        binding.extendedView.animate().rotation(rotationAngle).setDuration(200).start()
//    }
//}
//

package com.example.myrecipyapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.util.TypedValue
import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.myrecipyapp.databinding.ActivityTextBinding

class textActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTextBinding.inflate(layoutInflater)
    }

    var imgCorp = true
    var isExpanded = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ingData.text = ""

        Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
        binding.title.text = intent.getStringExtra("tittle")
        binding.imageView4.isVisible = false

        var timeArray =
            intent.getStringExtra("ing")!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()

        binding.recipeTime.text = timeArray[0]

        val ingredientsBuilder = SpannableStringBuilder()
        val indentation = "         " // Adjust as needed
        val textPaint = TextPaint() // Use the same paint as your TextView
        val availableWidth = binding.ingData.width // Get TextView width

        for (i in 1 until timeArray.size) {
            if (i > 1) {
                ingredientsBuilder.append("\n")
            }

            val ingredientText = "🟢 ${timeArray[i]}"

            // Check if adding the ingredient will exceed the available width
            ingredientsBuilder.append(ingredientText)
        }

        binding.ingData.text = ingredientsBuilder

        binding.stepsBtn.setOnClickListener {
            binding.ingredientsBtn.setBackgroundResource(R.drawable.btn_ing)
            binding.ingredientsBtn.setTextColor(getColor(R.color.white))
            binding.stepsBtn.setTextColor(getColor(R.color.white))
            binding.stepsBtn.background = null
            binding.stepScroll.visibility = View.GONE
            binding.gradientScroll.isVisible = true
            binding.gradientScroll.visibility = View.VISIBLE
            binding.ingredientsBtn.visibility = View.VISIBLE
        }

        binding.stepsBtn.background = null
        binding.ingredientsBtn.setTextColor(getColor(R.color.black))
        binding.ingredientsBtn.setOnClickListener {
            binding.stepsBtn.setBackgroundResource(R.drawable.btn_ing)
            binding.gradientScroll.isVisible = false
            binding.stepsBtn.setTextColor(getColor(R.color.white))
            binding.ingredientsBtn.setTextColor(getColor(R.color.black))
            binding.ingredientsBtn.background = null
            binding.stepScroll.visibility = View.VISIBLE
            binding.ingredientsBtn.visibility = GONE
            binding.ingStepsData.text = intent.getStringExtra("des")
        }

        binding.fullScreen.setOnClickListener {
            if (imgCorp) {
                binding.itemImage.scaleType = ImageView.ScaleType.FIT_CENTER
                binding.imageView4.isVisible =false
                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
                binding.fullScreen.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
                imgCorp = !imgCorp
            } else {
                binding.imageView4.isVisible =false
                binding.itemImage.scaleType = ImageView.ScaleType.CENTER_CROP
                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
                binding.fullScreen.setColorFilter(null)
                imgCorp = !imgCorp
            }
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

//        binding.extendedView.setOnClickListener {
//            RotateExtentedView()
//        }
  }

    private fun RotateExtentedView() {
        isExpanded = !isExpanded

        val params = binding.expln.layoutParams as ConstraintLayout.LayoutParams

// Calculate the expanded height in pixels

        val expandedHeightPx = binding.expln.height + TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            400f,
            resources.displayMetrics
        ).toInt()

        params.height = if (isExpanded) {
            expandedHeightPx
        } else {
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        }

        binding.expln.layoutParams = params

        val rotate = if (isExpanded) 180 else 0
        binding.extendedView.animate().rotation(rotate.toFloat()).setDuration(200).start()

    }
}

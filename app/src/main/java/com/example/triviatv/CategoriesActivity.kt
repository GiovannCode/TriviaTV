package com.example.triviatv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triviatv.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategories()
    }

    private fun setupCategories() {
        binding.cardCulture.setOnClickListener {
            startGame(TriviaRepository.CAT_CULTURE)
        }

        binding.cardScience.setOnClickListener {
            startGame(TriviaRepository.CAT_SCIENCE)
        }

        binding.cardTech.setOnClickListener {
            startGame(TriviaRepository.CAT_TECH)
        }

        binding.cardSports.setOnClickListener {
            startGame(TriviaRepository.CAT_SPORTS)
        }

        binding.cardEntertainment.setOnClickListener {
            startGame(TriviaRepository.CAT_ENTERTAINMENT)
        }

        // Default initial focus for D-pad
        binding.cardCulture.requestFocus()
    }

    private fun startGame(category: String) {
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra("EXTRA_CATEGORY", category)
        }
        startActivity(intent)
        finish()
    }
}

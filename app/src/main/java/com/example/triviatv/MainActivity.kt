package com.example.triviatv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triviatv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    override fun onResume() {
        super.onResume()
        loadBestScore()
    }

    private fun setupUI() {
        loadBestScore()

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }

        binding.btnInstructions.setOnClickListener {
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }

        // Request initial focus for D-pad navigation
        binding.btnPlay.requestFocus()
    }

    private fun loadBestScore() {
        val sharedPreferences = getSharedPreferences("TriviaPrefs", Context.MODE_PRIVATE)
        val bestScore = sharedPreferences.getInt("best_score", 0)
        binding.tvBestScoreValue.text = "$bestScore pts"
    }
}

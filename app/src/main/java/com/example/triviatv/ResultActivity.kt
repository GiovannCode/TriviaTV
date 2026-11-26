package com.example.triviatv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triviatv.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("EXTRA_SCORE", 0)
        val correct = intent.getIntExtra("EXTRA_CORRECT", 0)
        val incorrect = intent.getIntExtra("EXTRA_INCORRECT", 0)

        binding.tvFinalScore.text = "$score pts"
        binding.tvCorrectCount.text = "✅ Correctas: $correct"
        binding.tvIncorrectCount.text = "❌ Incorrectas: $incorrect"

        // Message based on score
        binding.tvResultMessage.text = when {
            score >= 500 -> "🏆 ¡Perfecto! ¡Eres una leyenda de la TV!"
            score >= 300 -> "🌟 ¡Muy bien! ¡Gran conocimiento!"
            else -> "💡 ¡Buen intento! ¡Sigue practicando!"
        }

        saveAndCheckBestScore(score)

        binding.btnPlayAgain.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Request initial focus for D-pad
        binding.btnPlayAgain.requestFocus()
    }

    private fun saveAndCheckBestScore(currentScore: Int) {
        val prefs = getSharedPreferences("TriviaPrefs", Context.MODE_PRIVATE)
        val bestScore = prefs.getInt("best_score", 0)
        if (currentScore > bestScore) {
            prefs.edit().putInt("best_score", currentScore).apply()
        }
    }
}

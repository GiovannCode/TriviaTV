package com.example.triviatv

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.triviatv.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var questions: List<Question> = emptyList()
    private var currentQuestionIndex = 0
    private var score = 0
    private var correctCount = 0
    private var incorrectCount = 0

    private var timer: CountDownTimer? = null
    private val handler = Handler(Looper.getMainLooper())
    private var isAnswerLocked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("EXTRA_CATEGORY") ?: TriviaRepository.CAT_CULTURE
        binding.tvGameCategory.text = "🧠 $category"

        questions = TriviaRepository.getQuestionsForCategory(category)
        if (questions.isNotEmpty()) {
            loadQuestion()
        } else {
            finish()
        }
    }

    private fun loadQuestion() {
        if (currentQuestionIndex >= questions.size) {
            goToResults()
            return
        }

        isAnswerLocked = false
        val question = questions[currentQuestionIndex]

        binding.tvQuestionCounter.text = "Pregunta ${currentQuestionIndex + 1} de ${questions.size}"
        binding.tvQuestionText.text = question.questionText

        val answerButtons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        for (i in answerButtons.indices) {
            answerButtons[i].text = question.options[i]
            answerButtons[i].setBackgroundResource(R.drawable.answer_button_background)
            answerButtons[i].isEnabled = true
            val optionIndex = i
            answerButtons[i].setOnClickListener {
                if (!isAnswerLocked) {
                    onAnswerSelected(optionIndex)
                }
            }
        }

        // Request initial focus on first answer for D-pad navigation
        binding.btnAnswer1.requestFocus()

        startTimer()
    }

    private fun startTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                binding.tvTimer.text = "⏱️ ${secondsLeft}s"
            }

            override fun onFinish() {
                binding.tvTimer.text = "⏱️ 0s"
                onTimeOut()
            }
        }.start()
    }

    private fun onAnswerSelected(selectedIndex: Int) {
        isAnswerLocked = true
        timer?.cancel()

        val question = questions[currentQuestionIndex]
        val answerButtons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)

        // Disable all buttons
        answerButtons.forEach { it.isEnabled = false }

        if (selectedIndex == question.correctIndex) {
            score += 100
            correctCount++
            answerButtons[selectedIndex].setBackgroundColor(Color.parseColor("#43A047")) // Green
        } else {
            incorrectCount++
            answerButtons[selectedIndex].setBackgroundColor(Color.parseColor("#E53935")) // Red
            answerButtons[question.correctIndex].setBackgroundColor(Color.parseColor("#43A047")) // Correct Green
        }

        handler.postDelayed({
            currentQuestionIndex++
            loadQuestion()
        }, 1500)
    }

    private fun onTimeOut() {
        isAnswerLocked = true
        incorrectCount++

        val question = questions[currentQuestionIndex]
        val answerButtons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        answerButtons.forEach { it.isEnabled = false }

        // Highlight correct answer
        answerButtons[question.correctIndex].setBackgroundColor(Color.parseColor("#43A047"))

        handler.postDelayed({
            currentQuestionIndex++
            loadQuestion()
        }, 1500)
    }

    private fun goToResults() {
        timer?.cancel()
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("EXTRA_SCORE", score)
            putExtra("EXTRA_CORRECT", correctCount)
            putExtra("EXTRA_INCORRECT", incorrectCount)
        }
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
        handler.removeCallbacksAndMessages(null)
    }
}

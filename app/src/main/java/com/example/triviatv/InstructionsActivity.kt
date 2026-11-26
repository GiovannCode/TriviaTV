package com.example.triviatv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triviatv.databinding.ActivityInstructionsBinding

class InstructionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnBack.requestFocus()
    }
}

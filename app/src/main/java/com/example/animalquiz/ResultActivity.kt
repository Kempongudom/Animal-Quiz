package com.example.animalquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.et_name)
        val tvScore : TextView = findViewById(R.id.et_score)
        val btnFinish : TextView = findViewById(R.id.btn_finish)

        tvName.text =intent.getStringExtra(Constrains.USER_NAME)

        val totalQuestion = intent.getIntExtra(Constrains.TOTAL_QUESTION,0)
        val correctAnswer = intent.getIntExtra(Constrains.CORRECT_ANSWER,0)

        tvScore.text = "Your score is $correctAnswer/$totalQuestion"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}
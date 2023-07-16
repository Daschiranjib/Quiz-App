package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quizapp.databinding.ActivityScoreBinding
import com.google.firebase.auth.FirebaseAuth

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding : ActivityScoreBinding
    private lateinit var user: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = FirebaseAuth.getInstance()
        binding.score.setText("Congrats!! Your Score is ${intent.getIntExtra("SCORE",0)}")
        binding.logout.setOnClickListener {
            user.signOut()
            startActivity(
                Intent(this,MainActivity::class.java)
            )
        }
    }
}
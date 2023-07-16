package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener {
            this.firebaseAuth.createUserWithEmailAndPassword(
                binding.email.editableText.toString(),
                binding.password.editableText.toString()
            ).addOnCompleteListener{
                if(it.isSuccessful)
                {
                    Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show()
                    startActivity(
                        Intent(this,QuizActivity::class.java)
                    )
                    finish()
                }
                else{
                    Toast.makeText(this, "User Not Created", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}



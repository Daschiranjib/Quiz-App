package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.firebase.FirebaseAppLifecycleListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        Handler(Looper.getMainLooper()).postDelayed(3000)
        {
            if(firebaseAuth.currentUser!=null) {
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("MODE","SIGNUP")
                startActivity(intent)
            }

        }
    }
}
package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class MovieList : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        Logout()
    }
    fun Logout(){
        val Logoutbut = findViewById<TextView>(R.id.logoutid)
        Logoutbut.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        }
    }
}
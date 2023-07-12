package com.example.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.os.CountDownTimer
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.view.isGone
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.annotations.NotNull


@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hide()
        signupp()
        signbackbutton()
        verifytimer()
        login ()
        showhidepasswrodicon()

    }

    fun login (){
        val loginbutton = findViewById<Button>(R.id.Login)
        loginbutton.setOnClickListener(){
            val intent = Intent(this, MovieList::class.java)
            startActivity(intent)
        }
    }
    fun showhidepasswrodicon(){
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val pwd = findViewById<EditText>(R.id.pwd)
        if(pwd.text != null){
            imageView2.visibility == View.VISIBLE

            imageView2.setOnClickListener {
                if (imageView.visibility == View.VISIBLE) {
                    pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    imageView.visibility = View.GONE
                } else if (imageView2.visibility == View.VISIBLE && imageView.visibility == View.VISIBLE) {
                    pwd.transformationMethod = PasswordTransformationMethod.getInstance()
                    imageView.visibility = View.VISIBLE
                }
            }
        }
    }
    fun hide() {

        val myLinearLayout = findViewById<LinearLayout>(R.id.signuplinear)
        val mainlinearbase = findViewById<LinearLayout>(R.id.linearbase)
        val signbackbut = findViewById<Button>(R.id.signbbutton)
        signbackbut.setOnClickListener() {
            mainlinearbase.visibility = View.VISIBLE
            myLinearLayout.visibility = View.GONE
        }
    }
    fun signupp(){
        val signuplinear = findViewById<LinearLayout>(R.id.signuplinear)
        val Signupbut = findViewById<Button>(R.id.signupbutinmain)
        val mainlinearbase = findViewById<LinearLayout>(R.id.linearbase)
        Signupbut.setOnClickListener {
            mainlinearbase.visibility = View.GONE
            signuplinear.visibility = View.VISIBLE
            validateSignupCpassword()
        }
    }
    fun signbackbutton(){
        val signbbutton = findViewById<Button>(R.id.signbbutton)
        signbbutton.setOnClickListener(){
            hide()
        }
    }
    fun validateSignupCpassword(){
        val signupcpass = findViewById<EditText>(R.id.signUpCpassword)
        val signuppass = findViewById<EditText>(R.id.signUppassword)
        val signupbut = findViewById<Button>(R.id.butinsignup)
        if (signupcpass.text != signuppass.text){
            signupbut.isEnabled = false
        }else{
            signupbut.isActivated = true
        }
    }
    fun verifytimer(){
        val vtimerbutton =  findViewById<Button>(R.id.verify)
        vtimerbutton.setOnClickListener(){
            object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    vtimerbutton.text = (millisUntilFinished / 1000).toString()
                }
                override fun onFinish() {
                    vtimerbutton.text = "Resend"
                    vtimerbutton.isClickable = true
                }
            }.start()
            vtimerbutton.isClickable = false
        }
    }
}

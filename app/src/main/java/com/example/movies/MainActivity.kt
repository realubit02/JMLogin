package com.example.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
//import com.example.Domain.model.LoginModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hide()
        signupp()
        signbackbutton()
        verifytimer()
        showhideicon()
    }
    @SuppressLint("WrongViewCast")
//    private fun login(loginModel: LoginModel){
//
////        val imageView = findViewById<ImageView>(R.id.imageview)
////        Glide.with(this).load(loginModel.image).into(imageView)
//
//    }
    fun showhideicon(){
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val pwd = findViewById<EditText>(R.id.pwd)
        imageView2.setOnClickListener {
            if (imageView.visibility == View.VISIBLE) {
                pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                imageView.visibility = View.INVISIBLE
            } else if (imageView2.visibility == View.VISIBLE)
            {
                pwd.transformationMethod = PasswordTransformationMethod.getInstance()
                imageView.visibility = View.VISIBLE
            }
        }
    }
    fun hide(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.signuplinear)
        myLinearLayout.visibility = View.GONE
    }
    fun signupp(){
        val signuplinear = findViewById<LinearLayout>(R.id.signuplinear)
        val Signupbut = findViewById<Button>(R.id.signupbutinmain)
        Signupbut.setOnClickListener {
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

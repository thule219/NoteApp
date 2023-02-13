package com.example.todoapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirm: EditText
    private lateinit var signup: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)
            email = findViewById<EditText>(R.id.emailUser)
            password = findViewById<EditText>(R.id.password)
            confirm = findViewById<EditText>(R.id.confirmPass)
            signup = findViewById<Button>(R.id.btnRegister)
            auth = Firebase.auth
            signup.setOnClickListener {
                signUp()
            }
        }
    fun signUp() {

        val emailUser = email.text.toString()
        val passUser = password.text.toString()
        val confirm = confirm.text.toString()
//
        if(emailUser.isNotEmpty()&&passUser.isNotEmpty()&&passUser==confirm) {

            auth.createUserWithEmailAndPassword(emailUser, passUser)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.getCurrentUser()
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    } else {
                        println(task.exception.toString())
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
        }

    }
}






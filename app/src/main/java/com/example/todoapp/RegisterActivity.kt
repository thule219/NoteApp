package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    val email = findViewById<EditText>(R.id.emailUser)
    val password = findViewById<EditText>(R.id.password)
    val confirm = findViewById<EditText>(R.id.confirmPass)
    val signup = findViewById<Button>(R.id.btnRegister)
    val register = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        signup.setOnClickListener { signUp() }

        }
    fun signUp() {

        val emailUser = email.text.toString()
        val passUser = password.text.toString()
        val confirm = confirm.text.toString()
        if (emailUser.isEmpty() || passUser.isEmpty()) {
            Toast.makeText(this,"Email and pass can't be blank",Toast.LENGTH_SHORT).show()

        }
        if(passUser!=confirm){
            Toast.makeText(this,"Password and confirm pass don't match",Toast.LENGTH_SHORT).show()


        }
        register.createUserWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"Successfully",Toast.LENGTH_SHORT).show()
                finish()
            }else
            {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }

    }
}




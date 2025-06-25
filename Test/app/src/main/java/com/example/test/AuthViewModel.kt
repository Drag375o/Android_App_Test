package com.example.googlesignincomposeapp

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext
    private val auth = FirebaseAuth.getInstance()

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signup(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Signup Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Signup Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signInWithGoogle() {
        // Placeholder: implement Google Sign-In integration here
        Toast.makeText(context, "Google Sign-In not implemented yet", Toast.LENGTH_SHORT).show()
    }
}

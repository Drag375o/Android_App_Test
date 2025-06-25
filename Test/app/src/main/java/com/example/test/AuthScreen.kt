package com.example.googlesignincomposeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AuthScreen(viewModel: AuthViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) }

    val gradient = Brush.horizontalGradient(listOf(Color(0xFF3F51B5), Color(0xFF2196F3)))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!isLogin) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (isLogin) viewModel.login(email, password)
                else viewModel.signup(name, email, password)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(gradient, shape = RoundedCornerShape(50))
        ) {
            Text(if (isLogin) "Login" else "Sign Up")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = if (isLogin) "Don't have an account? Sign up" else "Already have an account? Log in",
            modifier = Modifier.clickable { isLogin = !isLogin },
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { viewModel.signInWithGoogle() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Brush.horizontalGradient(listOf(Color.Red, Color(0xFFEA4335))), shape = RoundedCornerShape(50))
        ) {
            Text("Sign in with Google", color = Color.White)
        }
    }
}
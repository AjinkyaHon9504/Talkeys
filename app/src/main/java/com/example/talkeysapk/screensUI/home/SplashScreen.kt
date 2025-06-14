package com.example.talkeysapk.screensUI.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.talkeysapk.MainActivity
import com.example.talkeysapk.R
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashScreenContent {
                // After splash screen, navigate to MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Close SplashActivity
            }
        }
    }
}

@Composable
fun SplashScreenContent(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000) // Delay for 2 seconds
        onTimeout()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black // Change background color
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your logo
                contentDescription = "Splash Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
            )
        }
    }
}


package com.example.talkeysapk.screensUI.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.talkeysapk.MainActivity
import com.example.talkeysapk.R
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenContent()
        }
    }
}

@Composable
fun SplashScreenContent() {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2000) // 2-second splash screen
        context.startActivity(Intent(context, MainActivity::class.java))
        if (context is ComponentActivity) {
            context.finish()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black // Splash background color
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your actual logo
                contentDescription = "Splash Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
            )
        }
    }
}

package com.example.talkeysapk.screens.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkeysapk.R

@Composable
fun LandingPage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.splash_bg),
            contentDescription = "Splash Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Main text
            Text(
                text = "Unlimited\nentertainment,\nall in one place",
                color = Color(0xFFFFFCFC), // Use desired color
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Center,
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Tagline text
            Text(
                text = "Your Stage, Your Voice\nEvents Reimagined",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Button
            Button(
                onClick ={navController.navigate("signup")},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp), // Very slight rounding for rectangular look
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB768FF) // Purple color similar to the image
                )
            ) {
                Text(
                    text = "GET STARTED",
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
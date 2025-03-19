package com.example.talkeysapk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale


@Composable
fun LandingPage(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Call your background function (Images)
        Starting_Background(overlayAlpha = 0.6f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 54.dp)
                .padding(top = 450.dp), // Adjusted to ensure text appears above images
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Heading Text
            Text(
                text = "Unlimited\nentertainment,\nall in one place",
                style = TextStyle(
                    fontSize = 30.sp, // Increased size
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFFCFC),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(130.dp) // Adjusted for better spacing
            )

            //Spacer(modifier = Modifier.height(2.dp)) // Increased spacing

            // Subheading Text
            Text(
                text = "Your Stage, Your Voice\nEvents Reimagined",
                style = TextStyle(
                    fontSize = 18.sp, // Increased size
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(200.dp)
                    .height(55.dp)
            )

            Spacer(modifier = Modifier.height(12.dp)) // Increased spacing

            // Button
            Button(
                onClick = { navController.navigate("signup") },
                modifier = Modifier
                    .fillMaxWidth() // Makes it stretch based on padding
                    .height(60.dp), // Larger height
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9B51E0)),
                shape = RoundedCornerShape(size = 4.dp)
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        fontSize = 20.sp, // Increased size
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .padding(vertical = 8.dp) // Adjust padding inside the button
                )
            }
        }
    }
}
@Composable
fun Starting_Background(overlayAlpha: Float) {  // Alpha as a parameter
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Base background color
    ) {
        // Background image (Group 1)
        Image(
            painter = painterResource(id = R.drawable.ic_group),
            contentDescription = null,
            modifier = Modifier
                .width(582.15.dp)
                .height(665.75.dp),
            contentScale = ContentScale.Crop
        )

        // Gradient overlay (Rectangle 66) - Should be above Group 1
        Image(
            painter = painterResource(id = R.drawable.rectangle_66),
            contentDescription = null,
            modifier = Modifier
                .width(420.dp)
                .height(800.dp)
                .align(Alignment.TopStart), // Ensures it's above
            contentScale = ContentScale.FillBounds,
            alpha = overlayAlpha  // Uses the parameter value
        )
    }
}
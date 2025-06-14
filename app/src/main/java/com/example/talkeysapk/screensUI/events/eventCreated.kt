package com.example.talkeysapk.screensUI.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkeysapk.screensUI.common.HomeTopBar
import com.example.talkeysapk.R

@Composable
fun EventVerificationScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeTopBar(navController = navController)

            Spacer(modifier = Modifier.height(98.dp))

            Text(
                text = "Your Event is sent for verification",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "It will be listed once it is approved by Team Talkeys",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Box(
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.event_created_sticker),
                    contentDescription = "Verification Sticker",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.weight(1f))


            Button(
                onClick = { navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }},
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .width(240.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8C52FF)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Back to Homepage",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}
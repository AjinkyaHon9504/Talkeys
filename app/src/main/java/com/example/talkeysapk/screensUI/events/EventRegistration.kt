package com.example.talkeysapk.screensUI.events

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import com.example.talkeysapk.screensUI.common.Footer
import com.example.talkeysapk.screensUI.common.HomeTopBar
import com.example.talkeysapk.R

@Composable
fun EventRegistraion(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fallback color
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HomeTopBar(navController = navController)

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "Event Registration",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    color = Color.White
                ),
                modifier = Modifier
                    .height(41.dp)
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(27.dp))

            repeat(10) { index ->
                EventInputField(label = "Detail ${index + 1}")
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .padding(start=85.dp)
                    .width(200.dp)
                    .height(39.dp)
                    .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
                    .clickable {  navController.navigate("registration_success")},
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Register Now",
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Footer(navController = navController)
        }
    }
}


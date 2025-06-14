package com.example.talkeysapk.screens.authentication

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
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
fun LoginScreen(navController: NavController) {
    // Define Urbanist font family
    val urbanistFont = FontFamily(Font(R.font.urbanist_regular))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
    ) {
        // Add any background image if needed
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background texture",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.weight(0.2f))

            // Welcome Back Text
            Text(
                text = "Welcome\nBack!",
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.domine)),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Username/Email TextField
            CustomOutlinedTextField(
                placeholderText = "Username or Email",
                leadingIcon = R.drawable.user,
                isPassword = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password TextField with Forgot Password
            Column {
                CustomOutlinedTextField(
                    placeholderText = "Password",
                    leadingIcon = R.drawable.lock,
                    trailingIcon = R.drawable.eye,
                    isPassword = true
                )

                // Forgot Password - Aligned to end
                Text(
                    text = "Forgot Password?",
                    color = Color(0xFFFF0033),
                    fontSize = 12.sp,
                    fontFamily = urbanistFont,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 8.dp),
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Login Button
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9C27B0)
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontFamily = urbanistFont,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.weight(0.8f))
        }
    }
}
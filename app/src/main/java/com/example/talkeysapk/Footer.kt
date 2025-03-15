package com.example.talkeysapk

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Footer(modifier: Modifier = Modifier,navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Horizontal Line
        Box(
            modifier = Modifier
                .width(364.87216.dp)
                .height(0.8.dp)
                .background(color = Color.White)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left Side (Team Talkeys + Address) - Shifted slightly to the left
            Column(
                modifier = Modifier
                    .width(197.dp)
                    .offset(x = (-10).dp) // Move left
            ) {
                Text(
                    text = "Team Talkeys",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.W400,
                        color = Color(0xFFF5F5F5),
                    ),
                    modifier = Modifier.width(144.dp).height(26.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Address: Thapar University, Patiala, Punjab, India\n\n" +
                            "Get in Touch: +91 98882 30798\ntalkeys11@gmail.com",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.W500,
                        color = Color(0xFFF5F5F5),
                    ),
                    modifier = Modifier.width(197.dp).height(85.dp)
                )
            }

            // Right Side (Text Buttons) - Center aligned
            Column(
                modifier = Modifier.width(150.dp), // Keep some width constraint
                horizontalAlignment = Alignment.CenterHorizontally // Center text buttons
            ) {
                FooterTextButton("Contact us") { navController.navigate("contact_us") }
                Spacer(modifier = Modifier.height(18.dp))

                FooterTextButton("About us") { println("Navigating to About Us!") }
                Spacer(modifier = Modifier.height(18.dp))

                FooterTextButton("Privacy Policy") { println("Navigating to Privacy Policy!") }
                Spacer(modifier = Modifier.height(18.dp))

                FooterTextButton("Terms of Service") { println("Navigating to Terms of Service!") }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Center Talkeys Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Talkeys Logo",
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Social Media Icons
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            SocialMediaIcon(R.drawable.ic_facebook_icon)
            SocialMediaIcon(R.drawable.ic_instagram_icon)
            SocialMediaIcon(R.drawable.ic_x_icon)
            SocialMediaIcon(R.drawable.ic_linkedin_icon)
            SocialMediaIcon(R.drawable.ic_yt_icon)
        }

        Spacer(modifier = Modifier.height(19.dp))

        // Copyright Text
        Text(
            text = "© 2024  Talkeys. All rights reserved.",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight.W400,
                color = Color(0xFFF5F5F5),
            ),
            modifier = Modifier.width(230.dp)
                //.height(22.dp)
        )
    }
}

// ✅ Footer Text Button with Clickable Action (Kept as is)
@Composable
fun FooterTextButton(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontWeight = FontWeight.W500,
            color = Color(0xFFF5F5F5),
        ),
        modifier = Modifier.clickable(onClick = onClick)
    )
}

// ✅ Social Media Icon (Kept as is)
@Composable
fun SocialMediaIcon(@DrawableRes iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}




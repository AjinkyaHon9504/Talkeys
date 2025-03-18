package com.example.talkeysapk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun privacyPolicy(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Fixed TopBar
        HomeTopBar(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable content using Column with verticalScroll
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            // Terms Of Service Title
            Text(
                text = "Privacy Policy",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            )


            Spacer(modifier = Modifier.height(45.dp))

            Text(
                text = "At Talkeys, we value your privacy and are committed to protecting your personal data. We collect information such as your name, email address, contact number, and other relevant details when you sign up, register for events, or interact with our platform. This information is solely used to provide services such as event registration, ticketing, user support, and to enhance your overall experience on Talkeys.\n" +
                        "\n" +
                        "We do not sell or rent your personal data to third parties. However, your information may be shared with trusted partners or event organizers strictly for event-related purposes. To improve our website’s functionality, we may use cookies and analytics tools, which help us understand user behavior and enhance platform performance.\n" +
                        "Talkeys follows industry-standard security protocols to safeguard your information against unauthorized access or misuse. As a user, you have the right to access, update, or request the deletion of your personal data at any time by contacting our support team.\n" +
                        "\n" +
                        "We retain your personal information for as long as it is required to deliver our services and comply with legal obligations. This privacy policy may be updated periodically, and we will notify users of significant changes through our platform or via email.\n" +
                        "\n" +
                        "If you have any questions or concerns regarding our privacy policy, please feel free to contact us at talkeys11@gmail.com",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(81.dp))

            Footer(navController = navController)
        }
    }

}
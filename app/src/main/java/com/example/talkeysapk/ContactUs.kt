package com.example.talkeysapk
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun ContactUsScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            // HomeTopBar inside the Scaffold
            HomeTopBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Respect padding from Scaffold
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Scrollable Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
       //         Spacer(modifier = Modifier.height(64.5.dp)) // Extra spacing if needed

                // Title and Sticker Row
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Contact Us",
                        style = TextStyle(
                            fontSize = 34.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                            color = Color(0xFFF5F5F5)
                        ),
                        modifier = Modifier
                            .height(41.dp)
                            .offset(y = 10.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp)) // Increased space between text & sticker

                    // Sticker Image (Increased Size)
                    Image(
                        painter = painterResource(id = R.drawable.contactus_sticker),
                        contentDescription = "Sticker Image",
                        contentScale = ContentScale.Fit, // Adjusts image size properly
                        modifier = Modifier
                            .size(200.dp) // 🔥 Increased size
                            .shadow(
                                elevation = 20.dp, // Slightly more shadow
                                spotColor = Color(0x40000000),
                                ambientColor = Color(0x40000000)
                            )
                            .padding(1.dp)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                // Subheading
                Text(
                    text = "We'd love to hear from you!",
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 30.8.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFAC6FE4),
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .width(325.dp)
                        .height(31.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Fields
                ContactField(label = "Your Name", placeholder = "Enter your full name")
                Spacer(modifier = Modifier.height(40.dp))
                ContactField(label = "Your Email", placeholder = "Enter your email address")
                Spacer(modifier = Modifier.height(40.dp))
                ContactField(
                    label = "Your Message",
                    placeholder = "Type your message here",
                    height = 174.dp
                )

                Spacer(modifier = Modifier.height(46.dp))

                // Send Message Button
                Button(
                    onClick = { /* Add your send action here */ },
                    modifier = Modifier
                        .width(145.dp)
                        .height(39.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(size = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A44CB))
                ) {
                    Text(
                        text = "Send Message",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .width(125.dp)
                            .height(19.dp)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Footer Function
                Footer(navController = navController)
            }
        }
    }
}

@Composable
fun ContactField(label: String, placeholder: String, height: Dp = 56.dp) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.4.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight.Medium,
                color = Color(0xFFF5F5F5)
            ),
            modifier = Modifier
                .width(325.dp)
                .height(22.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color(0xFF4B5563), shape = RoundedCornerShape(size = 8.dp))
                .width(325.dp)
                .height(height)
                .background(color = Color(0xFF000000), shape = RoundedCornerShape(size = 8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.4.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFD4D4D8)
                )
            )
        }
    }
}


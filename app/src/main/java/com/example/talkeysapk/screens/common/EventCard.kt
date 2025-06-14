package com.example.talkeysapk.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talkeysapk.data.model.Event
import com.example.talkeysapk.R

@Composable
fun EventCard(event: Event, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(162.dp)
            .height(320.dp)
            .clickable { onClick() }
            .shadow(
                elevation = 4.dp,
              //  spotColor = Color(0xFF000000),
                ambientColor = Color(0xFF212120)
            )
            .shadow(
                elevation = 27.dp,
            //   spotColor = Color(0x40FFFFFF),
                ambientColor = Color(0xFF1E1E1E)
            )
            .background(color = Color(0xFF1E1E1E), shape = RoundedCornerShape(15.dp))
            .padding(6.dp) // Padding inside the box
    ) {
        Column(
            modifier = Modifier
                .width(150.dp)
                .height(300.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = painterResource(id = event.imageRes),
                    contentDescription = event.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // ✅ Gradient Overlay for better text visibility
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                                startY = 100f
                            )
                        )
                )
            }

            Spacer(modifier = Modifier.height(6.dp)) // Space between image & text

            // ✅ Event Title (Now More Readable)
            Text(
                text = event.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight.Bold,
                    color = Color.White // White text on dark overlay
                ),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(2.dp)) // Space between title & location

            // ✅ Location (Now More Readable)
            Text(
                text = event.location,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFBDBDBD) // Light gray for contrast
                ),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

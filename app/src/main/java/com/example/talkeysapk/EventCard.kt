package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventCard(event: Event, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(162.dp)
            .height(320.dp) // Increased height to ensure text fits
            .clickable { onClick() }
            .shadow(
                elevation = 4.dp,
                ambientColor = Color(0x1AFFFFFF)
            )
            .shadow(
                elevation = 27.dp,
                ambientColor = Color(0xFF242423)
            )
            .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 15.dp))
            .padding(6.dp) // Ensuring 6dp padding from all sides
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp), // 4dp space between items
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight() // Allows content to expand properly
        ) {
            Image(
                painter = painterResource(id = event.imageRes),
                contentDescription = event.title,
                contentScale = ContentScale.Crop, // Crop ensures image fills space correctly
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(15.dp))
                 //   .padding(end = 6.dp)
            )

            Spacer(modifier = Modifier.height(4.dp)) // Extra space between image & text

            Text(
                text = event.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(700),
                    color = Color.White
                ),
                modifier = Modifier
                    .width(99.dp)
                    .height(19.dp)
            )

            Text(
                text = event.location,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(500),
                    color = Color.White
                ),
                modifier = Modifier
                    .width(53.dp)
                    .height(17.dp)
            )
        }
    }
}


/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEventCard() {
    TalkeysApkTheme {
        EventCard(
            title = "Sunday Salsa",
            location = "Downtown Club",
            imageRes = R.drawable.ic_eventbanner
        )
    }
}
*/


package com.example.talkeysapk.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talkeysapk.R

@Composable
fun InfluencerCard(name: String, profession: String, imageRes: Int) {
    Box(
        modifier = Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0xFF000000), ambientColor = Color(0xFF000000))
            .shadow(elevation = 27.dp, spotColor = Color(0x40FFFFFF), ambientColor = Color(0x40FFFFFF))
            .width(131.dp)
            .height(158.dp)
            .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 15.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start, // Changed alignment to Start for left alignment
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(horizontal = 8.dp) // Optional: Adjust padding for better alignment
        ) {
            // Influencer Image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Influencer Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(103.dp)
                    .background(
                        color = Color(0xFFD9D9D9),
                        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)
                    )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Influencer Name
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Influencer Profession
            Text(
                text = profession,
                modifier = Modifier
                    .fillMaxWidth() // Ensures proper alignment within the Column
                    .padding(start = 4.dp), // Adds padding for consistent left alignment
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfluencerCardPreview() {
    InfluencerCard(
        name = "Arijit Sharma",
        profession = "F1 Racer",
        imageRes = R.drawable.ic_influencer_banner // Replace with an actual image resource
    )
}

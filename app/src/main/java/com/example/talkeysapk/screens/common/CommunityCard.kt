package com.example.talkeysapk.screens.common

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkeysapk.R

@Composable
fun CommunityCard(name: String, imageRes: Int, description: String, navController: NavController) {
    // ✅ Wrapper Box with Background and Shadows
    Box(
        modifier = Modifier
           // .offset(x = 0.dp, y = 0.dp)
            .shadow(elevation = 4.dp,
               // spotColor = Color(0xFF000000),
                ambientColor = Color(0xFF20201F)
            )
          //  .shadow(elevation = 27.dp,
              //  spotColor = Color(0x40FFFFFF),
            //    ambientColor = Color(0x40FFFFFF))
            .width(148.dp)
            .clickable { navController.navigate("communityInfo/$name") }
            .height(200.dp) // Slightly increased height to accommodate extra text
            .background(color = Color(0xFF212020), shape = RoundedCornerShape(size = 15.dp))
            .padding(start = 6.dp, top = 7.dp, end = 6.dp, bottom = 7.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            // ✅ Community Image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Community Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(136.dp)
                    .background(
                        color = Color(0xFFD9D9D9),
                        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp))
            )

            // ✅ Community Name
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 6.dp, top = 4.dp)
            )

            // ✅ Additional Description Text
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)), // Less bold
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 6.dp, top = 2.dp)
            )
        }
    }
}

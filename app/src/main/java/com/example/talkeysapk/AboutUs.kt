package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun AboutUsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HomeTopBar(navController)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "About us",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(23.dp))

            Text(
                text = "Welcome to Talkeys, the ultimate meeting ground for fandoms, communities, and creators! Whether you're a die-hard anime lover, a formula racing enthusiast, a desi hip-hop fan, or part of any niche community, Talkeys is where your world gets louder, more connected, and more exciting.\n\nTalkeys is a unique blend of a booking platform and anonymous chatroom designed to unite passionate people and give underrated artists the space they deserve. Dive into anonymous chatrooms curated for different interests and connect with others who share your passion. No matter how niche or mainstream, your community awaits you here.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    color = Color.White,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier
                    .width(345.dp)
                    .height(288.dp)
            )

            Spacer(modifier = Modifier.height(44.dp))

            Image(
                painter = painterResource(id = R.drawable.about_us_sticker),
                contentDescription = "image description",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(241.86639.dp)
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Journey through the depths to\nfind your next adventure",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(220.dp)
                    .height(55.dp)
            )

            Spacer(modifier = Modifier.height(44.dp))

            Text(
                text = "But we’re not just about conversations—we’re about action! Artists can post their gigs and events, and fans can easily book tickets right through our platform. Discover hidden talent, support emerging creators, and be part of something bigger.\n\nAt Talkeys, we believe in a future where every artist, established or emerging, has the freedom to create their own community. We envision a platform where celebrated artists can deepen their connections with their fans, while underrated talent gets the opportunity to rise and shine.\n\nOur mission is to create a space where the voices of emerging artists are amplified, giving them equal footing to showcase their craft. We want to build a world where artistic discovery is powered by real communities, where both creators and fans can thrive together.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    color = Color.White,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier
                    .width(345.dp)
                    .height(410.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Footer(navController=navController)
        }
    }
}

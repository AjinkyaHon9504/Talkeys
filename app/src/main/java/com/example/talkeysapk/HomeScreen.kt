package com.example.talkeysapk
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = { HomeTopBar() } // ✅ Keeps TopBar fixed
    ) { paddingValues ->
        Box(
        ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(
                    Color.Black.copy(alpha = 0.8f),
                    RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Explore Shows and \nevents with ease.",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Connect with fellow enthusiasts in our \nchat rooms. Share experiences and ideas\nanonymously.",
                    color = Color(0xFF8A44CB),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate("events") },
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(
                            text = "Explore Events",
                        )
                    }

                    Button(
                        onClick = { navController.navigate("communities") },
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(
                            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                            color = Color.White,
                        )
                    }


    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(communityList) { community ->
            CommunityCard(
                name = community.name,
                imageRes = community.imageRes,
                description = community.description
            )
        }
    }
}

    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(influencerList) { influencer ->
            InfluencerCard(
                name = influencer.name,
                profession = influencer.profession,
                imageRes = influencer.imageResId
            )
        }
    }
}
@Composable
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 14.dp)
        ) {
            Text(
                text = "Host your own EVENT!!!",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFFCFCFC),
            )

            Spacer(modifier = Modifier.height(45.dp))

            Text(
                text = "Create an event, invite your community, and manage everything in one place.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                ),
                modifier = Modifier
                    .width(237.dp)
                    .height(57.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Box(
                modifier = Modifier
                    .padding(start = 63.5.dp)
                    .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
                    .clickable { /* Navigate to event creation */ },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Host Event",
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }
        }

            modifier = Modifier
        )
    }
}



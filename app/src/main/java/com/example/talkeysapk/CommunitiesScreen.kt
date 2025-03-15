package com.example.talkeysapk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun CommunitiesScreen(navController: NavController) {
    val allCommunities = CommunityData.getAllCommunities()
    val categories = CommunityData.getAllCategories()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background), // Replace with your background image resource ID
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)) // Optional: Add a semi-transparent overlay if needed
                .padding(bottom = 56.dp) // Padding for BottomBar
        ) {
            // Top Bar
            HomeTopBar()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                // Title
                item {
                    Text(
                        text = "Explore Communities",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                            color = Color.White,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.padding(top = 12.dp, start = 19.dp)
                    )
                }

                categories.forEach { category ->
                    item { CommunityTitle(category.name) }
                    item { CommunityRow(category.communities, navController) }
                }

                item { Footer(navController = navController) }
            }
        }
        val scrollState = rememberScrollState()

        // BottomBar
        BottomBar(navController = navController, scrollState, modifier = Modifier.align(Alignment.BottomCenter))
    }
}
@Composable
fun CommunityRow(communities: List<HomePageCommunity>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 19.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        items(communities) { community ->
            CommunityCard(
                name = community.name,
                imageRes = community.imageRes,
                description = community.description,
                navController = navController
            )
        }
    }
}

@Composable
fun CommunityTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            color = Color.White
        ),
        modifier = Modifier.padding(start = 30.dp)
    )
}


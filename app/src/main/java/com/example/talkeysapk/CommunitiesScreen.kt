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
import androidx.compose.ui.graphics.Color
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
    val category1Communities = listOf(
        HomePageCommunity("Music Lovers", R.drawable.ic_community_card, "A vibrant group of music enthusiasts."),
        HomePageCommunity("Tech Geeks", R.drawable.ic_community_card, "For tech lovers and innovators."),
        HomePageCommunity("Dance Squad", R.drawable.ic_community_card, "A community for passionate dancers.")
    )

    val category2Communities = listOf(
        HomePageCommunity("Art Lovers", R.drawable.ic_community_card, "For creators and art admirers."),
        HomePageCommunity("Fitness Enthusiasts", R.drawable.ic_community_card, "Focus on health and well-being."),
        HomePageCommunity("Book Club", R.drawable.ic_community_card, "Sharing a love for reading.")
    )

    val category3Communities = listOf(
        HomePageCommunity("Travel Explorers", R.drawable.ic_community_card, "For adventurous souls."),
        HomePageCommunity("Foodies Unite", R.drawable.ic_community_card, "Exploring the best cuisines."),
        HomePageCommunity("Photography Pros", R.drawable.ic_community_card, "Capturing the best moments.")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
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

                // Categories
                item { CommunityTitle("Category 1") }
                item { CommunityRow(category1Communities) }

                item { CommunityTitle("Category 2") }
                item { CommunityRow(category2Communities) }

                item { CommunityTitle("Category 3") }
                item { CommunityRow(category3Communities) }

                item { Footer() }
            }
        }
        val scrollState = rememberScrollState()

        // BottomBar
        BottomBar(navController = navController, scrollState,modifier = Modifier.align(Alignment.BottomCenter))
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
    )
}

@Composable
fun CommunityRow(communities: List<HomePageCommunity>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 19.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        items(communities) { community ->
            CommunityCard(
                name = community.name,
                imageRes = community.imageRes,
                description = community.description
            )
        }
    }
}

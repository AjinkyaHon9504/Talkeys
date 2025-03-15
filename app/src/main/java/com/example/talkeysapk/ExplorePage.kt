package com.example.talkeysapk

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
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
fun ExplorePage(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    val selectedSortOption = remember { mutableStateOf("Sort by") }
    val sortOptions = listOf("Latest", "Relevant", "Hot")
    val communityList = CommunityData.getAllCommunities()

    // Fetch event list
    val eventList = Event.getAllEvents()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(Color.White, Color.LightGray))) // Example gradient background
            .paint(
                painter = painterResource(id = R.drawable.background), // Add background image
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Bar - Non-scrollable
            HomeTopBar()

            // Scrollable Content
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Spacer(modifier = Modifier.height(25.dp))

                    // Dropdown & Search Box
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Dropdown Menu
                        Box(
                            modifier = Modifier
                                .width(102.728.dp)
                                .height(39.dp)
                                .background(Color(0x80404040), shape = RoundedCornerShape(50.dp))
                                .clickable { expanded.value = true }
                                .padding(horizontal = 15.dp, vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = selectedSortOption.value,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color.White
                                    )
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_icon),
                                    contentDescription = "Dropdown Arrow",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        DropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false }
                        ) {
                            sortOptions.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(text = option, color = Color.White) },
                                    onClick = {
                                        selectedSortOption.value = option
                                        expanded.value = false
                                    }
                                )
                            }
                        }

                        // Search Box (Text Aligned Left, Search Icon to the Right)
                        Box(
                            modifier = Modifier
                                .width(224.dp)
                                .height(27.dp)
                                .background(Color(0x4DF9F9F9), shape = RoundedCornerShape(3.dp))
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                BasicTextField(
                                    value = searchQuery.value,
                                    onValueChange = { searchQuery.value = it },
                                    textStyle = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                        fontWeight = FontWeight(300),
                                        color = Color.White
                                    ),
                                    modifier = Modifier.weight(1f) // This ensures text expands and aligns left
                                )

                                if (searchQuery.value.isEmpty()) {
                                    Text(
                                        text = "Search event/community",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                            fontWeight = FontWeight(300),
                                            color = Color(0xFFA3A3A3),
                                            textAlign = TextAlign.Left
                                        )
                                    )
                                }

                                Icon(
                                    painter = painterResource(id = R.drawable.ic_search_icon),
                                    contentDescription = "Search Icon",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(18.dp)
                                        .clickable { /* Handle search */ }

                                )
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(17.5.dp))
                    // LazyRow for User Messages
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 19.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(5) { // Replace with actual user messages
                            UserMessageBox()
                        }
                    }

                    Spacer(modifier = Modifier.height(34.5.dp))
                    // Explore Events Section
                    Text(
                        text = "Explore Events",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Fix EventRow() issue by passing real event list
                    EventRow(events = eventList, navController = navController)

                    Spacer(modifier = Modifier.height(32.dp))

                    // Explore Communities Section
                    Text(
                        text = "Explore Communities",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                            fontWeight = FontWeight(500),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    CommunityRow(communityList, navController) // Call CommunityRow()

                    Spacer(modifier = Modifier.height(40.dp)) // Spacer with 40dp padding

                    // Footer
                    Footer(navController = navController)
                }
            }
        }
    }
}


@Composable
fun UserMessageBox() {
    Box(
        modifier = Modifier
            .width(224.dp)
            .height(220.dp)
            .background(Color(0xB2262626), shape = RoundedCornerShape(20.dp))
            .padding(start = 29.dp, top = 12.dp, end = 29.dp, bottom = 12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            // Profile Info Row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_community_comment_icon),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color(0xFFD9D9D9), shape = RoundedCornerShape(30.dp))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Ramesh Kumar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontWeight = FontWeight(700),
                        color = Color.White
                    )
                )
            }

            // Message Text
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Risus id . urife fnji ue wf jidks uiewb fj y4uwhel oiewibo ohwfebjk 2huweij 23huibweh 23uih32p",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(300),
                    color = Color.White
                ),
              //  modifier = Modifier.width(166.dp)
            )

            // Like, Comment, Share Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { /* Handle Like */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = "Like",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp) // Increased size
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "183", color = Color.White)
                }

                TextButton(onClick = { /* Handle Comment */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = "Comment",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "8", color = Color.White)
                }

                TextButton(onClick = { /* Handle Share */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "Share",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "12", color = Color.White)
                }
            }

            // Replies & Likes Info
            Text(text = "8 replies • 183 likes", color = Color.White, fontSize = 14.sp)
        }
    }
}


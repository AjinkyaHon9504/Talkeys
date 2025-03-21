package com.example.talkeysapk
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.talkies.ui.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val eventList = Event.getAllEvents()
    val communityList = CommunityData.getAllCommunities()

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image (fixed, not inside scrolling area)
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Scaffold(
            topBar = { HomeTopBar(navController = navController) },
            containerColor = Color.Transparent, // Make scaffold background transparent
            contentColor = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // LazyColumn with LazyListState for scroll tracking
                val lazyListState = rememberLazyListState()

                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 100.dp) // Padding for BottomBar
                ) {
                    item { BannerSection(navController) }
                    item { CategoryTitle("Upcoming Events") }
                    item { EventRow(eventList, navController) }
                    item { CategoryTitle("Featured Communities") }
                    item { CommunityRow(communityList, navController) }
                    item { CategoryTitle("Influencers Shaping the Community") }
                    item { InfluencerRow() }
                    item { HostYourOwnEvent(navController) }
                    item {
                        Footer(
                            modifier = Modifier,
                            navController = navController
                        )
                    }
                }

                // Create a derived ScrollState from LazyListState for the BottomBar
                val scrollState = rememberScrollState()

                // Update scrollState whenever lazyListState changes
                LaunchedEffect(lazyListState.firstVisibleItemScrollOffset) {
                    scrollState.scrollTo(lazyListState.firstVisibleItemScrollOffset)
                }
            }
        }

        // Add BottomBar outside the Scaffold to ensure it appears above everything
        val scrollState = rememberScrollState()
        BottomBar(
            navController = navController,
            scrollState = scrollState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun HostYourOwnEvent(navController: NavController) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
               // .padding(horizontal = 14.dp)
            , horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                 //   .padding(start = 14.dp)
                //    .width(260.dp)
            ) {
                Text(
                    text = "Host your own EVENT!!!",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFFCFCFC),
                    ),
                    fontSize = 22.sp,
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
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .width(237.dp)
                        .height(57.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                Box(
                    modifier = Modifier
                        .padding(start = 63.5.dp)
                        .width(130.dp)
                        .height(45.dp)
                        .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
                        .clickable { navController.navigate("create_event")},
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Host Event",
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.hostevent_sticker),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(260.dp)
                   // .padding(end = 16.dp)
            )
        }
}


// ✅ BANNER SECTION
@Composable
fun BannerSection(navController: NavController) {
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
                .fillMaxWidth(0.9f)
                .align(Alignment.Center)
                .background(
                    Color.Black.copy(alpha = 0.8f),
                    RoundedCornerShape(12.dp)
                )
                .padding(16.dp)
                .width(122.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Explore Shows and \nevents with ease.",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Connect with fellow enthusiasts in our \nchat rooms. Share experiences and ideas\nanonymously.",
                    color = Color(0xFF8A44CB),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate("events") },
                        modifier = Modifier
                           // .widthIn(150.dp)
                            .height(48.dp)
                            .width(143.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A44CB))
                    ) {
                        Text(
                            text = "Explore Events",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = { navController.navigate("communities") },
                        modifier = Modifier
                         //   .widthIn(200.dp)
                            .height(48.dp)
                            .width(190.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A44CB))
                    ) {
                        Text(
                            text = "Explore Communities",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}
/*
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
*/

@Composable
fun EventRow(events: List<Event>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 19.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        items(events) { event ->
            EventCard(event = event) {
                navController.navigate("eventDetail/${event.title}")
            }
        }
    }

    // ✅ INFLUENCER ROW
    @Composable
    fun InfluencerRow() {
        val influencerList = listOf(
            InfluencerHomeScreen("Arijit Sharma", "F1 Racer", R.drawable.ic_influencer_banner),
            InfluencerHomeScreen("Arsh Chatrath", "Cricketer", R.drawable.ic_influencer_banner),
            InfluencerHomeScreen("Rohan Mehta", "Tech Reviewer", R.drawable.ic_influencer_banner)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
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
    fun HostYourOwnEvent(modifier: Modifier = Modifier) {
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
                    .width(260.dp)
            ) {
                Text(
                    text = "Host your own EVENT!!!",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFFCFCFC),
                    ),
                    fontSize = 22.sp,
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
                        textAlign = TextAlign.Left,
                    ),
                    modifier = Modifier
                        .width(237.dp)
                        .height(57.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                Box(
                    modifier = Modifier
                        .padding(start = 63.5.dp)
                        .width(130.dp)
                        .height(45.dp)
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

            // ✅ Lottie Animation
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.host_ur_event_animation))
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = Int.MAX_VALUE // 🔥 Loop forever
            )

            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier
                    .size(300.dp)
                    .scale(2.0f) // 🔥 Increase size (adjust as needed)
                    .padding(end = 16.dp)
            )
        }
    }
}

// ✅ INFLUENCER ROW
@Composable
fun InfluencerRow() {
    val influencerList = listOf(
        InfluencerHomeScreen("Arijit Sharma", "F1 Racer", R.drawable.ic_influencer_banner),
        InfluencerHomeScreen("Arsh Chatrath", "Cricketer", R.drawable.ic_influencer_banner),
        InfluencerHomeScreen("Rohan Mehta", "Tech Reviewer", R.drawable.ic_influencer_banner)
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
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
fun FooterWrapper(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp) // Set a fixed height for the Footer
            .background(Color.Black) // Ensure background matches
    ) {
        Footer(navController = navController)
    }
}
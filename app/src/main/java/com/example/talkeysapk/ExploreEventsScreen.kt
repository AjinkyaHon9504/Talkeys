package com.example.talkeysapk
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar
import androidx.compose.ui.unit.dp
@Composable
fun ExploreEventsScreen(navController: NavController) {
    val allEvents = Event.getAllEvents()
    val techEvents = allEvents.filter { it.category == "Tech" }
    val musicEvents = allEvents.filter { it.category == "Music" }
    val sportsEvents = allEvents.filter { it.category == "Sports" }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = { HomeTopBar(navController = navController) },
            containerColor = Color.Transparent,
            contentColor = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                val lazyListState = rememberLazyListState()

                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item{Spacer(Modifier.padding(2.dp))}
                    item {
                        Text(
                            text = "Explore Events",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                                color = Color.White,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.padding(top = 12.dp, start = 19.dp)
                        )
                    }

                    item { Spacer(modifier = Modifier.height(1.dp)) }

                    // Category 1: Tech Events
                    if (techEvents.isNotEmpty()) {
                        item { CategoryTitle("Tech Events") }
                        item { EventRow(events = techEvents, navController = navController) }
                    }

                    // Category 2: Music Events
                    if (musicEvents.isNotEmpty()) {
                        item { CategoryTitle("Music Events") }
                        item { EventRow(events = musicEvents,navController = navController) }
                    }

                    // Category 3: Sports Events
                    if (sportsEvents.isNotEmpty()) {
                        item { CategoryTitle("Sports Events") }
                        item { EventRow(events = sportsEvents,navController = navController) }
                    }

                    item { Spacer(modifier = Modifier.height(5.dp)) }

                    item { Footer(navController = navController) }
                }
            }
        }

        // Add BottomBar outside the Scaffold
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
fun CategoryTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            fontWeight = FontWeight(500),
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Start
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 19.dp) // 32dp above, 14dp below
    )
}

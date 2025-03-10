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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun ExploreEventsScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            // Top Bar
            HomeTopBar()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
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

                item { Spacer(modifier = Modifier.height(4.dp)) }

                item { Spacer(modifier = Modifier.height(5.dp)) }

                item { Footer() }
            }
        }

        val scrollState = rememberScrollState()
        BottomBar(navController = navController, scrollState, modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun CategoryTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
        ),
        modifier = Modifier
    )
}

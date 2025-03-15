package com.example.talkeysapk

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavController, scrollState: ScrollState, modifier: Modifier = Modifier) {
    val backgroundColor by animateColorAsState(
        targetValue = if (scrollState.value > 100) Color.Black.copy(alpha = 0.3f)
        else Color.White.copy(alpha = 0.1f),
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .offset(y = (-20).dp)
            .padding(bottom = 16.dp)
            .shadow(
                elevation = 35.dp,
                spotColor = Color(0x1AFFFFFF),
                ambientColor = Color(0x1AFFFFFF)
            )
            .background(color = backgroundColor, shape = RoundedCornerShape(30.dp))
            .graphicsLayer {
                alpha = 0.9f
                shadowElevation = 10f
                shape = RoundedCornerShape(30.dp)
                clip = true
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(370.dp)
                .height(40.dp)
                .padding(horizontal = 25.dp)
        ) {
            val icons = listOf(
                R.drawable.ic_community_icon,
                R.drawable.ic_events_icon,
                R.drawable.ic_home_icon,
                R.drawable.ic_search_icon,
                R.drawable.ic_globe_icon
            )

            val destinations = listOf(
                "communities",
                "events",
                "home",
                "explore",
                ""
            )

            icons.zip(destinations).forEach { (icon, destination) ->
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Navigation Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (destination.isNotEmpty()) {
                                navController.navigate(destination)
                            }
                        },
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingBottomBarPreview() {
    BottomBar(navController = rememberNavController(), scrollState = rememberScrollState())
}

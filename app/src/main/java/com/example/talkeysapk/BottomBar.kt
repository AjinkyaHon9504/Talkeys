package com.example.talkeysapk

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavController, scrollState: ScrollState, modifier: Modifier = Modifier) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    // Animate the background color based on scroll position and route
    val backgroundColor by animateColorAsState(
        targetValue = when (currentRoute) {
            "home" -> when {
                scrollState.value > 100 -> Color(0xFF1A1A1A)
                else -> Color(0xFF0A0A0A)
            }
            "events", "communities" -> when {
                scrollState.value > 100 -> Color(0xFF151515)
                else -> Color(0xFF0D0D0D)
            }
            "explore" -> when {
                scrollState.value > 100 -> Color(0xFF131313)
                else -> Color(0xFF080808)
            }
            else -> Color(0xFF000000)
        },
        animationSpec = tween(
            durationMillis = 300, // Faster animation for more responsive feel
            easing = FastOutSlowInEasing
        )
    )

    Box(
        modifier = modifier
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
            val navigationItems = listOf(
                NavigationItem(
                    route = "communities",
                    normalIcon = R.drawable.ic_community_icon,
                    selectedIcon = R.drawable.ic_globe_selected,
                    contentDescription = "Communities"
                ),
                NavigationItem(
                    route = "events",
                    normalIcon = R.drawable.ic_events_icon,
                    selectedIcon = R.drawable.ic_events_selected,
                    contentDescription = "Events"
                ),
                NavigationItem(
                    route = "home",
                    normalIcon = R.drawable.ic_home_icon,
                    selectedIcon = R.drawable.ic_home_selected,
                    contentDescription = "Home"
                ),
                NavigationItem(
                    route = "explore",
                    normalIcon = R.drawable.ic_search_icon,
                    selectedIcon = R.drawable.ic_search_selected,
                    contentDescription = "Explore"
                ),
                NavigationItem(
                    route = "screen_not_found",
                    normalIcon = R.drawable.ic_globe_icon,
                    selectedIcon = R.drawable.ic_community_selected,
                    contentDescription = "Globe"
                )
            )

            navigationItems.forEach { navItem ->
                val isSelected = navItem.route == currentRoute
                val iconToDisplay = if (isSelected) navItem.selectedIcon else navItem.normalIcon

                Icon(
                    painter = painterResource(id = iconToDisplay),
                    contentDescription = navItem.contentDescription,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                    tint = Color.Unspecified // Keeps original icon colors
                )
            }
        }
    }
}

// Data class to hold navigation item information
data class NavigationItem(
    val route: String,
    val normalIcon: Int,
    val selectedIcon: Int,
    val contentDescription: String
)

@Preview(showBackground = true)
@Composable
fun FloatingBottomBarPreview() {
    BottomBar(navController = rememberNavController(), scrollState = rememberScrollState())
}
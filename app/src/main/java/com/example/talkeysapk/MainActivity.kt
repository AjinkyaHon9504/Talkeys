package com.example.talkeysapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.talkeysapk.ui.theme.TalkeysApkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalkeysApkTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("events") { ExploreEventsScreen(navController) }
        composable("communities") { CommunitiesScreen(navController) }
        composable("explore") { ExplorePage(navController) }
        composable("contact_us") { ContactUsScreen(navController) }

        composable(
            "eventDetail/{eventTitle}",
            arguments = listOf(navArgument("eventTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventTitle = backStackEntry.arguments?.getString("eventTitle")

            // Fetch event from global event list
            val event = Event.getEventByTitle(eventTitle)

            if (event != null) {
                EventDetailScreen( event,navController)
            } else {
                // Handle event not found case (e.g., navigate back)
                navController.popBackStack()
            }
        }
        composable(
            "communityInfo/{communityName}",
            arguments = listOf(navArgument("communityName") { type = NavType.StringType })
        ) { backStackEntry ->
            val communityName = backStackEntry.arguments?.getString("communityName")

            communityName?.let { name ->
                val community = CommunityData.getCommunityByName(name)

                if (community != null) {
                    CommunityInfo(navController, community)
                } else {
                    navController.popBackStack() // Go back if community is not found
                }
            } ?: navController.popBackStack() // Handle null community name case
        }

    }
}
package com.example.talkeysapk.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.talkeysapk.data.model.Event
import com.example.talkeysapk.screensUI.authentication.LoginScreen
import com.example.talkeysapk.screensUI.authentication.SignUpScreen
import com.example.talkeysapk.screensUI.community.CommunitiesScreen
import com.example.talkeysapk.screensUI.community.CommunityInfo
import com.example.talkeysapk.screensUI.events.CreateEventScreen
import com.example.talkeysapk.screensUI.events.EventDetailScreen
import com.example.talkeysapk.screensUI.events.EventRegistraion
import com.example.talkeysapk.screensUI.events.EventVerificationScreen
import com.example.talkeysapk.screensUI.events.ExploreEventsScreen
import com.example.talkeysapk.screensUI.events.RegistrationSuccessScreen
import com.example.talkeysapk.screensUI.home.AboutUsScreen
import com.example.talkeysapk.screensUI.home.CommunityData
import com.example.talkeysapk.screensUI.home.ContactUsScreen
import com.example.talkeysapk.screensUI.home.ExplorePage
import com.example.talkeysapk.screensUI.home.HomeScreen
import com.example.talkeysapk.screensUI.home.LandingPage
import com.example.talkeysapk.screensUI.home.ScreenNotFound
import com.example.talkeysapk.screensUI.home.TermsAndConditionsScreen
import com.example.talkeysapk.screensUI.home.privacyPolicy

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landingpage") {
        composable("landingpage") { LandingPage(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("events") { ExploreEventsScreen(navController) }
        composable("communities") { CommunitiesScreen(navController) }
        composable("explore") { ExplorePage(navController) }
        composable("contact_us") { ContactUsScreen(navController) }
        composable("about_us") { AboutUsScreen(navController) }
        composable("create_event") { CreateEventScreen(navController) }
        composable("registration_success") { RegistrationSuccessScreen(navController) }
        composable("event_registration") { EventRegistraion(navController) }
        composable("event_created_successfully") { EventVerificationScreen(navController) }
        composable("terms_conditions") { TermsAndConditionsScreen(navController) }
        composable("privacy_policy") { privacyPolicy(navController) }
        composable("screen_not_found"){ ScreenNotFound(navController) }


        composable(
            "eventDetail/{eventTitle}",
            arguments = listOf(navArgument("eventTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventTitle = backStackEntry.arguments?.getString("eventTitle")

            val event = Event.getEventByTitle(eventTitle)

            if (event != null) {
                EventDetailScreen(event, navController)
            } else {
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
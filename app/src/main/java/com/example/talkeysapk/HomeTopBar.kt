package com.example.talkies.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.talkeysapk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(navController: NavController) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black, // Ensure black background always
            titleContentColor = Color.White
        ),
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(75.dp)
                    .fillMaxHeight()
                    .clickable {
                        navController.navigate("home") // Navigate to home when clicked
                    })
        },
        title = { /* Empty because logo is in navigationIcon now */ },
        actions = {
            // Chat Icon - Increased Size
            IconButton(onClick = { /* Handle chat click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat), // Replace with chat icon
                    contentDescription = "Chat",
                    modifier = Modifier.size(30.dp) // Larger chat icon
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.profile_image), // Replace with profile image
                contentDescription = "Profile",
                modifier = Modifier
                    .size(44.dp) // Adjusted for visibility
                    .clip(CircleShape)
            )
        },
        modifier = Modifier.fillMaxWidth() // Ensures it stretches across the screen
    )
}


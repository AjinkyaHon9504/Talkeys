package com.example.talkeysapk

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import androidx.navigation.compose.rememberNavController
import com.example.talkies.ui.HomeTopBar
import kotlinx.coroutines.delay

@Composable
fun EventDetailScreen(event: Event,navController: NavController) {
    var selectedItem by remember { mutableStateOf("Details") }

    val items = listOf(
        "Details", "Dates & Deadlines", "Subheading X", "Prizes", "Link to Community"
    )

    val reorderedItems = remember(selectedItem) {
        listOf(selectedItem) + items.filter { it != selectedItem }
    }

    Scaffold(
        topBar = { HomeTopBar(navController = navController) } // ✅ Keeps TopBar fixed
    ) {paddingValues ->
        Box(
            modifier = Modifier.
            fillMaxSize().
            padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            LazyColumn(modifier = Modifier.fillMaxSize(),contentPadding = PaddingValues(bottom = 100.dp)) {
                item {
                    Card(
                        modifier = Modifier
                            .width(418.dp)
                            .height(266.66501.dp)
                            .padding(top = 34.dp, start = 20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            EventCard1(
                                title = event.title,
                                location = event.location,
                                imageRes = event.imageRes
                            )
                            Column {
                                Text(
                                    text = event.title,
                                    style = TextStyle(
                                        fontSize = 22.sp,
                                        fontFamily = FontFamily(Font(R.font.urbanist_bold)), // Bold for event name
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                EventDetailRow(R.drawable.college, event.category) // Use category as college name
                                Spacer(modifier = Modifier.height(10.dp))
                                EventDetailRow(R.drawable.ic_location, event.location) // Use event location dynamically
                                Spacer(modifier = Modifier.height(10.dp))
                                EventDetailRow(R.drawable.event_date,event.date) // Replace with event date if available
                                Spacer(modifier = Modifier.height(10.dp))
                                EventDetailRow(R.drawable.trophy, event.festName.toString()) // Update with fest name if available
                            }
                        }
                    }
                }

                item { Spacer(modifier = Modifier.height(5.33.dp)) }

                item {
                    EventInfoBox(navController=navController)
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    SelectionBar(items, selectedItem) { selectedItem = it }
                    Spacer(modifier = Modifier.height(33.dp))
                }

                val highlightColor = Color(0xFF8A44CB) // Highlight color
                val normalColor = Color(0xFF171717) // Default color

                items(reorderedItems) { item ->
                    val isHighlighted = item == selectedItem
                    var showHighlight by remember { mutableStateOf(isHighlighted) }

                    // Animate color change
                    val backgroundColor by animateColorAsState(
                        targetValue = if (showHighlight) highlightColor else normalColor,
                        animationSpec = tween(durationMillis = 500),
                        label = "Card Background Animation"
                    )

                    LaunchedEffect(selectedItem) {
                        if (isHighlighted) {
                            showHighlight = true // Show highlight
                            delay(2000) // Keep highlight for a moment
                            showHighlight = false // Revert color after delay
                        }
                    }

                    InfoCard1(
                        title = item,
                        content = "Lorem ipsum",
                        backgroundColor = backgroundColor // Pass animated color
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                }
                item { Footer(navController = rememberNavController()) }
            }

            BottomBar(
                navController,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(), scrollState = rememberScrollState()
            )

        }
    }
}

@Composable
fun SelectionBar(items: List<String>, selectedItem: String, onSelect: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFF2E2E2E), shape = RoundedCornerShape(20.dp))
            .padding(8.dp)
    ) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(items) { item ->
                SelectionItem(
                    text = item,
                    isSelected = item == selectedItem,
                    onClick = { onSelect(item) }
                )
            }
        }
    }
}

@Composable
fun SelectionItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(
                if (isSelected) Color(0xFF8A44CB) else Color(0xFF444444),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun InfoCard1(title: String, content: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .width(340.dp)
            .height(100.dp)
            .padding(start = 32.dp) // Push card to 32.dp from left
            .background(Color(0xFF171717), shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 20.dp, vertical = 12.dp) // Adjusted padding to prevent cutoff
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            VerticalIndicator1() // Vertical bar inside the card
            Spacer(modifier = Modifier.width(8.dp)) // Space between indicator and title

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                ),
                modifier = Modifier.fillMaxWidth() // Prevent title text from getting cut off
            )
        }

        Spacer(modifier = Modifier.height(8.dp)) // Adjusted space between title and description

        Text(
            text = content,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight.Light,
                color = Color.White
            ),
            modifier = Modifier.fillMaxWidth() // Prevent text clipping
        )
    }
}


@Composable
fun EventDetailText(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 22.sp, color = Color.White),
        modifier = Modifier.width(121.dp).height(26.dp)
    )
}

@Composable
fun EventDetailRow(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)), // Regular for details
                fontWeight = FontWeight.Normal,
                color = Color.White
            ),
            modifier = Modifier.width(234.dp).height(19.dp)
        )
    }
}

@Composable
fun EventCard1(title: String, location: String, imageRes: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .width(150.dp)
            .height(266.66501.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Composable
fun VerticalIndicator1() {
    Box(
        modifier = Modifier
            .width(5.dp)
            .height(39.dp)
            .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(50.dp))
    )
}

@Composable
fun EventInfoBox(modifier: Modifier = Modifier, navController: NavController) {
    var isLiked by remember { mutableStateOf(false) }
    var likeCount by remember { mutableIntStateOf(183) } // Initial like count
    val replyCount = 8 // Example reply count

    Card(
        modifier = modifier
            .width(370.dp)
            .height(241.dp)
            .padding(start = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF171717), shape = RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Row containing "Cost for Event" and icons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // "Cost for Event" text
                    Text(
                        text = "Cost for Event",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    )

                    // Icons Row
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // ✅ Like Button with Like Count
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_like),
                                contentDescription = "Like",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        isLiked = !isLiked
                                        likeCount += if (isLiked) 1 else -1
                                    },
                                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                                    if (isLiked) Color.Red else Color.White
                                )
                            )
                            Text(
                                text = "$likeCount likes",
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }

                        // ✅ Comment Icon
                        IconWithText(R.drawable.ic_comment, "•") // Comment icon with no text

                        // ✅ Share Button
                        IconWithText(R.drawable.ic_share, "$replyCount replies")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Register Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    RegisterButton(navController = navController)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Dashed Line Divider
                Image(
                    painter = painterResource(id = R.drawable.divider_line),
                    contentDescription = "Divider Line",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(320.dp)
                        .height(2.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Event Tags
                EventTags()
            }
        }
    }
}


@Composable
fun EventTags() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // First Row (Aligned Right)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            EventTag("Event Tag")
            Spacer(modifier = Modifier.width(12.dp))
            EventTag("Event Tag")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Second Row (Aligned Left)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            EventTag("Bigger Event Tag", isBigger = true)
            Spacer(modifier = Modifier.width(12.dp))
            EventTag("Event Tag")
        }
    }
}

@Composable
fun IconWithText(iconRes: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Center icon and text
        verticalArrangement = Arrangement.spacedBy(2.dp) // Space between icon and text
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Icon",
            modifier = Modifier.size(20.dp)
        )
        if (text.isNotBlank()) { // Avoids unnecessary empty space
            Text(
                text = text,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_light)),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun EventTag(text: String, isBigger: Boolean = false) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFCCA1F4),
                shape = RoundedCornerShape(size = 27.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .then(
                if (isBigger) Modifier.width(149.dp).height(25.dp)
                else Modifier.width(104.dp).height(25.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFCCA1F4)
            )
        )
    }
}

@Composable
fun RegisterButton(navController: NavController) {
    Box(
        modifier = Modifier
            .width(133.dp)
            .height(39.dp)
            .background(Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
            .clickable { navController.navigate("event_registration")}
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Register Now",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

import com.example.talkies.ui.HomeTopBar

@Composable
fun CommunityInfo(navController: NavController,community: HomePageCommunity) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                HomeTopBar()
                Spacer(modifier = Modifier.height(22.dp))
            }

            item {
                Box(
                    modifier = Modifier
                        .width(360.dp)
                        .height(84.dp)
                ) {
                    // Banner Image
                    Image(
                        painter = painterResource(id = R.drawable.community_banner),
                        contentDescription = "Community Banner",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .matchParentSize()  // Ensure it takes the full size of the parent
                            .clip(RoundedCornerShape(8.dp)) // Clip the corners
                    )
                }

                // Spacer to create a gap of 8.dp
                Spacer(modifier = Modifier.height(8.dp))

                // Chatroom Name & Member Count positioned BELOW the image
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = community.name,
                        // H5/SemiBold
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        ),
                        modifier = Modifier.alignByBaseline()
                    )
                    Text(
                        text = "Member Count",
                        // Body/Regular
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                        ),
                        modifier = Modifier.alignByBaseline()
                    )
                }

                // Spacer after texts
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End // Aligns content to the right
                ) {
                    Button(
                        onClick = { /* TODO: Handle Join Action */ },
                        modifier = Modifier
                            .width(154.dp)
                            .height(39.dp)
                            .padding(end = 16.dp), // Match the right border of the image
                        shape = RoundedCornerShape(size = 8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A44CB)) // Apply full color to button
                    ) {
                        Text(
                            text = "Join Community",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontWeight = FontWeight.Medium,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }




            // Cards List
            val infoCards = listOf(
                "Chatroom Description" to community.description,
                "Rules & Regulations" to "Lorem ipsum dolor sit amet consectetur. Fringilla enim nisi vel maecenas non ac. Integer adipiscing est viverra adipiscing. Aliquet fermentum leo arcu ullamcorper non amet. Arcu praesent proin erat massa laoreet. Consectetur eli\n" +
                        "\n" +
                        "t morbi sit vulputate nullam risus volutpat id vitae. Arcu vel at id velit pulvinar dolor amet praesent mi. A pharetra nunc enim egestas diam ipsum.\n" +
                        "Auctor id enim sollicitudin augue laoreet amet nisi velit sollicitudin. Turpis eu in ornare et purus lacus erat integer eu. Rutrum cras eget vestibulum bibendum varius. Diam ullamcorper consectetur placerat libero. Mus consectetur tempus viverra aliquet.",
                "Host Details" to "lorem ipsum"
            )

            items(infoCards) { (title, content) ->
                InfoCard(title = title, content = content)
                Spacer(modifier = Modifier.height(22.dp))
            }

            item {
                // Card for Related Events
                Box(
                    modifier = Modifier
                        .width(340.dp)
                        .height(420.dp)
                        .background(color = Color(0xFF171717), shape = RoundedCornerShape(10.dp))
                        .padding(20.dp) // Padding inside the card
                ) {
                    Column {
                        // Title with Vertical Indicator
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            VerticalIndicator()
                            Spacer(modifier = Modifier.width(8.dp)) // Space between indicator and text

                            Text(
                                text = "Related Events",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp)) // Space before events


                        EventRow(
                            events = listOf(
                                Event("Sunday Salsa", "Downtown Club",  R.drawable.ic_eventbanner,"Dance"),
                                Event("Chess Meetup", "City Library",  R.drawable.ic_eventbanner,"Board Games"),
                                Event("Karaoke Night", "Music Lounge",  R.drawable.ic_eventbanner,"Music")
                            ),
                            navController = navController
                        )
                    }
                }
            }


            item{
                Spacer(modifier = Modifier.height(28.33.dp))
                Footer(navController = navController)
            }
        }
    }
}

@Composable
fun InfoCard(title: String, content: String) {
    Column(
        modifier = Modifier
            .width(340.dp)
            .background(Color(0xFF171717), shape = RoundedCornerShape(4.dp))
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            VerticalIndicator() // Vertical bar inside the card
            Spacer(modifier = Modifier.width(8.dp)) // Space between indicator and title

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = content,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        )
    }
}



@Composable
fun VerticalIndicator() {
    Box(
        modifier = Modifier
            .width(5.dp)
            .height(39.dp)
            .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(size = 50.dp))
    )
}
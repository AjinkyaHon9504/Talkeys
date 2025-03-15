package com.example.talkeysapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

class EventDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve event details from intent
        val eventTitle = intent.getStringExtra("eventTitle") ?: "Unknown Event"
        val eventLocation = intent.getStringExtra("eventLocation") ?: "Unknown Location"
        val eventImageRes = intent.getIntExtra("eventImageRes", R.drawable.ic_eventbanner)

        val eventCategory = intent.getStringExtra("eventCategory") ?: "Other" // Default category
        val event = Event(eventTitle, eventLocation, eventImageRes, eventCategory)


        setContent {
            EventDetailScreen( event,navController = null) // Pass the event object
        }
    }
}
@Composable
fun EventDetailScreen(event: Event, navController: NavController? = null) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        HomeTopBar()

        Image(
            painter = painterResource(id = event.imageRes),
            contentDescription = event.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Text(
            text = event.title,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                color = Color.White
            ),
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = event.location,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                color = Color.LightGray
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Event Details",
            color = Color.White,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
// Event Details Row
@Composable
fun EventDetailItem(iconRes: Int, text: String, fontSize: TextUnit, fontWeight: FontWeight) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = fontWeight,
                color = Color.White
            )
        )
    }
}

// Event Information Box
@Composable
fun EventInfoBox() {
    Box(
        modifier = Modifier
            .width(370.dp)
            .height(241.dp)
            .background(Color(0xFF171717), shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Entry Fee: Free",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(21.dp))

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                IconWithText(R.drawable.ic_like, "100")
                IconWithText(R.drawable.ic_comment, "50")
                IconWithText(R.drawable.ic_share, "30")
            }

            Spacer(modifier = Modifier.height(16.dp))

            RegisterButton()
        }
    }
}

// Icon with Text (Like, Comment, Share)
@Composable
fun IconWithText(iconRes: Int, count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Icon",
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = count, color = Color.White, fontSize = 14.sp)
    }
}

// Register Now Button
@Composable
fun RegisterButton() {
    Box(
        modifier = Modifier
            .width(133.dp)
            .height(39.dp)
            .background(Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
            .clickable { }
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
@Composable
fun EventTags() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        EventTag("Tech Fest")
        EventTag("Workshop")
        EventTag("Hackathon")
        EventTag("Gaming")
    }
}

@Composable
fun EventTag(tag: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color(0xFFCCA1F4), RoundedCornerShape(27.dp))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = tag, color = Color(0xFFCCA1F4), fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

// Tab Bar
@Composable
fun EventTabs(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        modifier = Modifier
            .width(602.dp)
            .height(39.dp)
            .background(Color(0xFF262626), shape = RoundedCornerShape(50.dp))
            .padding(6.dp)
    ) {
        listOf("Details", "Dates & Deadlines", "Subheading x", "Prizes").forEach { tab ->
            Text(
                text = tab,
                color = if (tab == selectedTab) Color(0xFFCCA1F4) else Color.White,
                fontSize = 16.sp,
                modifier = Modifier.clickable { onTabSelected(tab) }
            )
        }
    }
}

// Event Section Content
@Composable
fun EventSectionContent(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        modifier = Modifier.padding(16.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewEventDetailScreen() {
    val sampleEvent = Event(
        title = "Tech Fest 2025",
        location = "Silicon Valley, CA",
        imageRes = R.drawable.ic_eventbanner,
        category = "Technology"
    )

    EventDetailScreen(event = sampleEvent)
}
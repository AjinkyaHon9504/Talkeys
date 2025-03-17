package com.example.talkeysapk
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun CreateEventScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fallback color
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            HomeTopBar()

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "Create Event",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    color = Color.White
                ),
                modifier = Modifier
                    .width(198.dp)
                    .height(41.dp)
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(27.dp))

            repeat(10) { index ->
                EventInputField(label = "Detail ${index + 1}")
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .padding(start=85.dp)
                        .width(150.dp)
                        .height(39.dp)
                        .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
                        .clickable { /* Navigate to event creation */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Create Event",
                        fontSize = 16.sp,
                        color = Color.White,
                    )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Footer(navController=navController)
        }
    }
}

@Composable
fun EventInputField(label: String) {
    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 27.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        var textState by remember { mutableStateOf(TextFieldValue("")) }

        Box(
            modifier = Modifier
                .width(327.dp)
                .height(45.dp)
                .background(Color(0xFF262626), shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            BasicTextField(
                value = textState,
                onValueChange = { textState = it },
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
            )
        }
    }
}

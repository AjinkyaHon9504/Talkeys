package com.example.talkeysapk

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Dark textured background
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title container with proper alignment
            Box(
                modifier = Modifier
                    .width(317.dp)
                    .padding(top = 80.dp)
            ) {
                // Welcome Text aligned to the left
                Text(
                    text = "Welcome\nBack!",
                    style = TextStyle(
                        fontSize = 40.sp,
                        lineHeight = 48.sp,
                        fontFamily = FontFamily(Font(R.font.domine)),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    ),
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Username Field
            CustomOutlinedTextField1(
                placeholderText = "Username or Email",
                leadingIcon = R.drawable.user
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Password Field
            CustomOutlinedTextField1(
                placeholderText = "Password",
                leadingIcon = R.drawable.lock,
                trailingIcon = R.drawable.eye,
                isPassword = true
            )

            // Forgot Password with proper alignment
            Box(
                modifier = Modifier
                    .width(317.dp)
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFF83758),
                    ),
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Login Button
            Box(
                modifier = Modifier
                    .width(317.dp)
                    .height(55.dp)
                    .background(color = Color(0xFF9B51E0), shape = RoundedCornerShape(size = 4.dp))
                    .clickable { /* Handle login action */ },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }
    }
}

// Custom Outlined TextField - same as in SignUpScreen for consistency
@Composable
fun CustomOutlinedTextField1(
    placeholderText: String,
    leadingIcon: Int,
    trailingIcon: Int? = null,
    isPassword: Boolean = false
) {
    val text = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center // Center the field in the screen
    ) {
        // Custom TextField using Box and basic components
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color(0xFF9C27B0), shape = RoundedCornerShape(size = 10.dp))
                .width(317.dp)
                .height(55.dp)
                .background(color = Color(0xFF111111), shape = RoundedCornerShape(size = 10.dp))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Leading Icon
                Image(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Text Field
                BasicTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans))
                    ),
                    visualTransformation = if (isPassword && !passwordVisible.value)
                        PasswordVisualTransformation() else VisualTransformation.None,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (text.value.isEmpty()) {
                                Text(
                                    text = placeholderText,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.open_sans)),
                                        fontWeight = FontWeight.Normal,
                                        color = Color(0xFFAAAAAA),
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                // Trailing Icon
                trailingIcon?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = if (isPassword) "Toggle password visibility" else null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                if (isPassword) {
                                    passwordVisible.value = !passwordVisible.value
                                }
                            }
                    )
                }
            }
        }
    }
}
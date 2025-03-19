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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {
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
            // Use the same width constraint as the text fields
            Box(
                modifier = Modifier
                    .width(317.dp)
                    .padding(top = 80.dp)
            ) {
                // Title - now aligned with the Box's left edge
                Text(
                    text = "Create an\naccount",
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 43.sp,
                        fontFamily = FontFamily(Font(R.font.domine)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFF5F5F5),
                    ),
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Username Field
            CustomOutlinedTextField(
                placeholderText = "Username or Email",
                leadingIcon = R.drawable.user
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Password Field
            CustomOutlinedTextField(
                placeholderText = "Password",
                leadingIcon = R.drawable.lock,
                trailingIcon = R.drawable.eye,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Confirm Password Field
            CustomOutlinedTextField(
                placeholderText = "ConfirmPassword",
                leadingIcon = R.drawable.lock,
                trailingIcon = R.drawable.eye,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Terms & Conditions Text - now aligned with the custom text field
            Box(
                modifier = Modifier
                    .width(317.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("By clicking the ")
                            withStyle(style = SpanStyle(color = Color(0xFFFF0044))) {
                                append("Register")
                            }
                            append(" button, you agree")
                        },
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                    Text(
                        text = "to the public offer",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Create Account Button
            Button(
                onClick = { /* Handle click action */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, // Removes button background color
                    contentColor = Color.Unspecified    // Ensures text color is used instead of default
                ),
                elevation = null ,// Removes button shadow
                modifier = Modifier
                    .width(317.dp)
                    .height(55.dp)
                    .background(color = Color(0xFF9B51E0), shape = RoundedCornerShape(size = 4.dp))
            ) {
                Text(
                    text = "Create Account",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // OR Continue With
            Text(
                text = "- OR Continue with -",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Social Media Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialIconButton(R.drawable.google_icon)
                SocialIconButton(R.drawable.apple_icon)
                SocialIconButton(R.drawable.facebook_icon)
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Already Have an Account
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "I Already Have an Account ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
                Button(
                    onClick = { navController.navigate("login") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // Removes button background color
                        contentColor = Color.Unspecified    // Ensures text color is used instead of default
                    ),
                    contentPadding = PaddingValues(0.dp),
                    elevation = null // Removes button shadow
                ) {
                    Text(
                        text = "Login",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFF83758),
                            textAlign = TextAlign.Center,
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CustomOutlinedTextField(
    placeholderText: String,
    leadingIcon: Int,
    trailingIcon: Int? = null,
    isPassword: Boolean = false,
) {
    val text = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(317.dp)
                .height(55.dp)
                .border(width = 1.dp, color = Color(0xFF9C27B0), shape = RoundedCornerShape(size = 10.dp))
                .background(color = Color(0xFF111111), shape = RoundedCornerShape(size = 10.dp))
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
                val transformation = if (isPassword && !passwordVisible.value)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BasicTextField(
                        value = text.value,
                        onValueChange = { text.value = it },
                        singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.open_sans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF676767),
                            textAlign = TextAlign.Center
                        ),
                        visualTransformation = transformation,
                        modifier = Modifier.fillMaxWidth(),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier.fillMaxWidth(),
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
                }

                // Trailing Icon
                if (trailingIcon != null) {
                    Image(
                        painter = painterResource(id = trailingIcon),
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


// Social Media Button
@Composable
fun SocialIconButton(icon: Int) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(width = 1.dp, color = Color(0xFF9C27B0), shape = RoundedCornerShape(30.dp))
            .background(color = Color.White, shape = RoundedCornerShape(30.dp))
            .clickable { /* Handle social login */ },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}
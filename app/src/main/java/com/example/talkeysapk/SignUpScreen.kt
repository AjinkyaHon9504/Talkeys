package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Title
            Text(
                text = "Create an\naccount",
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(700),
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Username/Email field
            var username by remember { mutableStateOf("") }
            CustomOutlinedTextField(
                placeholderText = "Username or Email",
                leadingIcon = R.drawable.user
            )
            Spacer(modifier = Modifier.height(16.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    append("By clicking the ")
                    withStyle(style = SpanStyle(color = Color(0xFFFF0044))) {
                        append("Register")
                    }
                    append(" button, you agree to the public offer")
                },
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFAAAAAA)
                )
            )
//            Text(
//                text = "to the public offer",
//                style = TextStyle(
//                    fontSize = 12.sp,
//                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
//                    fontWeight = FontWeight.Normal,
//                    color = Color(0xFFAAAAAA)
//                )
//            )
            Spacer(modifier = Modifier.height(30.dp))

            // Create Account Button
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB768FF)
                )
            ) {
                Text(
                    text = "Create Account",
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Or continue with
            Text(
                text = "- OR CONTINUE WITH -",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Social login buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialIconButton(R.drawable.google_icon)
                Spacer(modifier = Modifier.width(24.dp))
                SocialIconButton(R.drawable.apple_icon)
                Spacer(modifier = Modifier.width(24.dp))
                SocialIconButton(R.drawable.ic_facebook_icon)
            }
            Spacer(modifier = Modifier.padding(10.dp))

            // Already have an account
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "I Already Have an Account",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Normal,
                )
                TextButton(onClick = {navController.navigate("login")}) {
                    Text(
                        text = "Login",
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFF83758),
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
                .border(
                    width = 1.dp,
                    color = Color(0xFF9C27B0),
                    shape = RoundedCornerShape(size = 10.dp)
                )
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
@Composable
fun SocialIconButton(icon: Int) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable { /* Handle social login */ },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}


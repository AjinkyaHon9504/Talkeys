package com.example.talkeysapk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkeysapk.R
import com.example.talkies.ui.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Fixed TopBar
        HomeTopBar(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable content using Column with verticalScroll
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            // Terms Of Service Title
            Text(
                text = "Terms Of Service",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            )


            Spacer(modifier = Modifier.height(67.dp))

            Text(
                text = "Welcome to Talkeys! Before you dive in, it's important to understand the terms and conditions under which we operate. By using Talkeys, you agree to the following terms. Let’s work together to make this platform a great space for everyone.\n" +
                        "\n" +
                        "1. Introduction\n" +
                        "Talkeys is a platform that connects people through communities and events. Our mission is to help users discover, engage, and participate in various communities while offering a space for event creators to host and share their events with a global audience.\n" +
                        "These Terms of Service govern your use of our platform. By using Talkeys, you agree to comply with these terms. If you don’t agree, please refrain from using our services.\n" +
                        "Note: Talkeys is solely a ticketing platform. We do not organize or manage events listed on our platform.\n" +
                        "\n" +
                        "2. Eligibility\n" +
                        "To use Talkeys, you must be at least 13 years old (or older, depending on your local laws). By using the platform, you represent that you are legally permitted to use Talkeys and are responsible for complying with all applicable laws and regulations.\n" +
                        "\n" +
                        "3. Creating an Account\n" +
                        "To access certain features of Talkeys, you’ll need to create an account. When you sign up, please provide accurate information and keep your account secure. You are responsible for all activity that happens through your account, so please choose a strong password and keep it private.\n" +
                        "We reserve the right to suspend or terminate your account if we detect any breach of these terms.\n" +
                        "\n" +
                        "4. Community Guidelines\n" +
                        "We believe in fostering a positive and respectful environment for all users. As such, when participating in community chats, forums, or events, please abide by the following guidelines:\n" +
                        "Respect others: No harassment, hate speech, or abusive behavior will be tolerated.\n" +
                        "Keep it legal: Do not share any illegal content or engage in illegal activities.\n" +
                        "No spamming: Refrain from unsolicited promotions, advertising, or irrelevant content.\n" +
                        "Any violation of these guidelines may result in a suspension or ban from Talkeys.\n" +
                        "\n" +
                        "5. User-Generated Content\n" +
                        "At Talkeys, you have the opportunity to create and share content (e.g., messages, event listings, posts). By doing so, you retain ownership of your content, but you also grant us a license to use, display, and promote it on our platform.\n" +
                        "We are not responsible for the content shared by users, but we reserve the right to remove any content that violates these terms or our community guidelines.\n" +
                        "\n" +
                        "6. Event Hosting\n" +
                        "One of the most exciting features of Talkeys is the ability to create and host events. As an event host, you are responsible for the accuracy and content of your event listing. Please ensure your event follows our guidelines and complies with all applicable laws.\n" +
                        "Important: Talkeys does not promote alcohol consumption or endorse any specific activities at events. We solely provide a ticketing platform to connect users with events.\n" +
                        "\n" +
                        "7. Intellectual Property\n" +
                        "All content, design, branding, and features on Talkeys are the intellectual property of Talkeys or our licensors. You may not copy, reproduce, or distribute any part of Talkeys without prior permission.\n" +
                        "That said, any content you create on Talkeys remains yours, and we’re excited to see what you build!\n" +
                        "\n" +
                        "8. Privacy\n" +
                        "Your privacy is incredibly important to us. Please refer to our Privacy Policy for details on how we collect, store, and use your personal data.\n" +
                        "\n" +
                        "9. Prohibited Activities\n" +
                        "We are committed to creating a safe, enjoyable experience for everyone. Certain behaviors are strictly prohibited on Talkeys, including:\n" +
                        "Engaging in unlawful activities or promoting illegal content.\n" +
                        "Using the platform for fraudulent purposes.\n" +
                        "Sharing offensive, obscene, or otherwise inappropriate content.\n" +
                        "Impersonating others or misrepresenting your identity.\n" +
                        "Failure to comply may result in account suspension or termination.\n" +
                        "\n" +
                        "10. Liability Disclaimer\n" +
                        "While we strive to provide the best possible experience on Talkeys, we do not guarantee that everything will always function perfectly. We are not responsible for:\n" +
                        "Downtime, interruptions, or data loss.\n" +
                        "Any issues arising from user-generated content or third-party events.\n" +
                        "The success or outcome of any event hosted on our platform.\n" +
                        "You use Talkeys at your own risk.\n" +
                        "\n" +
                        "11. Termination of Services\n" +
                        "You may close your account at any time. We also reserve the right to terminate or suspend accounts that violate our terms or pose risks to the community. We will notify you if your account is at risk of termination unless you’ve engaged in serious violations that require immediate action.\n" +
                        "\n" +
                        "12. Changes to the Terms\n" +
                        "We may update these terms periodically. If we make changes, we will notify you through the platform or via email. Your continued use of Talkeys following any changes means that you accept the new terms.\n" +
                        "\n" +
                        "13. Contact Us\n" +
                        "If you have any questions about these Terms of Service, please contact us at: \n" +
                        "Talkeys11@gmail.com\n" +
                        "\n" +
                        "Thank you for being a part of the Talkeys community. We can’t wait to see what you create, and we’re thrilled to have you on board!\n" +
                        "\n" +
                        "Sincerely,\nTeam Talkeys", // Truncated for readability
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(81.dp))

            Footer(navController = navController)
        }
    }
}

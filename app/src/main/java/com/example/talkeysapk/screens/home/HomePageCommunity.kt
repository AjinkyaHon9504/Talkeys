package com.example.talkeysapk.screens.home

import com.example.talkeysapk.R

data class HomePageCommunity(val name: String, val imageRes: Int, val description: String)

object CommunityData {
    data class CommunityCategory(val name: String, val communities: List<HomePageCommunity>)

    private val communities = listOf(
        HomePageCommunity(
            name = "Music Lovers",
            imageRes = R.drawable.ic_community_card,
            description = "Join a community of passionate music enthusiasts who love to explore different genres, share their favorite songs, and discuss the latest trends in the music industry. Whether you are a fan of classical, rock, pop, jazz, or hip-hop, this group welcomes everyone with open arms. Engage in discussions about iconic artists, upcoming albums, and live concerts. Share playlists, discover hidden musical gems, and even collaborate with fellow musicians. Whether you're a singer, instrumentalist, or just an avid listener, there's a place for you in this dynamic and harmonious community."
        ),

        HomePageCommunity(
            name = "Chess Masters",
            imageRes = R.drawable.ic_community_card,
            description = "Welcome to the Chess Masters community! Whether you're a beginner looking to learn the basics or a grandmaster aiming to refine your strategy, this group is the perfect place for you. Engage in deep discussions on famous chess openings, middle-game tactics, and endgame techniques. Participate in friendly matches, share puzzles, and analyze historic games played by legends like Magnus Carlsen and Garry Kasparov. Stay updated with the latest chess tournaments and sharpen your skills through interactive lessons and tips from experienced players. If chess is your passion, you've found your home!"
        ),

        HomePageCommunity(
            name = "Tech Innovators",
            imageRes = R.drawable.ic_community_card,
            description = "This community is a hub for tech enthusiasts, software developers, engineers, and entrepreneurs who are passionate about the ever-evolving world of technology. Discuss groundbreaking innovations in artificial intelligence, blockchain, cybersecurity, and the latest advancements in gadgets and software development. Share coding tips, explore new programming languages, and collaborate on exciting tech projects. Whether you’re into web development, machine learning, or hardware engineering, this is the perfect place to connect with like-minded individuals, stay ahead of tech trends, and be part of a group shaping the future of technology."
        ),

        HomePageCommunity(
            name = "Photography Club",
            imageRes = R.drawable.ic_community_card,
            description = "Join a vibrant community of photography lovers where creativity meets storytelling. Share your best shots, receive constructive feedback, and learn new techniques to enhance your skills. Whether you're into portrait photography, landscapes, street photography, or macro shots, this is the place for you. Discuss camera gear, lighting setups, composition rules, and editing software like Photoshop and Lightroom. Participate in photography challenges and showcase your work to inspire others. Whether you're a beginner or a professional photographer, this community will help you see the world through a different lens!"
        ),

        HomePageCommunity(
            name = "Book Readers",
            imageRes = R.drawable.ic_community_card,
            description = "A paradise for book lovers! This community brings together readers from all walks of life who share a passion for literature. Discover new book recommendations, discuss your favorite authors, and take part in lively debates on different genres, from fiction and fantasy to self-help and biographies. Engage in monthly book challenges and exchange reviews with fellow members. Whether you love classic novels, modern bestsellers, or indie publications, this group offers a space to connect, share insights, and deepen your love for reading. Join us and immerse yourself in the world of books!"
        ),

        HomePageCommunity(
            name = "Travel Explorers",
            imageRes = R.drawable.ic_community_card,
            description = "For those who have an insatiable wanderlust, this is the perfect place! Share your travel experiences, discover breathtaking destinations, and get insider tips on budget travel, hidden gems, and must-visit locations. Whether you're a backpacker, solo traveler, or someone who loves luxurious getaways, you'll find plenty of inspiration here. Discuss everything from travel hacks and visa processes to local cuisines and cultural experiences. Connect with like-minded travelers, plan group trips, and turn your travel dreams into reality. Adventure awaits—let’s explore the world together!"
        ),

        HomePageCommunity(
            name = "Foodies Unite",
            imageRes = R.drawable.ic_community_card,
            description = "Food lovers, rejoice! This community is dedicated to all things delicious. Whether you're passionate about home-cooked meals, fine dining, street food, or exotic cuisines, this is the place to share recipes, restaurant recommendations, and cooking tips. Discuss food trends, nutrition, and dietary lifestyles like veganism and keto. Participate in food challenges, exchange culinary secrets, and discover new flavors from around the world. Whether you're a professional chef or just someone who enjoys a good meal, this group will satisfy your appetite for all things food!"
        ),

        HomePageCommunity(
            name = "Fitness Enthusiasts",
            imageRes = R.drawable.ic_community_card,
            description = "Stay fit, stay strong! This community is for people dedicated to health and wellness. Share workout routines, nutrition tips, and motivation to keep pushing toward your fitness goals. Whether you're into weightlifting, yoga, running, or bodyweight training, you'll find plenty of support and advice here. Discuss the latest fitness trends, sports science, and recovery techniques. Engage in fitness challenges and inspire others with your progress. From beginners to seasoned athletes, everyone is welcome to join the journey toward a healthier lifestyle!"
        ),

        HomePageCommunity(
            name = "Art Lovers",
            imageRes= R.drawable.ic_community_card,
            description = "A place for creators and art admirers to connect and celebrate creativity. Share your artwork, get feedback, and explore different forms of artistic expression—painting, sketching, digital art, sculpting, and more. Discuss famous artists, art history, and modern trends in the art world. Participate in art challenges, learn new techniques, and collaborate with fellow artists. Whether you're a professional artist or just love to admire beautiful creations, this community will inspire you and help you refine your artistic skills!"
        ),

        HomePageCommunity(
            name = "Dance Squad",
            imageRes = R.drawable.ic_community_card,
            description = "Get ready to move! This community is for dancers of all styles—hip-hop, salsa, ballet, contemporary, and more. Share your dance routines, learn new techniques, and get inspired by performances from around the world. Connect with fellow dancers, exchange choreography ideas, and find dance partners for collaborations. Whether you're a beginner or an experienced dancer, this group is full of energy, creativity, and passion for movement. Let’s dance our way to greatness!"
        ),

        HomePageCommunity(
            name = "Book Club",
            imageRes = R.drawable.ic_community_card,
            description = "A cozy space for bookworms who love deep discussions on literature. Participate in book-of-the-month readings, share your favorite quotes, and recommend must-read novels. From classics to contemporary fiction, poetry to philosophy, this club welcomes all genres. Engage in literary debates, connect with fellow readers, and discover books that will change your perspective on life. Whether you enjoy slow reads or binge-reading entire series, this community will be your haven for all things books!"
        )
    )

    fun getCommunityByName(name: String): HomePageCommunity? {
        return communities.find { it.name == name }
    }


    // Define categories
    private val categories = listOf(
        CommunityCategory("Entertainment & Arts", communities.take(4)),
        CommunityCategory("Lifestyle & Wellness", communities.drop(4).take(4)),
        CommunityCategory("Hobbies & Learning", communities.drop(8).take(4))
    )

    fun getAllCategories(): List<CommunityCategory> = categories
    fun getAllCommunities(): List<HomePageCommunity> = communities
}

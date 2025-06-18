package com.example.talkeysapk.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class Event(
    val _id: String,
    val title: String,
    val description: String,
    val location: String,
    val date: String,
    val category: String,
    val festName: String?,
    val cost: Double,
    val imageUrl: String?,
    val tags: List<String>,
    val likes: Int,
    val isLiked: Boolean = false,
    val comments: Int = 0,
    // Add imageRes for local compatibility
    val imageRes: Int = com.example.talkeysapk.R.drawable.ic_eventbanner
)
data class EventListResponse(
    val success: Boolean,
    val message: String,
    val data: List<Event>
)

data class EventsUiState(
    val events: List<Event> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val techEvents: List<Event> = emptyList(),
    val musicEvents: List<Event> = emptyList(),
    val sportsEvents: List<Event> = emptyList()
)

data class EventDetailUiState(
    val event: Event? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLiked: Boolean = false,
    val likeCount: Int = 0)


data class EventDetailResponse(
    val success: Boolean,
    val message: String,
    val data: Event
)

data class User(
    val id: String,
    val email: String,
    val name: String
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)

data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T?
)

data class PassBookingRequest(
    val eventId: String,
    val userId: String
)

data class TeamRequest(
    val teamName: String,
    val eventId: String
)

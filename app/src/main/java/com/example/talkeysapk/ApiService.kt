package com.example.talkeysapk

import com.example.talkeysapk.data.model.ApiResponse
import com.example.talkeysapk.data.model.EventDetailResponse
import com.example.talkeysapk.data.model.EventListResponse
import com.example.talkeysapk.data.model.LoginRequest
import com.example.talkeysapk.data.model.PassBookingRequest
import com.example.talkeysapk.data.model.RegisterRequest
import com.example.talkeysapk.data.model.TeamRequest
import com.example.talkeysapk.data.model.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Public endpoints (no auth required)
    @GET("getEvents")
    suspend fun getEvents(): Response<EventListResponse>

    @GET("getEventById/{id}")
    suspend fun getEventById(@Path("id") eventId: String): Response<EventDetailResponse>

    @POST("verify")
    suspend fun login(@Body loginRequest: LoginRequest): Response<ApiResponse<User>>

    @GET("logout")
    suspend fun logout(): Response<ApiResponse<String>>

    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<ApiResponse<User>>

    // Protected endpoints (require authentication token)
    @GET("likeEvent/{id}")
    suspend fun likeEvent(@Path("id") eventId: String): Response<ApiResponse<String>>

    @GET("unlikeEvent/{id}")
    suspend fun unlikeEvent(@Path("id") eventId: String): Response<ApiResponse<String>>

    @GET("getAllLikedEvents")
    suspend fun getAllLikedEvents(): Response<EventListResponse>

    @POST("contactUs") // Fixed: was missing "/"
    suspend fun contactUs(@Body message: Map<String, String>): Response<ApiResponse<String>>

    @GET("protected")
    suspend fun getProtectedData(): Response<ApiResponse<String>>

    @POST("bookPass")
    suspend fun bookPass(@Body bookingRequest: PassBookingRequest): Response<ApiResponse<String>>

    @POST("joinTeam")
    suspend fun joinTeam(@Body teamRequest: Map<String, String>): Response<ApiResponse<String>>

    @POST("createTeam")
    suspend fun createTeam(@Body teamRequest: TeamRequest): Response<ApiResponse<String>>

    @POST("getPass")
    suspend fun getPass(@Body request: Map<String, String>): Response<ApiResponse<Any>>

    @POST("getTeam")
    suspend fun getTeam(@Body request: Map<String, String>): Response<ApiResponse<Any>>

    @POST("reqEvent")
    suspend fun requestEvent(@Body eventRequest: Map<String, Any>): Response<ApiResponse<String>>

    // Admin only endpoints
    @GET("CanScan")
    suspend fun canScan(): Response<ApiResponse<Boolean>>

    @POST("verifyPass")
    suspend fun verifyPass(@Body passData: Map<String, String>): Response<ApiResponse<Any>>

    @POST("reject")
    suspend fun rejectPass(@Body data: Map<String, String>): Response<ApiResponse<String>>

    @POST("accept")
    suspend fun acceptPass(@Body data: Map<String, String>): Response<ApiResponse<String>>

    @POST("payment/{bookingId}")
    suspend fun initiatePayment(@Path("bookingId") bookingId: String): Response<ApiResponse<Any>>

    @POST("payment/verify")
    suspend fun verifyPayment(@Body paymentData: Map<String, String>): Response<ApiResponse<Any>>

    @POST("payment/result")
    suspend fun getPaymentResult(@Body data: Map<String, String>): Response<ApiResponse<Any>>

    @POST("addEvent")
    suspend fun addEvent(@Body event: Map<String, Any>): Response<ApiResponse<String>>

    @DELETE("deleteSpecificEvent/{eventId}")
    suspend fun deleteEvent(@Path("eventId") eventId: String): Response<ApiResponse<String>>
}

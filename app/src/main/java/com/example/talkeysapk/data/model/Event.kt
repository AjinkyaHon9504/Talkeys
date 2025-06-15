package com.example.talkeysapk.data.model
import com.example.talkeysapk.R

data class Event(val title: String, val location: String, val imageRes: Int, val category: String,val date: String, val festName: String? = null) {
    companion object {
        private val eventList = listOf(
            Event("Tech Talk", "San Francisco", R.drawable.ic_eventbanner, "Tech", "March 20, 2025", "TechFest"),
            Event("Rock Concert", "New York", R.drawable.ic_eventbanner, "Music", "April 5, 2025"),
            Event("Basketball Tournament", "Los Angeles", R.drawable.ic_eventbanner, "Sports", "May 12, 2025", "Sports Mania"),
            Event("AI Workshop", "Chicago", R.drawable.ic_eventbanner, "Tech", "June 8, 2025"),
            Event("Jazz Festival", "New Orleans", R.drawable.ic_eventbanner, "Music", "July 15, 2025", "Jazz Nights"),
            Event("Soccer Finals", "Miami", R.drawable.ic_eventbanner, "Sports", "August 22, 2025")
        )
        fun getAllEvents(): List<Event> {
            return listOf(
                Event("Tech Talk", "San Francisco", R.drawable.ic_eventbanner, "Tech", "March 20, 2025", "TechFest"),
                Event("Rock Concert", "New York", R.drawable.ic_eventbanner, "Music", "April 5, 2025"),
                Event("Basketball Tournament", "Los Angeles", R.drawable.ic_eventbanner, "Sports", "May 12, 2025", "Sports Mania"),
                Event("AI Workshop", "Chicago", R.drawable.ic_eventbanner, "Tech", "June 8, 2025"),
                Event("Jazz Festival", "New Orleans", R.drawable.ic_eventbanner, "Music", "July 15, 2025", "Jazz Nights"),
                Event("Soccer Finals", "Miami", R.drawable.ic_eventbanner, "Sports", "August 22, 2025")
            )
        }
        fun getEventByTitle(title: String?): Event? {
            return eventList.find { it.title == title }
        }
    }
}
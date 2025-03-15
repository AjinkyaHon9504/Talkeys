package com.example.talkeysapk

data class Event(val title: String, val location: String, val imageRes: Int, val category: String) {
    companion object {
        private val eventList = listOf(
            Event("Tech Talk", "San Francisco", R.drawable.ic_eventbanner, "Tech"),
            Event("Rock Concert", "New York", R.drawable.ic_eventbanner, "Music"),
            Event("Basketball Tournament", "Los Angeles", R.drawable.ic_eventbanner, "Sports"),
            Event("AI Workshop", "Chicago", R.drawable.ic_eventbanner, "Tech"),
            Event("Jazz Festival", "New Orleans", R.drawable.ic_eventbanner, "Music"),
            Event("Soccer Finals", "Miami", R.drawable.ic_eventbanner, "Sports")
        )
        fun getAllEvents(): List<Event> {
            return listOf(
                Event("Tech Talk", "San Francisco", R.drawable.ic_eventbanner, "Tech"),
                Event("Rock Concert", "New York", R.drawable.ic_eventbanner, "Music"),
                Event("Basketball Tournament", "Los Angeles", R.drawable.ic_eventbanner, "Sports"),
                Event("AI Workshop", "Chicago", R.drawable.ic_eventbanner, "Tech"),
                Event("Jazz Festival", "New Orleans", R.drawable.ic_eventbanner, "Music"),
                Event("Soccer Finals", "Miami", R.drawable.ic_eventbanner, "Sports")
            )
        }

        fun getEventByTitle(title: String?): Event? {
            return eventList.find { it.title == title }
        }
    }
}
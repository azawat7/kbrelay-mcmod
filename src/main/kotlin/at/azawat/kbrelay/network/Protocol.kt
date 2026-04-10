package at.azawat.kbrelay.network

import com.google.gson.Gson

data class KeyMessage(val type: String, val key: String? = null)

object Protocol {
    private val gson = Gson()
    fun parse(json: String): KeyMessage? = try {
        gson.fromJson(json, KeyMessage::class.java)
    } catch (_: Exception) {
        null
    }
}

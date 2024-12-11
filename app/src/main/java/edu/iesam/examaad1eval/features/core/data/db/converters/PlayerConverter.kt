package edu.iesam.examaad1eval.features.core.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player

class PlayerConverter {

    @TypeConverter
    fun fromPlayersList(players: List<Player>): String {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().toJson(players, type)
    }
    @TypeConverter
    fun toPlayerList(playersString: String): List<Player> {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().fromJson(playersString, type)

    }
}
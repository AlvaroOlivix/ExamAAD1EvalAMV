package edu.iesam.examaad1eval.features.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.core.data.db.converters.PlayerConverter
import edu.iesam.examaad1eval.features.ex2.data.db.GameDAO
import edu.iesam.examaad1eval.features.ex2.domain.Game

@Database(entities = [Game::class], version = 1)
@TypeConverters(PlayerConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDAO
}
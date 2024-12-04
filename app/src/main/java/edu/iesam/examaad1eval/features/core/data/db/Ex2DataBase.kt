package edu.iesam.examaad1eval.features.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.db.GamesDAO
import edu.iesam.examaad1eval.features.ex2.data.db.PlayerConverters
import edu.iesam.examaad1eval.features.ex2.domain.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(PlayerConverters::class)
abstract class Ext2Database : RoomDatabase() {
    abstract fun gamesDao(): GamesDAO
}
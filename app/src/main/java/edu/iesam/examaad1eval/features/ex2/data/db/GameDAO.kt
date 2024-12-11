package edu.iesam.examaad1eval.features.ex2.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDAO {
    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAll(): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg games: GameEntity)

}
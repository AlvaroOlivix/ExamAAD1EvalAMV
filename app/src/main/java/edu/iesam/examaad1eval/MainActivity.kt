package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.features.core.data.db.AppDatabase
import edu.iesam.examaad1eval.features.ex2.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.db.DbGamesLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.db.GameDAO
import edu.iesam.examaad1eval.features.ex2.data.db.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Game
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-game"
            ).build()

            val gameDao = db.gameDao()

            val localDataSource = DbGamesLocalDataSource(gameDao)
            val remoteDataSource = MockEx2RemoteDataSource()
            val repository = Ex2DataRepository(localDataSource, remoteDataSource)

            val games = repository.getGames()
            games.forEach {
                println(it)
            }
        }
    }
}
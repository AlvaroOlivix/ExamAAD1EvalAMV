package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.ModelsDataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.LocalEx1DataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
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

    private fun executeExercise1() {
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val localData = LocalEx1DataSource(this)
        val remoteData = MockEx1RemoteDataSource()
        val modelsDataRepository = ModelsDataRepository(remoteData, localData)

        val users = modelsDataRepository.getUsers()
        Log.d("@dev", "$users")
        val items = modelsDataRepository.getItems()
        Log.d("@dev", "$items")
        val services = modelsDataRepository.getServices()
        Log.d("@dev", "$services")
        // etc...
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}
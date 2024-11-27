package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.ModelsLocalDataSource
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

    private fun executeExercise1(){

        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        val remoteDataSource = MockEx1RemoteDataSource()
        val localDataSource = ModelsLocalDataSource(this)
        val repository = Ex1DataRepository(remoteDataSource, localDataSource)



        repository.getUsers()
        Log.d("@dev", "Usuarios guardados con exito")

        /*
        repository.getItems()
        Log.d("@dev", "Datos guardados con exito")

        repository.getServices()
        Log.d("@dev", "...")
         */

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}
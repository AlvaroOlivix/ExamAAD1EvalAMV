package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class ModelsLocalDataSource(private val context: Context) {

    private val sharedPreff =
        context.getSharedPreferences(
            context.getString(R.string.db_exam),
            Context.MODE_PRIVATE
        )
    private val gson = Gson()

    fun getAllUsers(): List<User> {
        val usersL = sharedPreff.all
        return usersL.map { user ->
            //Serializa de nuevo los datos en el xml a un objeto de tipo User
            gson.fromJson(user.toString(), User::class.java)
        }
    }

    fun saveAllUsers(users: List<User>) {
        users.forEach { user ->
            //Guarda los valores del objeto User en el xml desserializado.
            sharedPreff.edit().putString(user.id, gson.toJson(user)).apply()
        }
    }

    fun getAllItems(): List<Item> {
        val itemsL = sharedPreff.all
        return itemsL.map { item ->
            gson.fromJson(item.toString(), Item::class.java)
        }
    }

    fun saveAllItems(items: List<Item>) {
        items.forEach { item ->
            sharedPreff.edit().putString(item.id, gson.toJson(item)).apply()
        }
    }

    fun getAllServices(): List<Services> {
        val servicesL = sharedPreff.all
        return servicesL.map { service ->
            gson.fromJson(service.toString(), Services::class.java)
        }
    }

    fun saveAllServices(services: List<Services>) {
        services.forEach { service ->
            sharedPreff.edit().putString(service.id, gson.toJson(service)).apply()
        }
    }
}
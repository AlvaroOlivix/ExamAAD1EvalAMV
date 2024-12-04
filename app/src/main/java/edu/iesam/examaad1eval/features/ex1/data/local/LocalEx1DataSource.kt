package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class LocalEx1DataSource(private val context: Context) {
    private val sharedPref =
        context.getSharedPreferences(
            context.getString(R.string.local_data),
            Context.MODE_PRIVATE
        )
    private val gson = Gson()


    //User como una lista de usuarios
    fun saveUsers(users: List<User>) {
        val usersJson = gson.toJson(users)
        // Guardar el JSON en SharedPreferences
        sharedPref.edit().putString("users", usersJson).apply()
    }

    fun saveItems(items: List<Item>) {
        val itemsJson = gson.toJson(items)
        sharedPref.edit().putString("items", itemsJson).apply()
    }

    fun saveServices(services: List<Services>) {
        val servicesJson = gson.toJson(services)
        sharedPref.edit().putString("services", servicesJson).apply()
    }

    fun getUsers(): List<User> {
        val usersJson = sharedPref.getString("users", null)
        return if (usersJson != null) {
            // Convertir el JSON en una lista de usuarios
            gson.fromJson(usersJson, Array<User>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun getItems(): List<Item> {
        val itemsJson = sharedPref.getString("items", null)
        return if (itemsJson != null) {
            gson.fromJson(itemsJson, Array<Item>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun getServices(): List<Services> {
        val servicesJson = sharedPref.getString("services", null)
        return if (servicesJson != null) {
            gson.fromJson(servicesJson, Array<Services>::class.java).toList()
        } else {
            emptyList()
        }
    }
}
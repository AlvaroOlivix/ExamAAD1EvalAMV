package edu.iesam.examaad1eval.features.ex1.data.remote

import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class MockEx1RemoteDataSource {

    fun getUsers(): List<User> {
        return listOf(
            User("1", "Juan", "Perez"),
            User("2", "Pepe", "Sanchez"),
            User("3", "Maria", "Lopez"),
            User("4", "Ana", "Gonzalez")
        )
    }

    fun getItems(): List<Item> {
        return listOf(
            Item("5", "Camiseta", 10.0),
            Item("6", "Pantalon", 20.0),
            Item("7", "Zapatos", 30.0),
            Item("8", "Chaqueta", 40.0)
        )
    }

    fun getServices(): List<Services> {
        return listOf(
            Services("9", "Camiseta"),
            Services("10", "Pantalon"),
            Services("11", "Zapatos"),
            Services("12", "Chaqueta")
        )
    }


}
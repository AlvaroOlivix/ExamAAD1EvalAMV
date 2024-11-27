package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.ModelsLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val remoteDataSource: MockEx1RemoteDataSource,
    private val localDataSource: ModelsLocalDataSource
) : Ex1Repository {
    override fun getUsers(): List<User> {
        val usersLocal = localDataSource.getAllUsers()
        //
        if (usersLocal.isEmpty()) {
            val usersRemote = remoteDataSource.getUsers()
            localDataSource.saveAllUsers(usersRemote)
            return usersRemote
        }
        return usersLocal
    }

    override fun getItems(): List<Item> {
        val itemsLocal = localDataSource.getAllItems()
        if (itemsLocal.isEmpty()) {
            val itemsRemote = remoteDataSource.getItems()
            localDataSource.saveAllItems(itemsRemote)
            return itemsRemote
        }
        return itemsLocal
    }

    override fun getServices(): List<Services> {
        val servicesLocal = localDataSource.getAllServices()
        if (servicesLocal.isEmpty()) {
            val servicesRemote = remoteDataSource.getServices()
            localDataSource.saveAllServices(servicesRemote)
            return servicesRemote
        }
        return servicesLocal
    }
}

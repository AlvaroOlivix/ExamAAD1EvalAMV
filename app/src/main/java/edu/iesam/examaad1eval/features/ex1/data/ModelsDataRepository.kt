package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.LocalEx1DataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class ModelsDataRepository(
    private val remoteDataSource: MockEx1RemoteDataSource,
    private val localDataSource: LocalEx1DataSource
) :
    Ex1Repository {
    override fun getUsers(): List<User> {
        val usersLocal = localDataSource.getUsers()
        return if (usersLocal.isEmpty()) {
            val usersRemote = remoteDataSource.getUsers()
            localDataSource.saveUsers(usersRemote)
            usersRemote
        } else {
            return usersLocal
        }
    }

    override fun getItems(): List<Item> {
        val itemsLocal = localDataSource.getItems()
        return if (itemsLocal.isEmpty()) {
            val itemsRemote = remoteDataSource.getItems()
            localDataSource.saveItems(itemsRemote)
            itemsRemote
        } else {
            return itemsLocal
        }
    }

    override fun getServices(): List<Services> {
        val servicesLocal = localDataSource.getServices()
        return if (servicesLocal.isEmpty()) {
            val servicesRemote = remoteDataSource.getServices()
            localDataSource.saveServices(servicesRemote)
            servicesRemote
        } else {
            return servicesLocal
        }

    }


}
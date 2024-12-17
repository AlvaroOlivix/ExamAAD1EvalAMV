package edu.iesam.examaad1eval.features.ex2

import edu.iesam.examaad1eval.features.ex2.data.db.DbGamesLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.db.toModel
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val localDataSource: DbGamesLocalDataSource,
    private val remoteDataSource: MockEx2RemoteDataSource
) : Ex2Repository {

    override suspend fun getGames(): List<Game> {
        val localData = localDataSource.getAll()
        if (localData.isEmpty()) {
            val remoteData = remoteDataSource.getGames()
            localDataSource.saveAll(remoteData)
            return remoteData
        } else {
            return localData.map { it.toModel() }
        }
    }
}
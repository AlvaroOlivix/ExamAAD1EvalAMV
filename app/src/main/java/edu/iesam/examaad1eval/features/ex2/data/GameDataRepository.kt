package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.db.DbGamesLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDataRepository(private val localDb: DbGamesLocalDataSource,
    remoteDb: MockEx2RemoteDataSource ): Ex2Repository{

    override suspend fun getGames(): List<Game> {
        TODO("Not yet implemented")
    }
}
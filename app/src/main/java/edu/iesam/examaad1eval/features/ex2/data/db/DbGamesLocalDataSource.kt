package edu.iesam.examaad1eval.features.ex2.data.db

import edu.iesam.examaad1eval.features.ex2.domain.Game

class DbGamesLocalDataSource(
    private val gameDAO: GameDAO
) {

    suspend fun getAll():List<GameEntity>{
        val games = gameDAO.getAll()
        return games.ifEmpty {
            emptyList()
        }
    }

    suspend fun saveAll(games: List<Game>){
        val entities = games.map { it.toEntity() }
        gameDAO.saveAll(*entities.toTypedArray())

    }
}
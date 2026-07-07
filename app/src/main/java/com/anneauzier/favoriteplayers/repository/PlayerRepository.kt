package com.anneauzier.favoriteplayers.repository

import com.anneauzier.favoriteplayers.database.PlayerDAO
import com.anneauzier.favoriteplayers.database.PlayerEntity
import com.anneauzier.favoriteplayers.model.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map

class PlayerRepository(private val playerDAO: PlayerDAO) {

    fun getAllPlayers(): Flow<List<Player>> {
        return playerDAO.getAll().map { listDeEntities ->
            listDeEntities.map { entity ->
                Player(
                    id = entity.player.id,
                    name = entity.player.name,
                    position = entity.player.position,
                    clubID = entity.player.clubID,
                    clubName = entity.club.name
                )
            }
        }
    }

    suspend fun insertPlayer(player: Player) {
        val entity = PlayerEntity(
            id = player.id,
            name = player.name,
            position = player.position,
            clubID = player.clubID
        )
        playerDAO.insert(entity)
    }

    suspend fun deletePlayer(player: Player) {
        val entity = PlayerEntity(
            id = player.id,
            name = player.name,
            position = player.position,
            clubID = player.clubID
        )
        playerDAO.delete(entity)
    }
}
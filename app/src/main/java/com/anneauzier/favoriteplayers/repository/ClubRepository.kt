package com.anneauzier.favoriteplayers.repository
import com.anneauzier.favoriteplayers.database.ClubDAO
import com.anneauzier.favoriteplayers.database.ClubEntity
import com.anneauzier.favoriteplayers.model.Club
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClubRepository(private val clubDao: ClubDAO) {

    fun getAllClubs(): Flow<List<Club>> {
        return clubDao.getAll().map { listaDeEntities ->
            listaDeEntities.map { entity ->
                Club(
                    id = entity.id,
                    name = entity.name,
                    local = entity.local,
                    coach = entity.coach
                )
            }
        }
    }

    suspend fun insertClub(club: Club) {
        val entity = ClubEntity(
            id = club.id,
            name = club.name,
            local = club.local,
            coach = club.coach
        )
        clubDao.insert(entity)
    }

    suspend fun deleteClub(club: Club) {
        val entity = ClubEntity(
            id = club.id,
            name = club.name,
            local = club.local,
            coach = club.coach
        )
        clubDao.delete(entity)
    }
}
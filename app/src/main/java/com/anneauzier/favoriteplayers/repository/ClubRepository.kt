package com.anneauzier.favoriteplayers.repository
import com.anneauzier.favoriteplayers.database.ClubDAO
import com.anneauzier.favoriteplayers.database.ClubEntity

import com.anneauzier.favoriteplayers.model.Club

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClubRepository(private val clubDao: ClubDAO) {

    // 1. LEITURA: Pede ao DAO (Entity), traduz e entrega para a tela (Model)
    fun getAllClubs(): Flow<List<Club>> {
        return clubDao.getAll().map { listaDeEntities ->
            // Para cada entidade na lista do banco, criamos um Club do seu domínio
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

    // 2. ESCRITA: Recebe da tela (Model), traduz e manda o DAO salvar (Entity)
    suspend fun insertClub(club: Club) {
        val entity = ClubEntity(
            id = club.id,
            name = club.name,
            local = club.local,
            coach = club.coach
        )
        clubDao.insert(entity)
    }
}
package com.anneauzier.favoriteplayers.database

import kotlinx.coroutines.flow.Flow

// É a interface que define as operações SQL
// Relacionado ao Room -> banco de dados local

@Dao
interface PlayerDAO {
    @Query("SELECT * FROM players")
    fun getAll(): Flow<List<PlayerEntity>>

    @Insert
    suspend fun insert(player: PlayerEntity)

    @Update
    suspend fun update(player: PlayerEntity)

    @Delete
    suspend fun delete(player: PlayerEntity)
}
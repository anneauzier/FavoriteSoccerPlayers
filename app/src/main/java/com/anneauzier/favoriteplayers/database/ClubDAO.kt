package com.anneauzier.favoriteplayers.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//Flow (do Kotlin Coroutines) para observar leituras do banco em tempo real,
// e suspend functions para operações de escrita ou deleção, garantindo que a tela não trave durante o processo.

@Dao
interface ClubDAO {
    // Flow emite os dados continuamente. Se houver mudanças no banco, a UI reage automaticamente.
    @Query("SELECT * FROM clubs")
    fun getAll(): Flow<List<ClubEntity>>

    // Operações de escrita usam 'suspend' para rodar em segundo plano
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(club: ClubEntity)

    @Delete
    suspend fun delete(club: ClubEntity)
}
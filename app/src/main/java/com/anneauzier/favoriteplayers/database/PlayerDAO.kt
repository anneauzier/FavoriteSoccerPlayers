package com.anneauzier.favoriteplayers.database
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import com.anneauzier.favoriteplayers.model.Player

// É a interface que define as operações SQL
// Relacionado ao Room -> banco de dados local

@Dao
interface PlayerDAO {
    @Query("""
        SELECT players.id, players.name, players.position, clubs.name AS clubName 
        FROM players 
        INNER JOIN clubs ON players.clubId = clubs.id
    """)
    fun getAll(): Flow<List<Player>>

    @Insert
    suspend fun insert(player: Player)

    @Update
    suspend fun update(player: Player)

    @Delete
    suspend fun delete(player: Player)
}
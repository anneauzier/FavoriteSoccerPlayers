package com.anneauzier.favoriteplayers.database
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import com.anneauzier.favoriteplayers.model.Player

@Dao
interface PlayerDAO {
    @Query("SELECT * FROM players")
    fun getAll(): Flow<List<PlayerWithClub>>

    @Insert
    suspend fun insert(player: PlayerEntity)

    @Update
    suspend fun update(player: PlayerEntity)

    @Delete
    suspend fun delete(player: PlayerEntity)
}
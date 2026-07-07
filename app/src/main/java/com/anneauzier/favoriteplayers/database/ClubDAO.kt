package com.anneauzier.favoriteplayers.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubDAO {
    @Query("SELECT * FROM clubs")
    fun getAll(): Flow<List<ClubEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(club: ClubEntity)

    @Delete
    suspend fun delete(club: ClubEntity)
}
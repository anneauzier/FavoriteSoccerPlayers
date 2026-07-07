package com.anneauzier.favoriteplayers.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val local: String,
    var coach : String
)
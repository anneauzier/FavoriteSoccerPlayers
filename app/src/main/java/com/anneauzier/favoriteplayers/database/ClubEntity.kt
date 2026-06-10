package com.anneauzier.favoriteplayers.database
import androidx.room.Entity
import androidx.room.PrimaryKey

// Informar ao Room como a tabela de clubes deve ser estruturada no banco de dados

@Entity(tableName = "clubs")
data class ClubEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val local: String,
    var coach : String
)
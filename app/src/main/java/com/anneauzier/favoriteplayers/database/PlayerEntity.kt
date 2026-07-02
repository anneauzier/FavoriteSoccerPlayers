package com.anneauzier.favoriteplayers.database
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// Representa a tabela no banco. É no formato que o banco entende.

@Entity(tableName = "players",
    foreignKeys = [
        ForeignKey(
            entity = ClubEntity::class,
            parentColumns = ["id"],
            childColumns = ["clubID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class PlayerEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val position: String,
    val clubID: Int
)

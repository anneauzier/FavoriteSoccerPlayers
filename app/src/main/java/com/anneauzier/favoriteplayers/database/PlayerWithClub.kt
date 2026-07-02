package com.anneauzier.favoriteplayers.database

import androidx.room.Embedded
import androidx.room.Relation

data class PlayerWithClub (
    @Embedded val player: PlayerEntity,

    @Relation(
        parentColumn = "clubID",
        entityColumn = "id"
    )
    val club: ClubEntity
)
package com.anneauzier.favoriteplayers.model

// id, nome, local, tecnicoName

data class Club (
    val id: Int = 0,
    val name: String,
    val local: String,
    var coach : String
)
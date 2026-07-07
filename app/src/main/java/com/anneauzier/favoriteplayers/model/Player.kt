package com.anneauzier.favoriteplayers.model

data class Player (
    val id: Int = 0,
    val name: String,
    val position: String,
    val clubID: Int,
    val clubName: String
)

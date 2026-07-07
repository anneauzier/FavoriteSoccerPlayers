package com.anneauzier.favoriteplayers.model

data class Club (
    val id: Int = 0,
    val name: String,
    val local: String,
    var coach : String
)
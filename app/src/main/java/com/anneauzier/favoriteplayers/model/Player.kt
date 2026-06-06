package com.anneauzier.favoriteplayers.model

// representa um player do ponto de vista da aplicacao. data class mais limpo.

data class Player (
    val id: Int = 0,
    val name: String,
    val position: String,
    val clubName: String
)

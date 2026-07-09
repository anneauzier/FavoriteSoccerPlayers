package com.anneauzier.favoriteplayers.viewmodel
import com.anneauzier.favoriteplayers.model.Player


data class PlayerUiState (
    val players: List<Player> = emptyList(),
    val isLoading: Boolean = true
)
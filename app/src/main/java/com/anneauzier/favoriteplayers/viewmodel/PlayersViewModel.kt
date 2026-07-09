package com.anneauzier.favoriteplayers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

import com.anneauzier.favoriteplayers.model.Player
import com.anneauzier.favoriteplayers.repository.PlayerRepository

// carrega os dados via repository, expõe o estado via Stateflow e responde a acoes do usuário.
// cerebro da tela, mas sem saber nada de como a ui é desenhada.

class PlayersViewModel (
    private val repository: PlayerRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(PlayerUiState())
    // 2. ESTADO PÚBLICO: Somente leitura. O Compose vai observar isso (como um @Published).
    val uiState: StateFlow<PlayerUiState> = _uiState.asStateFlow()

    init {
        observePlayers()
    }

    private fun observePlayers() {
        viewModelScope.launch {
            repository.getAllPlayers().collectLatest { playersList ->
                _uiState.value = _uiState.value.copy(
                    players = playersList,
                    isLoading = false
                )
            }
        }
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch {
            repository.insertPlayer(player)
        }
    }

    fun deletePlayer(player: Player) {
        viewModelScope.launch {
            repository.deletePlayer(player)
        }
    }
}
package com.anneauzier.favoriteplayers.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anneauzier.favoriteplayers.ui.theme.FavoritePlayersTheme
import com.anneauzier.favoriteplayers.viewmodel.PlayersViewModel
import androidx.compose.runtime.getValue

@Composable
fun PlayersListScreen(viewModel: PlayersViewModel) {

    // 2. A Mágica da Observação
    // O 'collectAsState' assina o StateFlow.
    // O 'by' desempacota o valor para você usar diretamente.
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        CircularProgressIndicator()
    } else {
        Text(
            text = "Hello, fulano!"
        )
    }
}
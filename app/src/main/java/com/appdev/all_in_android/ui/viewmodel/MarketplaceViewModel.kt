package com.appdev.all_in_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.Player
import com.appdev.all_in_android.data.repositories.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO: Change to actual game model and move to model directory
data class Game(
    val id: Int,
)

data class MarketplaceUiState(
    val upcomingGames: List<Game> = emptyList(),
    val contracts: List<Contract> = emptyList(),
    val players: List<Player> = emptyList(),
    val popularContracts: List<Contract> = emptyList(),
)

@HiltViewModel
class MarketplaceViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
) : AllInViewModel<MarketplaceUiState>(
    initialUiState = MarketplaceUiState()
) {
    init {
        viewModelScope.launch {
            val players = playerRepository.getAllPlayers()
            Log.d("MarketplaceViewModel", "Players: $players")
            applyMutation { copy(players = players ?: emptyList()) }
        }
    }

}
package com.appdev.all_in_android.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.Player
import com.appdev.all_in_android.data.repositories.PlayerRepository
import com.appdev.all_in_android.ui.components.general.PlayerCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
) : BaseViewModel<HomeViewModel.HomeUiState>(
    initialUiState = HomeUiState(
        //popularNow = emptyList(),
        contractList = emptyList(),
        playerList = emptyList()
    )
) {
    data class HomeUiState(
        //val popularNow: List<Contract>,
        val contractList: List<Contract>,
        val playerList: List<Player>
        // TODO Add remaining dynamic data for UI
    ) {
        val popularNow: List<Contract>
            get() = contractList.sortedBy({ contract ->
                contract.cost
            })
    }

    private fun updatePlayerCards(response: List<Player>){

            // TODO - discuss best way to pass in image - maybe image id?
            applyMutation {
                copy(playerList = response)
            }
    }

    fun onRefresh() {
        viewModelScope.launch {
            val response = playerRepository.getAllPlayers()
            updatePlayerCards(response)
        }
    }
    init {

//        asyncCollect(playerRepository.playersFlow) { player ->
//            Log.d("HomeViewModel", "Response: $response")
//            updateGameList(response)
//        }
        onRefresh()
    }
}
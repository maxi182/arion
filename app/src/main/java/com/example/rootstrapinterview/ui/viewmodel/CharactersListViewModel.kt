package com.example.rootstrapinterview.ui.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rootstrapinterview.R
import com.example.rootstrapinterview.RootstrapApplication
import com.example.rootstrapinterview.api.UseCaseResult
import com.example.rootstrapinterview.data.model.characters.Character
import com.example.rootstrapinterview.data.model.characters.CharacterList
import com.example.rootstrapinterview.domain.CharacterListUseCase
import com.example.rootstrapinterview.utils.SingleLiveEvent
import kotlinx.coroutines.*
import org.koin.core.KoinComponent

/**
 * Created by Maxi
 * since 29/01/2021
 */

class CharactersListViewModel(
    val application: RootstrapApplication,
    private val characterListUseCase: CharacterListUseCase
) : AndroidViewModel(application),
    KoinComponent {

    val charactersDataFetched = MutableLiveData<CharacterList>()
    val errorMessage = SingleLiveEvent<Int>()

    private val viewModelJob = SupervisorJob()   //ViewmodelScope can be called from corotines api as well
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun fetchCharacters() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { characterListUseCase.fetchCharacters() }
            when (result) {
                is UseCaseResult.Success -> charactersDataFetched.postValue(result.data)
                is UseCaseResult.Failure -> errorMessage.postValue(result.error)
                else -> errorMessage.postValue(R.string.error_fetching_info)
            }
        }
    }

}
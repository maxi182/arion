package com.example.rootstrapinterview.domain

import com.example.rootstrapinterview.api.UseCaseResult
import com.example.rootstrapinterview.data.model.characters.CharacterList

/**
 * Created by Maxi
 * since 29/01/2021
 */
interface CharacterListRepository {
    suspend fun fetchCharacters(): UseCaseResult<CharacterList, Int>
}
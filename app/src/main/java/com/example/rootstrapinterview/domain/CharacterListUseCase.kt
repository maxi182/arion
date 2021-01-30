package com.example.rootstrapinterview.domain

import com.example.rootstrapinterview.api.UseCaseResult
import com.example.rootstrapinterview.data.model.characters.CharacterList

/**
 * Created by Maxi
 * since 29/01/2021
 */
class CharacterListUseCase(private val characterListRepoImpl: CharacterListRepoImpl): CharacterListRepository{

    override suspend fun fetchCharacters() : UseCaseResult<CharacterList, Int> {
        return try {
            var result = characterListRepoImpl.getCharacters()
            UseCaseResult.Success(result.data)
        } catch (ex: Exception) {
            UseCaseResult.Exception(ex)
        }
    }
}
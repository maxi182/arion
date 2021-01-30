package com.example.rootstrapinterview.domain

import com.example.rootstrapinterview.api.Status
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
            when (result?.status) {
                Status.SUCCESS -> UseCaseResult.Success(result?.data)
                Status.ERROR -> UseCaseResult.Failure(result?.message)
                else -> UseCaseResult.Failure(result?.message)
            }
        } catch (ex: Exception) {
            UseCaseResult.Exception(ex)
        }
    }
}
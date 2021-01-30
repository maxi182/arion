package com.example.rootstrapinterview.domain


import com.example.rootstrapinterview.api.ApiEndpoints
import com.example.rootstrapinterview.api.Resource
import com.example.rootstrapinterview.api.ResponseHandler
import com.example.rootstrapinterview.data.model.characters.CharacterList

/**
 * Created by Maxi
 * since 29/01/2021
 */
class CharacterListRepoImpl(
    private val apiEndpoints: ApiEndpoints,
    private val responseHandler: ResponseHandler
) {
    suspend fun getCharacters(): Resource<CharacterList> {
        return try {
            val response = apiEndpoints.getCharacters()
            return responseHandler.handleSuccess(response!!)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}
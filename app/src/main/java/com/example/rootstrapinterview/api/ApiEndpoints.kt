package com.example.rootstrapinterview.api

import com.example.rootstrapinterview.data.model.characters.CharacterList
import retrofit2.http.GET


/**
 * Created by Maxi
 * since 29/01/2021
 */
interface ApiEndpoints {

    @GET("character")
    suspend fun getCharacters():  CharacterList?

}
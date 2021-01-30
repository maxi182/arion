package com.example.rootstrapinterview.data.model.characters

import com.google.gson.annotations.SerializedName

/**
 * Created by Maxi
 * since 29/01/2021
 */

data class Character(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String
)

data class CharacterList(
    @SerializedName("results")
    val charactersList: List<Character> = listOf()
)
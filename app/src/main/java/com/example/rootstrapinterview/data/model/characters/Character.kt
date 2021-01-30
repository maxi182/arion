package com.example.rootstrapinterview.data.model.characters

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Maxi
 * since 29/01/2021
 */
@Parcelize
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
) : Parcelable

data class CharacterList(
    @SerializedName("results")
    val charactersList: List<Character> = listOf()
)
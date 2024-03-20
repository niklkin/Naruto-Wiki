package com.domain.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep


@Serializable
data class AllCharactersResponse(
    @SerialName("characters")
    val characters: List<Character> = listOf(),
    @SerialName("currentPage")
    val currentPage: Int = 0,
    @SerialName("pageSize")
    val pageSize: Int = 0,
    @SerialName("totalCharacters")
    val totalCharacters: Int = 0
)
package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DebutDto(
    @SerialName("anime")
    val animeDto: String? = "",
    @SerialName("appearsIn")
    val appearsInDto: String? = "",
    @SerialName("game")
    val gameDto: String? = "",
    @SerialName("manga")
    val mangaDto: String? = "",
    @SerialName("movie")
    val movieDto: String? = "",
    @SerialName("novel")
    val novelDto: String? = "",
    @SerialName("ova")
    val ovaDto: String? = ""
)
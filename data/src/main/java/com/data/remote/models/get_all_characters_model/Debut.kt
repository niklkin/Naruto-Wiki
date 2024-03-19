package com.data.remote.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Debut(
    @SerialName("anime")
    val anime: String? = "",
    @SerialName("appearsIn")
    val appearsIn: String? = "",
    @SerialName("game")
    val game: String? = "",
    @SerialName("manga")
    val manga: String? = "",
    @SerialName("movie")
    val movie: String? = "",
    @SerialName("novel")
    val novel: String? = "",
    @SerialName("ova")
    val ova: String? = ""
)
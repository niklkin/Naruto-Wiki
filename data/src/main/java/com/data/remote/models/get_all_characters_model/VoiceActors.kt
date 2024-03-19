package com.data.remote.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep


@Serializable
data class VoiceActors(
    @SerialName("english")
    val english: String? = "",
    @SerialName("japanese")
    val japanese: String? = ""
)
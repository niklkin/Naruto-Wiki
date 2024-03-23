package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoiceActorsDto(
    @SerialName("english")
    val englishDto: String? = "",
    @SerialName("japanese")
    val japaneseDto: String? = ""
)
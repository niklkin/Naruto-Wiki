package com.data.remote.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Character(
    @SerialName("debut")
    val debut: Debut? = Debut(),
    @SerialName("family")
    val family: Family? = Family(),
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("images")
    val images: List<String?>? = listOf(),
    @SerialName("jutsu")
    val jutsu: List<String?>? = listOf(),
    @SerialName("name")
    val name: String? = "",
    @SerialName("natureType")
    val natureType: List<String?>? = listOf(),
    @SerialName("personal")
    val personal: Personal? = Personal(),
    @SerialName("rank")
    val rank: Rank? = Rank(),
    @SerialName("tools")
    val tools: List<String?>? = listOf(),
    @SerialName("uniqueTraits")
    val uniqueTraits: List<String?>? = listOf(),
    @SerialName("voiceActors")
    val voiceActors: VoiceActors? = VoiceActors()
)
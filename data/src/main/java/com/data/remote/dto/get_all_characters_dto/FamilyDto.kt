package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FamilyDto(
    @SerialName("adoptive brother")
    val adoptiveBrotherDto: String? = "",
    @SerialName("adoptive father")
    val adoptiveFatherDto: String? = "",
    @SerialName("adoptive son")
    val adoptiveSonDto: String? = "",
    @SerialName("brother")
    val brotherDto: String? = "",
    @SerialName("cousin")
    val cousinDto: String? = "",
    @SerialName("depowered form")
    val depoweredFormDto: String? = "",
    @SerialName("father")
    val fatherDto: String? = "",
    @SerialName("husband")
    val husbandDto: String? = "",
    @SerialName("incarnation with the god tree")
    val incarnationWithTheGodTreeDto: String? = "",
    @SerialName("nephew")
    val nephewDto: String? = "",
    @SerialName("son")
    val sonDto: String? = ""
)
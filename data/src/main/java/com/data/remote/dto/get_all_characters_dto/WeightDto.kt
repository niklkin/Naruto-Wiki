package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeightDto(
    @SerialName("Part I")
    val partIDto: String? = "",
    @SerialName("Part II")
    val partIIDto: String? = ""
)
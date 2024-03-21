package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeightDto(
    @SerialName("Blank Period")
    val blankPeriodDto: String? = "",
    @SerialName("Gaiden")
    val gaidenDto: String? = "",
    @SerialName("Part I")
    val partIDto: String? = "",
    @SerialName("Part II")
    val partIIDto: String? = ""
)
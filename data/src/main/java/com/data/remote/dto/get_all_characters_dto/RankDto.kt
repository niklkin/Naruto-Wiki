package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankDto(
    @SerialName("ninjaRank")
    val ninjaRankDto: NinjaRankDto? = NinjaRankDto(),
    @SerialName("ninjaRegistration")
    val ninjaRegistrationDto: String? = ""
)
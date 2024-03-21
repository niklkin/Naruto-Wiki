package com.data.remote.dto.get_all_characters_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalDto(
    @SerialName("affiliation")
    val affiliationDto: String? = "",
    @SerialName("age")
    val ageDto: AgeDto? = AgeDto(),
    @SerialName("birthdate")
    val birthdateDto: String? = "",
    @SerialName("bloodType")
    val bloodTypeDto: String? = "",
    @SerialName("clan")
    val clanDto: String? = "",
    @SerialName("classification")
    val classificationDto: String? = "",
    @SerialName("height")
    val heightDto: HeightDto? = HeightDto(),
    @SerialName("jinchūriki")
    val jinchūrikiDto: List<String?>? = listOf(),
    @SerialName("kekkeiGenkai")
    val kekkeiGenkaiDto: String? = "",
    @SerialName("occupation")
    val occupationDto: String? = "",
    @SerialName("partner")
    val partnerDto: String? = "",
    @SerialName("sex")
    val sexDto: String? = "",
    @SerialName("species")
    val speciesDto: String? = "",
    @SerialName("status")
    val statusDto: String? = "",
    @SerialName("team")
    val teamDto: String? = "",
    @SerialName("titles")
    val titlesDto: List<String?>? = listOf(),
    @SerialName("weight")
    val weightDto: WeightDto? = WeightDto()
)
package com.domain.models.get_all_characters_model


import kotlinx.serialization.SerialName
import androidx.annotation.Keep
import kotlinx.serialization.Serializable


@Serializable
data class Personal(
    @SerialName("affiliation")
    val affiliation: String? = "",
    @SerialName("age")
    val age: Age? = Age(),
    @SerialName("birthdate")
    val birthdate: String? = "",
    @SerialName("bloodType")
    val bloodType: String? = "",
    @SerialName("clan")
    val clan: String? = "",
    @SerialName("classification")
    val classification: String? = "",
    @SerialName("height")
    val height: Height? = Height(),
    @SerialName("jinchūriki")
    val jinchūriki: List<String?>? = listOf(),
    @SerialName("kekkeiGenkai")
    val kekkeiGenkai: String? = "",
    @SerialName("occupation")
    val occupation: String? = "",
    @SerialName("partner")
    val partner: String? = "",
    @SerialName("sex")
    val sex: String? = "",
    @SerialName("species")
    val species: String? = "",
    @SerialName("status")
    val status: String? = "",
    @SerialName("team")
    val team: String? = "",
    @SerialName("titles")
    val titles: List<String?>? = listOf(),
    @SerialName("weight")
    val weight: Weight? = Weight()
)
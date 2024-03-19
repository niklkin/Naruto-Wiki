package com.domain.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep


@Serializable
data class Height(
    @SerialName("Blank Period")
    val blankPeriod: String? = "",
    @SerialName("Gaiden")
    val gaiden: String? = "",
    @SerialName("Part I")
    val partI: String? = "",
    @SerialName("Part II")
    val partII: String? = ""
)
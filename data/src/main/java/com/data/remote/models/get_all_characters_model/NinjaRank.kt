package com.data.remote.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class NinjaRank(
    @SerialName("Boruto Manga")
    val borutoManga: String? = "",
    @SerialName("Part I")
    val partI: String? = "",
    @SerialName("Part II")
    val partII: String? = ""
)
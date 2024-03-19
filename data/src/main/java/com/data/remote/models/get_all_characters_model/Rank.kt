package com.data.remote.models.get_all_characters_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Rank(
    @SerialName("ninjaRank")
    val ninjaRank: NinjaRank? = NinjaRank(),
    @SerialName("ninjaRegistration")
    val ninjaRegistration: String? = ""
)
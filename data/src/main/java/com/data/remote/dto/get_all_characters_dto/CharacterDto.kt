package com.data.remote.dto.get_all_characters_dto


import com.domain.entity.get_all_characters_model.Character
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
//    @SerialName("debut")
//    val debutDto: DebutDto? = DebutDto(),
//    @SerialName("family")
//    val familyDto: FamilyDto? = FamilyDto(),
//    @SerialName("id")
//    val idDto: Int? = 0,
    @SerialName("images")
    val imagesDto: List<String?>? = listOf(),
//    @SerialName("jutsu")
//    val jutsuDto: List<String?>? = listOf(),
    @SerialName("name")
    val nameDto: String? = "",
//    @SerialName("natureType")
//    val natureTypeDto: List<String?>? = listOf(),
//    @SerialName("personal")
//    val personalDto: PersonalDto? = PersonalDto(),
//    @SerialName("rank")
//    val rankDto: RankDto? = RankDto(),
//    @SerialName("tools")
//    val toolsDto: List<String?>? = listOf(),
//    @SerialName("uniqueTraits")
//    val uniqueTraitsDto: List<String?>? = listOf(),
//    @SerialName("voiceActors")
//    val voiceActorsDto: VoiceActorsDto? = VoiceActorsDto()
)

fun CharacterDto?.toDomain(): Character {
    return Character(
        name = this?.nameDto ?: "",
        images = this?.imagesDto?.map { it ?: "" } ?: listOf()
    )

}
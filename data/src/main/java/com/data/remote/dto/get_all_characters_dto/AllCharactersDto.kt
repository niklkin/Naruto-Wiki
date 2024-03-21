package com.data.remote.dto.get_all_characters_dto


import com.domain.entity.get_all_characters_model.AllCharactersEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllCharactersDto(
    @SerialName("characters")
    val charactersDto: List<CharacterDto?>? = listOf(),
    @SerialName("currentPage")
    val currentPageDto: Int = 0,
    @SerialName("pageSize")
    val pageSizeDto: Int = 0,
    @SerialName("totalCharacters")
    val totalCharactersDto: Int = 0
)

fun AllCharactersDto?.toDomain(): AllCharactersEntity {
    return AllCharactersEntity(
        characters = this?.charactersDto?.map {
            it.toDomain()
        } ?: listOf(),
        currentPage = this?.currentPageDto ?: 0,
        pageSize = this?.pageSizeDto ?: 0,
        totalCharacters = this?.totalCharactersDto ?: 0
    )
}
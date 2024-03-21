package com.domain.entity.get_all_characters_model

data class AllCharactersEntity(
    val characters: List<Character>,
    val currentPage: Int,
    val pageSize: Int,
    val totalCharacters: Int
)
package com.domain.entity.get_all_characters_model

data class Personal(
    val affiliation: String,
    val age: Age,
    val birthdate: String,
    val bloodType: String,
    val clan: String,
    val classification: String,
    val height: Height,
    val jinchuriki: List<String>,
    val kekkeiGenkai: String,
    val occupation: String,
    val partner: String,
    val sex: String,
    val species: String,
    val status: String,
    val team: String,
    val titles: List<String>,
    val weight: Weight
)
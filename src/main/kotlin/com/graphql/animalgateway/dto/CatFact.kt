package com.graphql.animalgateway.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatFact(
    val fact: String,
    val length: Int
)
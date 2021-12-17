package com.graphql.animalgateway.dto

import kotlinx.serialization.Serializable

@Serializable
data class DogFact(
    val fact: String
)
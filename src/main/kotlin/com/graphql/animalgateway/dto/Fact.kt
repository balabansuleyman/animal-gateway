package com.graphql.animalgateway.dto

data class Fact(
    val fact: String,
    val length: Int,
    val latency: Int?
)
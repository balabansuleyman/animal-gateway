package com.graphql.animalgateway.resolver

import com.graphql.animalgateway.dto.Fact
import com.graphql.animalgateway.client.DogEndpoint
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DogQueryResolver(
    val dogEndpoint: DogEndpoint
) : GraphQLQueryResolver {

    suspend fun dog(): Fact = dogEndpoint.getDog()
}




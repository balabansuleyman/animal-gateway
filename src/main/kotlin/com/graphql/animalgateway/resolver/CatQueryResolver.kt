package com.graphql.animalgateway.resolver

import com.graphql.animalgateway.dto.Fact
import com.graphql.animalgateway.client.CatEndpoint
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class CatQueryResolver(
    val catEndpoint: CatEndpoint
) : GraphQLQueryResolver {

    suspend fun cat(): Fact = catEndpoint.getCat()
}




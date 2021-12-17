package com.graphql.animalgateway.config

import com.graphql.animalgateway.resolver.CatQueryResolver
import com.graphql.animalgateway.resolver.DogQueryResolver
import graphql.kickstart.tools.SchemaParser
import graphql.schema.GraphQLSchema
import io.ktor.client.HttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfig {
    @Bean
    fun graphQLSchema(
        httpClient: HttpClient,
        dogQueryResolver: DogQueryResolver,
        catQueryResolver: CatQueryResolver
    ): GraphQLSchema {
        return SchemaParser.newParser()
            .file("graphql/schema.graphqls")
            .resolvers(dogQueryResolver, catQueryResolver)
            .build()
            .makeExecutableSchema()
    }

}
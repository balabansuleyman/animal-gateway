package com.graphql.animalgateway.client

import com.graphql.animalgateway.constants.DOG_FACT_URL
import com.graphql.animalgateway.dto.DogFact
import com.graphql.animalgateway.dto.Fact
import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.kotlin.circuitbreaker.executeSuspendFunction
import io.ktor.client.*
import io.ktor.client.request.*
import org.springframework.stereotype.Component

@Component
class DogEndpoint(
    val ktorClient: HttpClient,
    val dogCircuitBreaker: CircuitBreaker
) {
    suspend fun getDog(): Fact {
        val start = System.currentTimeMillis()

        val dogFact = dogCircuitBreaker.executeSuspendFunction {
            ktorClient.get<DogFact>(DOG_FACT_URL)
        }
        return Fact(
            fact = dogFact.fact,
            length = dogFact.fact.length,
            latency = (System.currentTimeMillis() - start).toInt()
        )
    }
}




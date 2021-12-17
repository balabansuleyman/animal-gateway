package com.graphql.animalgateway.client

import com.graphql.animalgateway.constants.CAT_FACT_URLS
import com.graphql.animalgateway.dto.CatFact
import com.graphql.animalgateway.dto.Fact
import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.kotlin.circuitbreaker.executeSuspendFunction
import io.ktor.client.*
import io.ktor.client.request.*
import org.springframework.stereotype.Component

@Component
class CatEndpoint(
    val ktorClient: HttpClient,
    val catCircuitBreaker: CircuitBreaker
) {

    suspend fun getCat(): Fact {
        val start = System.currentTimeMillis()
        val catFact = catCircuitBreaker.executeSuspendFunction  {
            ktorClient.get<CatFact>(CAT_FACT_URLS)
        }
        return Fact(
            fact = catFact.fact,
            length = catFact.length,
            latency = (System.currentTimeMillis() - start).toInt()
        )
    }
}




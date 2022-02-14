package no.nav.arbeidsplassen.matchprofile.job

import com.fasterxml.jackson.databind.JsonNode
import io.micronaut.http.HttpHeaders
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("\${ad.searchApiUrl}")
@Headers(
    Header(name = HttpHeaders.USER_AGENT, value = "Micronaut HTTP Client")
)
interface AdSearchApiClient {

    @Get("/ad/_search")
    fun getAdsFromQuery(@QueryValue q: String): JsonNode
}

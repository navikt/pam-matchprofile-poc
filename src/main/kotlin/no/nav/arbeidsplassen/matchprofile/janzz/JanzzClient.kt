package no.nav.arbeidsplassen.matchprofile.janzz

import com.fasterxml.jackson.databind.JsonNode
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client

@Client("\${janzz.url}")
@Headers(
    Header(name="Authorization", value="\${janzz.token}"),
    Header(name = USER_AGENT, value = "Micronaut HTTP Client")
)
interface JanzzClient {

    @Post("/parser/parse_job/")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun parseJob(@Body QueryBody: QueryBody): ParsedDTO

    @Post("/parser/parse_cv/")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun parseCV(@Body QueryBody: QueryBody): ParsedDTO

    @Post("/parser/occupation_extract/")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun extractOccupation(@Body QueryBody: QueryBody): JsonNode

    @Post("/parser/similarity/")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun findSimilarity(@Body similarity: SimilarityBody): JsonNode

    @Post("/test_classifier/")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun classify(@Body classificationBody: ClassificationBody): JsonNode

    @Get("/occupation_suggest")
    @Header(name = HttpHeaders.ACCEPT, value = "application/json")
    fun occupationRelation(@QueryValue occupation: String, @QueryValue relation:String, @QueryValue lang: String = "no"): ConceptResultsDTO
}

package no.nav.arbeidsplassen.matchprofile.job

import io.micronaut.http.HttpHeaders
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("\${ad.apiUrl}")
@Headers(
    Header(name = HttpHeaders.USER_AGENT, value = "Micronaut HTTP Client")
)
interface AdClient {

    @Get("/ads")
    fun getActiveAds(@QueryValue status: String="ACTIVE", @QueryValue size: Int,  @QueryValue page: Int): AdSlice<AdDTO>

}

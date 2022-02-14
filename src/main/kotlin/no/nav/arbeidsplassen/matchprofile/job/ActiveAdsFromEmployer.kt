package no.nav.arbeidsplassen.matchprofile.job

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton

@Singleton
class ActiveAdsFromEmployer(private val searchApiClient: AdSearchApiClient, private val objectMapper: ObjectMapper) {

    fun getActiveAdsFromEmployer(orgnr: String):List<AdDTO> {
        val json = searchApiClient.getAdsFromQuery("status:ACTIVE AND employer.orgnr:$orgnr")
        return json.get("hits").get("hits").map {
            objectMapper.treeToValue(it.get("_source"), AdDTO::class.java)
        }
    }
}

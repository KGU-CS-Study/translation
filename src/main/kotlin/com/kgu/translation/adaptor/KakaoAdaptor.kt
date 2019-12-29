package com.kgu.translation.adaptor

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder


/**
 *   Created by hong-pyo on 29/12/2019
 *   Time : 10:40 오후
 */

@Component
class KakaoAdaptor (@Value("\${kakao.auth.key}") private val key: String,
                    @Value("\${kakao.url}") private val kakaoUrl: String,
                    private val kakaoRestTemplate : RestTemplate) {

    fun getTranslation(query: String, from : String, to : String) {
        val url = UriComponentsBuilder.fromUriString("$kakaoUrl/v1/translation/translate")
                .queryParam("query", query)
                .queryParam("src_lang", from)
                .queryParam("target_lang", to)
                .build()
                .toUri()

        try {
            // todo restTemplate call add header key
        } catch (e : HttpStatusCodeException) {
            // todo error handling
        }
    }
}
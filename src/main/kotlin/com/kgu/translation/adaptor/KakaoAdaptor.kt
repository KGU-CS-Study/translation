package com.kgu.translation.adaptor

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.lang.RuntimeException


/**
 *   Created by hong-pyo on 29/12/2019
 *   Time : 10:40 오후
 */

public data class TranslationText (
    val translated_text : List<List<String>>
)

@Component
class KakaoAdaptor (@Value("\${kakao.auth.key}") private val key: String,
                    @Value("\${kakao.url}") private val kakaoUrl: String) {

    fun getTranslation(query: String, from : String, to : String) : TranslationText{
        /**
         * todo 이부분 리팩토링 필수!
         * 에러 타입에 따라서 리퀘스트 다르게 줄수 있도록 변경할것.
         * */
        val kakaoRestTemplate = RestTemplate()
        val url = UriComponentsBuilder.fromUriString("$kakaoUrl/v1/translation/translate")
                .queryParam("query", query)
                .queryParam("src_lang", from)
                .queryParam("target_lang", to)
                .build()
                .toUri()
        val headers = HttpHeaders()
        headers.add("Authorization", "KakaoAK $key")
        headers.contentType = MediaType.APPLICATION_JSON

        val rq = RequestEntity<String>(headers, HttpMethod.GET, url)
        var response : ResponseEntity<TranslationText>
        try {
            response = kakaoRestTemplate.exchange(rq, TranslationText::class.java)
        } catch (e : HttpStatusCodeException) {
            throw RuntimeException("Not Invalid Something")
        }
        return response.body!!
    }
}
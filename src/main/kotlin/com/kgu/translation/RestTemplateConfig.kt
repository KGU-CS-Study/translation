package com.kgu.translation

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


/**
 *   Created by hong-pyo on 30/12/2019
 *   Time : 1:00 오전
 */
   
@Configuration
class RestTemplateConfig {

    @Bean
    fun kakaoRestTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.requestFactory(this::factory).build()
    }

    private fun factory() : HttpComponentsClientHttpRequestFactory {
        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setConnectTimeout(3000)
        factory.setConnectionRequestTimeout(3000)

        return factory
    }
}
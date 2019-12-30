package com.kgu.translation.service

import com.kgu.translation.adaptor.KakaoAdaptor
import com.kgu.translation.adaptor.TranslationText
import org.springframework.stereotype.Service


/**
 *   Created by hong-pyo on 30/12/2019
 *   Time : 12:47 오전
 */
@Service
class TranslationService(private val kakaoAdaptor: KakaoAdaptor)  {
    fun translation(from: String, to: String, query: String, redirect : Boolean) : TranslationText {
        if (redirect) {
            /**
             *  todo
             *  한번 가져온 결과값을 query 값을 컨버팅을 해주고 나서
             *  거기서 나온 텍스트로 다시한번 api 호출
             *  조금더 리팩토링을 할것.
             * */

            val translatedQuery = kakaoAdaptor.getTranslation(query, from, "jp")

            return kakaoAdaptor.getTranslation(translatedQuery.translated_text.get(0).get(0), "jp", to)
        } else {
            return kakaoAdaptor.getTranslation(query, from, to)
        }
    }
}
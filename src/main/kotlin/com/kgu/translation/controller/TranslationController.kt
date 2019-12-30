package com.kgu.translation.controller

import com.kgu.translation.adaptor.TranslationText
import com.kgu.translation.service.TranslationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


/**
 *   Created by hong-pyo on 30/12/2019
 *   Time : 12:44 오전
 */

@RestController
class TranslationController(private val translationService: TranslationService) {

    @GetMapping("/translation")
    fun translation(from : String, to : String, query : String, redirect: Boolean) : TranslationText{
        return translationService.translation(from, to, query,  redirect)
    }

}
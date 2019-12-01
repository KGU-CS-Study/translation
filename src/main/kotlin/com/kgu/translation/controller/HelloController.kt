package com.kgu.translation.controller

import com.kgu.translation.utils.isCustomEmpty
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *   Created by hong2 on 02/12/2019
 *   Time : 12:42 오전
 */

@RestController
class HelloController {

    @RequestMapping("/hello")
    fun hello() : String {
        "wow!!!".isCustomEmpty()
        return "hello world";
    }
}
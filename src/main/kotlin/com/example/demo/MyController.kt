package com.example.demo

import com.example.demo.api.CityApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController : CityApi {
    @GetMapping("/city")
    override fun current(): City {
        return City("egorka-city")
    }
}
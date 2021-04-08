package com.example.demo.controllers

import com.example.demo.controllers.pojo.AvailableIds
import com.example.demo.services.DataAccessApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(private val dataService: DataAccessApi) {

    @GetMapping("/ids")
    fun idsForMe(): AvailableIds {
        return AvailableIds(dataService.availableIds())
    }
}
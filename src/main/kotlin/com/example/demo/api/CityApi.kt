package com.example.demo.api

import com.example.demo.City
import feign.Headers
import feign.RequestLine

@Headers(value = ["Accept: application/json", "Content-Type: application/json"])

interface CityApi {
    @RequestLine("GET /city")
    fun current(): City
}
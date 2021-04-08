package com.example.demo.api

import com.example.demo.City

class FallBackCityApi : CityApi {
    override fun current(): City {
        return City("omgwhat city api fallback")
    }
}
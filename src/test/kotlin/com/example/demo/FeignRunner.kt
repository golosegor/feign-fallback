package com.example.demo

import com.example.demo.api.CityApi
import com.example.demo.api.FallBackCityApi
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import feign.Feign
import feign.hystrix.HystrixCapability
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder

class FeignRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val mapper = ObjectMapper().registerKotlinModule()
            val hystrixCapability = HystrixCapability()
                .fallback(CityApi::class.java, FallBackCityApi())

            val cityApi = Feign.builder()
                .encoder(JacksonEncoder(mapper))
                .decoder(JacksonDecoder(mapper))
                .addCapability(hystrixCapability)
                .target(CityApi::class.java, "http://localhost:8080")
            println(cityApi.current())
        }
    }
}
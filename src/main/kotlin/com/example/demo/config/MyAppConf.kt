package com.example.demo.config

import com.example.demo.services.DataAccessApi
import com.example.demo.services.DataAccessApiForSecurityContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyAppConf {
    @Bean
    fun dataAccessApi(): DataAccessApi {
        return DataAccessApiForSecurityContext()
    }
}
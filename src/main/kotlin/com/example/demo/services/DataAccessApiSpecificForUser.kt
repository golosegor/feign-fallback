package com.example.demo.services

import org.springframework.security.core.context.SecurityContext

class DataAccessApiSpecificForUser(val securityContext: SecurityContext) : DataAccessApi {

    override fun availableIds(): Map<String, String> {
        return mapOf(
            "whaat" to securityContext.authentication.name,
            "time" to System.currentTimeMillis().toString()
        )
    }
}
package com.example.demo.services

import org.springframework.security.core.context.SecurityContextHolder
import java.util.concurrent.ConcurrentHashMap

class DataAccessApiForSecurityContext : DataAccessApi {
    private val idsBySecurityContext = ConcurrentHashMap<String, DataAccessApi>()

    override fun availableIds(): Map<String, String> {
        val sc = SecurityContextHolder.getContext()
        val computeIfAbsent =
            idsBySecurityContext.computeIfAbsent(sc.authentication.name) { ignored -> DataAccessApiSpecificForUser(sc) }
        return computeIfAbsent.availableIds()
    }

}
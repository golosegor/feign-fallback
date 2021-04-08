package com.example.demo.services

interface DataAccessApi {
    fun availableIds(): Map<String, String>
}
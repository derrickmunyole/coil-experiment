package com.example.coilexperiment.domain

interface EntityMapper<ME : Any, M : Any> {
    fun mapToDomain(photosDTO: ME): M
}

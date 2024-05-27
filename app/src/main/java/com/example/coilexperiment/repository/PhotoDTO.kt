package com.example.coilexperiment.repository

data class PhotoDTO(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)
package com.example.coilexperiment.data.repository

import com.example.coilexperiment.domain.Photo

data class PhotoDTO(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)


package com.example.coilexperiment.domain.model

data class Photo(
    val id: Int,
    val imageURL: String,
    val views: Int,
    val downloads: Int,
    val user: String,
    val userImageURL: String
)

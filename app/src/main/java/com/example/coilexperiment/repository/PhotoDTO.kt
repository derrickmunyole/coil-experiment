package com.example.coilexperiment.repository

import com.example.coilexperiment.domain.Photo

data class PhotoDTO(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)


fun PhotoDTO.toPhoto(): List<Photo> {
    return hits.map { hit ->
        Photo(
            id = hit.id,
            imageURL = hit.largeImageURL,
            views = hit.views,
            downloads = hit.downloads,
            user = hit.user,
            userImageURL = hit.userImageURL
        )
    }
}
package com.example.coilexperiment.data.repository

import com.example.coilexperiment.domain.EntityMapper
import com.example.coilexperiment.domain.Photo
import javax.inject.Inject

class PhotoMapper @Inject constructor() : EntityMapper<List<PhotoDTO>, List<Photo>> {
    override fun mapToDomain(photosDTO: List<PhotoDTO>): List<Photo> {
        return photosDTO.map {
            photos ->
            Photo(
            id = photos.hits.firstOrNull()?.id?: -1,
            imageURL = photos.hits.firstOrNull()?.largeImageURL?:"",
            views = photos.hits.firstOrNull()?.views?:0,
            downloads = photos.hits.firstOrNull()?.downloads?:0,
            user = photos.hits.firstOrNull()?.user?:"",
            userImageURL = photos.hits.firstOrNull()?.userImageURL?:""
        )

        }
    }
}

package com.example.coilexperiment.domain.usecase

import com.example.coilexperiment.domain.PhotosRepositoryImpl
import com.example.coilexperiment.domain.model.Photo

class FetchPhotosUseCase(private val photosRepositoryImpl: PhotosRepositoryImpl) {
    suspend operator fun invoke(): List<Photo> {
        return photosRepositoryImpl.fetchPhotos()
    }
}

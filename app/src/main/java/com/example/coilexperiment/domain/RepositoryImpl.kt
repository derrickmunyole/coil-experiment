package com.example.coilexperiment.domain

import com.example.coilexperiment.data.repository.PhotoMapper
import com.example.coilexperiment.data.repository.PhotosApiService
import com.example.coilexperiment.domain.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photosApi: PhotosApiService,
    private val photoMapper: PhotoMapper
) {
    private var photos: List<Photo>? = null
    private var error: Throwable? = null
    val apiKey = ""
    val query = ""
    val imageType = ""

    suspend fun fetchPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            try {
                val photosDTO = photosApi.getPhotos(apiKey, query, imageType)
                photoMapper.mapToDomain(photosDTO)
            } catch (e: IOException) {
                throw Throwable(message="Network error", e)
            } catch (e: Exception) {
                throw Throwable(message = "There was an unexpected error", e)
            }
        }
    }


    val photosList: List<Photo>
        get() = photos?: throw IllegalStateException("Photos not loaded yet")

    val isLoading: Boolean
        get() = photos == null && error == null

    val errorOccurred: Throwable?
        get() = error
}
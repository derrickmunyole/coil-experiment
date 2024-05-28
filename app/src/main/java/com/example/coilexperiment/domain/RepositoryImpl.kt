package com.example.coilexperiment.domain

import com.example.coilexperiment.repository.PhotoDTO
import com.example.coilexperiment.repository.PhotosApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class PhotosRepositoryImpl(private val photosApi: PhotosApiService) {
    private var photos: List<PhotoDTO>? = null
    private var error: Throwable? = null
    val apiKey = ""
    val query = ""
    val imageType = ""

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                photos = photosApi.getPhotos(apiKey, query, imageType)
            } catch(e: IOException) {
                error = e
            } catch (e: Exception) {
                error = e
            }

        }
    }

    val photosList: List<PhotoDTO>
        get() = photos?: throw IllegalStateException("Photos not loaded yet")

    val isLoading: Boolean
        get() = photos == null && error == null

    val errorOccurred: Throwable?
        get() = error
}
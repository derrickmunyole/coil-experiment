package com.example.coilexperiment.domain

import androidx.compose.ui.platform.LocalContext
import com.example.coilexperiment.repository.PhotoDTO
import com.example.coilexperiment.repository.PhotosApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class PhotosRepositoryImpl(private val photosApi: PhotosApiService) {
    private var photos: List<PhotoDTO>? = null
    private var error: Throwable? = null

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                photos = photosApi.getPhotos()
            } catch(e: IOException) {
                error = e
            } catch (e: Exception) {
                error = e
            }

        }
    }
}
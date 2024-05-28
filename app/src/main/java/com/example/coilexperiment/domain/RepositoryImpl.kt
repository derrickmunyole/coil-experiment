package com.example.coilexperiment.domain

import com.example.coilexperiment.data.repository.PhotoDTO
import com.example.coilexperiment.data.repository.PhotoMapper
import com.example.coilexperiment.data.repository.PhotosApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    init {
        fetchPhotos()
    }

    private fun fetchPhotos(): List<Photo> {
        var photos = emptyList<Photo>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val photosDTO = photosApi.getPhotos(apiKey, query, imageType)
                photos = photoMapper.mapToDomain(photosDTO)
            } catch(e: IOException) {
                error = e
            } catch (e: Exception) {
                error = e
            }

        }
        return photos
    }

    val photosList: List<Photo>
        get() = photos?: throw IllegalStateException("Photos not loaded yet")

    val isLoading: Boolean
        get() = photos == null && error == null

    val errorOccurred: Throwable?
        get() = error
}
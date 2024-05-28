package com.example.coilexperiment.data.repository

import retrofit2.http.GET
import retrofit2.http.Query


interface PhotosApiService {

    @GET("api")
    suspend fun getPhotos(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String
    ): List<PhotoDTO>

}
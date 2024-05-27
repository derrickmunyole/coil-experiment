package com.example.coilexperiment.repository

import retrofit2.http.GET


interface PhotosApiService {

    @GET
    suspend fun getPhotos(): List<PhotoDTO>

}
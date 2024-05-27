package com.example.coilexperiment.di

import com.example.coilexperiment.domain.PhotosRepositoryImpl
import com.example.coilexperiment.repository.PhotosApi
import com.example.coilexperiment.repository.PhotosApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    const val BASE_URL = ""
    val photosApi: PhotosApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(PhotosApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePhotosRepository(photosApi: PhotosApiService): PhotosRepositoryImpl {
        return PhotosRepositoryImpl(photosApi)
    }

}


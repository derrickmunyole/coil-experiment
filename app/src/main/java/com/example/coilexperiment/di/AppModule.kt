package com.example.coilexperiment.di

import com.example.coilexperiment.data.repository.PhotoMapper
import com.example.coilexperiment.domain.PhotosRepositoryImpl
import com.example.coilexperiment.data.repository.PhotosApiService
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

    private const val BASE_URL = "https://pixabay.com/"
    val photosApi: PhotosApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(PhotosApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePhotoMapper(): PhotoMapper {
        return PhotoMapper()
    }

    @Provides
    @Singleton
    fun providePhotosRepository(photosApi: PhotosApiService, photoMapper: PhotoMapper): PhotosRepositoryImpl {
        return PhotosRepositoryImpl(photosApi, photoMapper)
    }

}



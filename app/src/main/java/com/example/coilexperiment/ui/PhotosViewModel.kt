package com.example.coilexperiment.ui

import androidx.lifecycle.ViewModel
import com.example.coilexperiment.domain.Photo
import com.example.coilexperiment.domain.PhotosRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class PhotosViewModel(
    private val photosRepositoryImpl: PhotosRepositoryImpl
): ViewModel() {


    init {

    }
}
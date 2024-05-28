package com.example.coilexperiment.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coilexperiment.domain.model.Photo
import com.example.coilexperiment.domain.PhotosRepositoryImpl
import com.example.coilexperiment.domain.usecase.FetchPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PhotosViewModel(
    private val fetchPhotosUseCase: FetchPhotosUseCase
): ViewModel() {

    private var _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photos = _photos.asStateFlow()

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            try {
               val photos = fetchPhotosUseCase()
                _photos.value = photos
            } catch(exception: Exception) {
                Log.e("PhotosViewModel", "Failed to fetch photos", exception)
                _photos.value = listOf()
            }
        }
    }
}
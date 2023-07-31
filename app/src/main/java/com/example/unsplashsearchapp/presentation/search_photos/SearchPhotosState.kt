package com.example.unsplashsearchapp.presentation.search_photos

import com.example.unsplashsearchapp.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null
)

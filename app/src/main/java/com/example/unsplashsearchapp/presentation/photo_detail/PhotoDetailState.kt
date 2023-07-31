package com.example.unsplashsearchapp.presentation.photo_detail

import com.example.unsplashsearchapp.domain.model.PhotoDetail

data class PhotoDetailState(
    val isLoading:Boolean = false,
    val photoDetail:PhotoDetail? = null,
    val error: String? = null
)

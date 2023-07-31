package com.example.unsplashsearchapp.data.repository

import com.example.unsplashsearchapp.data.remote.PhotoDetailDto
import com.example.unsplashsearchapp.data.remote.SearchPhotosResultDto
import com.example.unsplashsearchapp.data.remote.UnsplashApi
import com.example.unsplashsearchapp.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : PhotoRepository {

// 通常のアプリ開発ではここでキャッシュなどの機能を書くらしい

    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return api.searchPhotos(query)
    }

    override suspend fun getPhotoById(photoId: String): PhotoDetailDto {
        return api.getPhotoById(photoId)
    }
}
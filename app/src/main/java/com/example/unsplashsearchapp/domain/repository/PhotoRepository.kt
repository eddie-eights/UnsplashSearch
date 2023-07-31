package com.example.unsplashsearchapp.domain.repository

import com.example.unsplashsearchapp.data.remote.PhotoDetailDto
import com.example.unsplashsearchapp.data.remote.SearchPhotosResultDto


//　use_caseが参照するインターフェイスを定義しdomainを最上位レイヤーに (クリーンアーキテクチャによる依存関係の逆転)
interface PhotoRepository {

    suspend fun searchPhotos(query: String): SearchPhotosResultDto

    suspend fun getPhotoById(photoId: String): PhotoDetailDto
}
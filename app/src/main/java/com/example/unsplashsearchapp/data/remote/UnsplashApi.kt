package com.example.unsplashsearchapp.data.remote

import com.example.unsplashsearchapp.common.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

//UnsplashとのHTTP通信インターフェイスを定義

interface UnsplashApi {

    // suspendをつけるとretrofitが別のスレッドで処理してくれる(=非同期処理)
    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query: String): SearchPhotosResultDto


    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("photos/{id}")
    suspend fun getPhotoById(@Path("id") photoId: String): PhotoDetailDto
}
package com.example.unsplashsearchapp.data.remote


import com.example.unsplashsearchapp.domain.model.Photo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchPhotosResultDto(
    val results: List<Result>?,
    val total: Int?,
    @Json(name = "total_pages")
    val totalPages: Int?
)


// DataレイヤーのSearchPhotosResultDtoをDomainレイヤーのPhoto型に変換
fun SearchPhotosResultDto.toPhotos(): List<Photo> {
    return results!!.map {
        Photo(
            photoId = it.id!!,
            description = it.description,
            likes = it.likes,
            imageUrl = it.urls!!.raw!!,
            photographer = it.user?.username
        )
    }
}
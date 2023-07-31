package com.example.unsplashsearchapp.domain.use_case

import com.example.unsplashsearchapp.common.NetworkResponse
import com.example.unsplashsearchapp.data.remote.toPhotos
import com.example.unsplashsearchapp.domain.model.Photo
import com.example.unsplashsearchapp.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//　ユースケースクラスは1つのクラスで1つの機能を実装
class SearchPhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(query: String): Flow<NetworkResponse<List<Photo>>> = flow {
        try {

            emit(NetworkResponse.Loading<List<Photo>>())

            val photos = repository.searchPhotos(query).toPhotos()

            emit(NetworkResponse.Success<List<Photo>>(photos))

        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Photo>>(e.message.toString()))

        }

    }
}
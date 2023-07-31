package com.example.unsplashsearchapp.presentation.search_photos

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashsearchapp.common.NetworkResponse
import com.example.unsplashsearchapp.domain.use_case.SearchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchPhotosViewModel @Inject constructor(
    private val searchPhotoUseCase: SearchPhotoUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SearchPhotosState())
    val state: State<SearchPhotosState> = _state

    var query by mutableStateOf("fukuoka")

    init {
        searchPhotos()
    }

    fun searchPhotos() {
        searchPhotoUseCase(query).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = SearchPhotosState(
                        isLoading = false, photos = result.data ?: emptyList()
                    )

                }
                is NetworkResponse.Failure -> {
                    _state.value = SearchPhotosState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _state.value = SearchPhotosState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
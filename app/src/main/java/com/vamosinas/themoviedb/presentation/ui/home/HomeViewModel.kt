package com.vamosinas.themoviedb.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.vamosina.themoviedb.common.mapper.model.ParamMovieMapper
import com.vamosina.themoviedb.common.wrapper.Resource
import com.vamosinas.themoviedb.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): HomeContract, ViewModel() {
    private val _getMovieResult = MutableStateFlow<Resource<PagingData<ParamMovieMapper>>>(Resource.Empty())
    override val getMovieResult: StateFlow<Resource<PagingData<ParamMovieMapper>>> = _getMovieResult

    override fun getMovie() {
        _getMovieResult.value = Resource.Loading()
        viewModelScope.launch {
            homeRepository.getMovies().collect {
                try {
                    _getMovieResult.value = Resource.Success(it)
                } catch (e: Exception) {
                    _getMovieResult.value = Resource.Error(
                        exception = e,
                        message = "Something went wrong!"
                    )
                }
            }
        }
    }
}
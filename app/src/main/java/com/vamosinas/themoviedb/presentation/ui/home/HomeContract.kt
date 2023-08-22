package com.vamosinas.themoviedb.presentation.ui.home

import androidx.paging.PagingData
import com.vamosina.themoviedb.common.mapper.model.ParamMovieMapper
import com.vamosina.themoviedb.common.wrapper.Resource
import kotlinx.coroutines.flow.StateFlow

interface HomeContract {
    val getMovieResult: StateFlow<Resource<PagingData<ParamMovieMapper>>>
    fun getMovie()
}
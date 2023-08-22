package com.vamosinas.themoviedb.presentation.ui.favorite

import com.vamosina.themoviedb.common.wrapper.Resource
import com.vamosinas.themoviedb.data.local.model.entity.FavoriteEntity
import kotlinx.coroutines.flow.StateFlow

interface FavoriteContract {
    val getFavoriteResult: StateFlow<Resource<List<FavoriteEntity>>>
    fun getFavorite()
}
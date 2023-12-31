package com.vamosinas.themoviedb.data.repository


import com.vamosina.themoviedb.common.base.BaseRepository
import com.vamosina.themoviedb.common.wrapper.Resource
import com.vamosinas.themoviedb.data.local.datasource.LocalDatasource
import com.vamosinas.themoviedb.data.local.model.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface FavoriteRepository {
    suspend fun getFavorite(): Flow<Resource<List<FavoriteEntity>>>
}

class FavoriteRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource
): FavoriteRepository, BaseRepository() {
    override suspend fun getFavorite(): Flow<Resource<List<FavoriteEntity>>> = flow {
        emit(proceed { localDatasource.getFavorite().first() })
    }
}
package com.vamosinas.themoviedb.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.vamosina.themoviedb.common.base.BaseRepository
import com.vamosina.themoviedb.common.mapper.MovieMapper
import com.vamosina.themoviedb.common.mapper.model.ParamMovieMapper
import com.vamosinas.themoviedb.data.network.datasource.HomeDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface HomeRepository {
    suspend fun getMovies() : Flow<PagingData<ParamMovieMapper>>
}

class HomeRepositoryImpl @Inject constructor(
    private val homeDatasource: HomeDatasource,
    private val mapper: MovieMapper
): HomeRepository, BaseRepository() {
    override suspend fun getMovies(): Flow<PagingData<ParamMovieMapper>> {
        return homeDatasource.getMovies().map {
            it.map { data ->
                mapper.mapRemoteMovieToData(data)
            }
        }
    }
}
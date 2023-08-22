package com.vamosinas.themoviedb.data.network.datasource

import com.vamosinas.themoviedb.data.network.model.response.DetailMovieResponse
import com.vamosinas.themoviedb.data.network.model.response.ReviewMovieResponse
import com.vamosinas.themoviedb.data.network.model.response.TrailerMovieResponse
import com.vamosinas.themoviedb.data.network.service.InfoService
import javax.inject.Inject

interface InfoDatasource {
    suspend fun getDetailMovie(movieId: Int): DetailMovieResponse
    suspend fun getTrailerMovie(movieId: Int): TrailerMovieResponse
    suspend fun getReviewMovie(movieId: Int): ReviewMovieResponse
}

class InfoDatasourceImpl @Inject constructor(
    private val infoService: InfoService
) : InfoDatasource {
    override suspend fun getDetailMovie(movieId: Int): DetailMovieResponse {
        return infoService.getDetailMovie(movieId)
    }

    override suspend fun getTrailerMovie(movieId: Int): TrailerMovieResponse {
        return infoService.getTrailerMovie(movieId)
    }

    override suspend fun getReviewMovie(movieId: Int): ReviewMovieResponse {
        return infoService.getReviewMovie(movieId)
    }
}
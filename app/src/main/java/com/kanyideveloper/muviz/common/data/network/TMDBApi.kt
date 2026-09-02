/*
 * Copyright 2024 Joel Kanyi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kanyideveloper.muviz.common.data.network

import com.kanyideveloper.muviz.BuildConfig.API_KEY
import com.kanyideveloper.muviz.home.data.network.dto.CreditsResponse
import com.kanyideveloper.muviz.home.data.network.dto.MovieDetails
import com.kanyideveloper.muviz.home.data.network.dto.MoviesResponse
import com.kanyideveloper.muviz.search.data.network.dto.MultiSearchResponse
import com.kanyideveloper.muviz.home.data.network.dto.TvSeriesDetails
import com.kanyideveloper.muviz.home.data.network.dto.TvSeriesResponse
import com.kanyideveloper.muviz.common.util.Constants.STARTING_PAGE_INDEX
import com.kanyideveloper.muviz.genre.data.network.dto.GenresResponse
import io.github.loinguyen.bandwidth.annotations.NetworkDownload
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApi {
    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("trending/movie/day")
    suspend fun getTrendingTodayMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MoviesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("trending/tv/day")
    suspend fun getTrendingTvSeries(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/top_rated")
    suspend fun getTopRatedTvSeries(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvSeries(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/popular")
    suspend fun getPopularTvSeries(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/airing_today")
    suspend fun getAiringTodayTvSeries(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): MovieDetails

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/{tv_id}")
    suspend fun getTvSeriesDetails(
        @Path("tv_id") tvSeriesId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): TvSeriesDetails

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): CreditsResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("tv/{tv_id}/credits")
    suspend fun getTvSeriesCredits(
        @Path("tv_id") tvSeriesId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): CreditsResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("credit/{credit_id}")
    suspend fun getCreditDetails(
        @Path("credit_id") creditId: Int,
        @Query("api_key") apiKey: String = API_KEY,
    )

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): GenresResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("genre/tv/list")
    suspend fun getTvSeriesGenres(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): GenresResponse

    @NetworkDownload(ASSUMED_MAX_TMDB_RESPONSE_BYTES, TMDB_CALL_TIMEOUT_MILLIS)
    @GET("search/multi")
    suspend fun multiSearch(
        @Query("page") page: Int = STARTING_PAGE_INDEX,
        @Query("query") query: String,
        @Query("api_key") apiKey: String = API_KEY
    ): MultiSearchResponse
}

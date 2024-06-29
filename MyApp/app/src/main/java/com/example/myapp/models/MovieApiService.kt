package com.example.myapp.models
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie")
    fun getMovies(): Call<MovieResponse>
}
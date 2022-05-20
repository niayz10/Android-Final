package com.example.afinal.api

import com.example.afinal.models.Country
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @GET("countries")
    fun get(): Call<ArrayList<Country>>

    @GET("country/{slug}")
    fun get(@Path("slug") slug: String?): Call<Country>
}
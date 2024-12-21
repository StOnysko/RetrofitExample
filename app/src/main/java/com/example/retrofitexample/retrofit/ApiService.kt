package com.example.retrofitexample.retrofit

import com.example.retrofitexample.retrofit.model.RetrofitResponseModel
import com.example.retrofitexample.retrofit.util.Constants.Companion.ALL_CATEGORIES
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(ALL_CATEGORIES)
    suspend fun getAllCategories(): Response<RetrofitResponseModel>
}
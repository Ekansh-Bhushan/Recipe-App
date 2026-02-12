package eu.ekansh.myrescipeapp

import eu.ekansh.myrescipeapp.ApiClient.apiService
import retrofit2.Retrofit
import retrofit2.http.GET


val rescipeService = apiService
interface APIService {
    //www.themealdb.com/api/json/v1/1/categories.php
    // BASE URL : www.themealdb.com/api/json/v1/1/
    // END POINT : categories.php

    @GET("categories.php")
    suspend fun getCategory() : CategoryResponse
}
package com.e.shaadi.network

import com.e.shaadi.models.Matches
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


// AMNetwork class
val service: APINetwork by lazy {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)


    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(APINetwork::class.java)
}

fun getNetworkService() = service

interface APINetwork {
    @GET("api/")
    suspend fun fetchMatches(@Query("results") count: Int): Matches
}

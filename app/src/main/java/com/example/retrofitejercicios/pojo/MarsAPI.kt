package com.example.retrofitejercicios.pojo

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsAPI {

    // la viejita confiable
    @GET("realestate")
    fun fetchMarsTerrainEnqueue(): Call<List<MarsTerrain>>


    // la forma recomendable

    @GET("realestate")
    suspend fun fetchMarsTerraCorutines(): Response<List<MarsTerrain>>
}
package com.mytask.app.data.source.remote

import com.mytask.app.data.models.GetNewsListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("viewed/{period}.json")
    suspend fun getNewsListing(
        @Path(
            value = "period",
            encoded = true
        ) period: Int,
        @Query("api-key") apiKey: String
    ): GetNewsListResponse
}
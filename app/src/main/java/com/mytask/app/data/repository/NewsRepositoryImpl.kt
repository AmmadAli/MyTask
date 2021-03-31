package com.mytask.app.data.repository

import com.mytask.app.data.models.GetNewsListResponse
import com.mytask.app.data.source.remote.ApiInterface
import com.mytask.app.domain.repository.NewsRepository
import com.mytask.app.util.Constants

class NewsRepositoryImpl(private var apiInterface: ApiInterface) : NewsRepository {
    override suspend fun getNewsListing(
        period: Int
    ): GetNewsListResponse {
        return apiInterface.getNewsListing(period,Constants.API_KEY)
    }
}
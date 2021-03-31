package com.mytask.app.domain.repository

import com.mytask.app.data.models.GetNewsListResponse

interface NewsRepository {
    suspend fun getNewsListing(
        period: Int
    ): GetNewsListResponse
}
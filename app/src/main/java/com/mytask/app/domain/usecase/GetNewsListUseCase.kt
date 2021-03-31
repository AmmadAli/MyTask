package com.mytask.app.domain.usecase

import com.mytask.app.data.models.GetNewsListResponse
import com.mytask.app.domain.repository.NewsRepository
import com.mytask.app.domain.usecase.base.BaseUseCase

class GetNewsListUseCase(
    private var newsRepository: NewsRepository
) : BaseUseCase<GetNewsListResponse, Int>() {

    override suspend fun run(params: Int): GetNewsListResponse {
        return newsRepository.getNewsListing(params)
    }
}
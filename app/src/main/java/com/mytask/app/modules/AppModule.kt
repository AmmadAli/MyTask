package com.mytask.app.modules

import com.mytask.app.data.repository.NewsRepositoryImpl
import com.mytask.app.data.source.remote.ApiInterface
import com.mytask.app.domain.repository.NewsRepository
import com.mytask.app.domain.usecase.GetNewsListUseCase
import com.mytask.app.presentation.news_list.NewsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var RepositoryModule = module {
    single { createNewsRepo(get()) }
}

var NewsModules = module {
    single { createGetNewsListUseCase(get()) }
    viewModel { NewsListViewModel(get()) }
}

fun createGetNewsListUseCase(newsRepository: NewsRepository): GetNewsListUseCase {
    return GetNewsListUseCase(newsRepository)
}

fun createNewsRepo(apiInterface: ApiInterface): NewsRepository {
    return NewsRepositoryImpl(apiInterface)
}

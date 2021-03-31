package com.mytask.app.presentation.news_list

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mytask.app.base.BaseViewModel
import com.mytask.app.data.models.GetNewsListResponse
import com.mytask.app.data.models.Result
import com.mytask.app.domain.usecase.GetNewsListUseCase
import com.mytask.app.domain.usecase.base.Outcome

class NewsListViewModel(
    private var getNewsListUseCase: GetNewsListUseCase
) : BaseViewModel() {

    private lateinit var newsLiveData: MutableLiveData<Outcome<GetNewsListResponse>>
    private var resultLiveData: MediatorLiveData<List<Result>> = MediatorLiveData()

    fun getNewsListLiveData() = resultLiveData

    fun fetchNewsList() {
        if (this::newsLiveData.isInitialized)
            resultLiveData.removeSource(newsLiveData)
        newsLiveData = getNewsListUseCase.start(
            true,
            viewModelScope,
            7
        )
        resultLiveData.addSource(newsLiveData) { outcome ->
            outcomeLiveData.value = outcome
            when (outcome) {
                is Outcome.Success -> {
                    outcome.data.results?.let {
                        resultLiveData.value = it
                    }
                }
            }
        }
    }

}
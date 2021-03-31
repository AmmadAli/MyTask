package com.mytask.app.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytask.app.domain.usecase.base.Outcome
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    var outcomeLiveData = MediatorLiveData<Outcome<*>>()

    // Cancel the job when the view model is destroyed
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}
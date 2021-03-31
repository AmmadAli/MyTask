package com.mytask.app.domain.usecase.base

interface UseCaseResponse<T> {
    fun onResponse(outcome: Outcome<T>)
}
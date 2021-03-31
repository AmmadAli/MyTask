package com.mytask.app.data.models


import com.google.gson.annotations.SerializedName

data class GetNewsListResponse(
    @SerializedName("copyright")
    var copyright: String? = "",
    @SerializedName("num_results")
    var numResults: Int? = 0,
    @SerializedName("results")
    var results: List<Result>? = listOf(),
    @SerializedName("status")
    var status: String? = ""
)
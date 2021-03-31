package com.mytask.app.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MediaMetadata(
    @SerializedName("format")
    var format: String? = "",
    @SerializedName("height")
    var height: Int? = 0,
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("width")
    var width: Int? = 0
): Parcelable
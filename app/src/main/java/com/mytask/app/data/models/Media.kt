package com.mytask.app.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
    @SerializedName("approved_for_syndication")
    var approvedForSyndication: Int? = 0,
    @SerializedName("caption")
    var caption: String? = "",
    @SerializedName("copyright")
    var copyright: String? = "",
    @SerializedName("media-metadata")
    var mediaMetadata: List<MediaMetadata?>? = listOf(),
    @SerializedName("subtype")
    var subtype: String? = "",
    @SerializedName("type")
    var type: String? = ""
) : Parcelable
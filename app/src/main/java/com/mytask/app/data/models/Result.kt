package com.mytask.app.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("abstract")
    var `abstract`: String? = "",
    @SerializedName("adx_keywords")
    var adxKeywords: String? = "",
    @SerializedName("asset_id")
    var assetId: Long? = 0,
    @SerializedName("byline")
    var byline: String? = "",
    @SerializedName("column")
    var column: String? = "",
    @SerializedName("id")
    var id: Long? = 0,
    @SerializedName("media")
    var media: List<Media>? = listOf(),
    @SerializedName("published_date")
    var publishedDate: String? = "",
    @SerializedName("section")
    var section: String? = "",
    @SerializedName("source")
    var source: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("type")
    var type: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("views")
    var views: Int? = 0


):Parcelable {
    fun getImage(): String {
        media?.let {
            for (item in it) {
                if (item.mediaMetadata?.isNotEmpty()!!)
                    return item.mediaMetadata!![0]?.url!!
            }
        }
        return ""
    }
}
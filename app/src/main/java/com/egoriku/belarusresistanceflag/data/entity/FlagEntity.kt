package com.egoriku.belarusresistanceflag.data.entity

import com.google.gson.annotations.SerializedName

class FlagEntity(
    @SerializedName("title")
    val title: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("downloadUrl")
    val downloadUrl: String?
)
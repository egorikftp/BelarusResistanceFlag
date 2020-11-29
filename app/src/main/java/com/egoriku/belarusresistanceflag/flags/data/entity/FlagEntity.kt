package com.egoriku.belarusresistanceflag.flags.data.entity

import com.google.gson.annotations.SerializedName

class FlagEntity(
    @SerializedName("title")
    val title: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    @SerializedName("imageUrl")
    val imageUrl: String
)
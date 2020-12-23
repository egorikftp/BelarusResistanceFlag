package com.egoriku.belarusresistanceflag.domain.model

data class FlagModel(
    val area: FlagArea,
    val title: String,
    val thumbnailUrl: String,
    val imageUrl: String
) {
    val id: Int = hashCode()
}

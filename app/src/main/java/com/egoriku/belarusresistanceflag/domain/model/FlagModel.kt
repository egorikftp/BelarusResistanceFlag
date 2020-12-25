package com.egoriku.belarusresistanceflag.domain.model

data class FlagModel(
    val area: FlagArea,
    val title: String,
    val thumbnailUrl: String,
    val imageUrl: String,
    val download: Download = Download.NotAvailable
) {
    val id: Int = hashCode()
}

sealed class Download {

    object NotAvailable : Download()

    data class Available(
        val downloadUrl: String,
        val format: String
    ) : Download()
}
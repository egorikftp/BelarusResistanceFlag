package com.egoriku.belarusresistanceflag.data.retrofit

import com.egoriku.belarusresistanceflag.data.entity.FlagsResponseEntity
import retrofit2.http.GET

interface ApiService {

    @GET("flags.json")
    suspend fun flags(): FlagsResponseEntity?
}
package com.egoriku.belarusresistanceflag.flags.data.retrofit

import com.egoriku.belarusresistanceflag.flags.data.entity.FlagsResponseEntity
import retrofit2.http.GET

interface ApiService {

    @GET("flags.json")
    suspend fun flags(): FlagsResponseEntity?
}
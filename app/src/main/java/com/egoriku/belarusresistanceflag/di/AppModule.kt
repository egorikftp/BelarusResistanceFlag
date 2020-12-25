package com.egoriku.belarusresistanceflag.di

import com.egoriku.belarusresistanceflag.activity.FlagsViewModel
import com.egoriku.belarusresistanceflag.data.retrofit.ApiService
import com.egoriku.belarusresistanceflag.domain.usecase.FlagsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.dze.chat")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}

val activityModule = module {
    factory { FlagsUseCase(apiService = get()) }

    viewModel {
        FlagsViewModel(get())
    }
}
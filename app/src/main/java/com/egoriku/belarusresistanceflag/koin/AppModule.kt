package com.egoriku.belarusresistanceflag.koin

import com.egoriku.belarusresistanceflag.MainActivity
import com.egoriku.belarusresistanceflag.MainViewModel
import com.egoriku.belarusresistanceflag.flags.data.retrofit.ApiService
import com.egoriku.belarusresistanceflag.flags.domain.usecase.FlagsUseCase
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
        MainViewModel(flagsUseCase = get())
    }
    scope<MainActivity> {}
}
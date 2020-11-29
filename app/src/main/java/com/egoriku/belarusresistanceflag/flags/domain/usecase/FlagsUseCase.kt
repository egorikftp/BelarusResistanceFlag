package com.egoriku.belarusresistanceflag.flags.domain.usecase

import com.egoriku.belarusresistanceflag.flags.data.retrofit.ApiService
import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.flags.domain.usecase.base.UseCase
import kotlinx.coroutines.Dispatchers

class FlagsUseCase(
    private val apiService: ApiService
) : UseCase<Unit, Map<Areas, List<FlagModel>>>(Dispatchers.IO) {

    override suspend fun execute(parameters: Unit): Map<Areas, List<FlagModel>> {
        val flags = apiService.flags()?.collection

        return if (flags == null) {
            throw  IllegalArgumentException("Empty response")
        } else {
            mapOf(
                Areas.Minsk to flags.minsk.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Brest to flags.brest.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Vitebsk to flags.vitebsk.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Gomel to flags.gomel.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Grodno to flags.grodno.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Mogilev to flags.mogilev.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Region to flags.region.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Diaspora to flags.diaspora.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                },
                Areas.Other to flags.others.map { entity ->
                    FlagModel(
                        title = entity.title,
                        thumbnailUrl = entity.thumbnailUrl,
                        imageUrl = entity.imageUrl
                    )
                }
            )
        }
    }
}
package com.egoriku.belarusresistanceflag.domain.usecase

import com.egoriku.belarusresistanceflag.data.entity.FlagEntity
import com.egoriku.belarusresistanceflag.data.retrofit.ApiService
import com.egoriku.belarusresistanceflag.domain.model.FlagArea
import com.egoriku.belarusresistanceflag.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.domain.usecase.base.UseCase
import kotlinx.coroutines.Dispatchers

class FlagsUseCase(
    private val apiService: ApiService
) : UseCase<Unit, List<FlagModel>>(Dispatchers.IO) {

    private fun toFlagModel(area: FlagArea) = { entity: FlagEntity ->
        FlagModel(
            area = area,
            title = entity.title,
            thumbnailUrl = entity.thumbnailUrl,
            imageUrl = entity.imageUrl
        )
    }

    override suspend fun execute(parameters: Unit): List<FlagModel> {
        val flags = apiService.flags()?.collection

        return if (flags == null) {
            throw IllegalArgumentException("Empty response")
        } else {
            val minsk = flags.minsk.map(toFlagModel(FlagArea.Minsk))
            val brest = flags.brest.map(toFlagModel(FlagArea.Brest))
            val vitebsk = flags.vitebsk.map(toFlagModel(FlagArea.Vitebsk))
            val gomel = flags.gomel.map(toFlagModel(FlagArea.Gomel))
            val grodno = flags.grodno.map(toFlagModel(FlagArea.Grodno))
            val mogilev = flags.mogilev.map(toFlagModel(FlagArea.Mogilev))
            val region = flags.region.map(toFlagModel(FlagArea.Region))
            val diaspora = flags.diaspora.map(toFlagModel(FlagArea.Diaspora))
            val other = flags.others.map(toFlagModel(FlagArea.Other))

            minsk + brest + vitebsk + gomel + grodno + mogilev + region + diaspora + other
        }
    }
}
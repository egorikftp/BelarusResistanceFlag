package com.egoriku.belarusresistanceflag.activity

import com.egoriku.belarusresistanceflag.domain.model.Areas
import com.egoriku.belarusresistanceflag.domain.model.FlagModel

sealed class CategoriesState {

    object Loading : CategoriesState()

    data class Success(
        val categories: Map<Areas, List<FlagModel>>
    ) : CategoriesState()

    object Error : CategoriesState()
}
package com.egoriku.belarusresistanceflag.activity

import com.egoriku.belarusresistanceflag.domain.model.FlagArea

sealed class CategoriesState {

    object Loading : CategoriesState()

    data class Success(
        val categories: List<FlagArea>,
    ) : CategoriesState()

    object Error : CategoriesState()
}
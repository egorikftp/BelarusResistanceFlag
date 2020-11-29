package com.egoriku.belarusresistanceflag.activity

import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel

sealed class State {

    object Loading : State()

    data class Success(
        val categories: Map<Areas, List<FlagModel>>
    ) : State()

    object Error : State()
}
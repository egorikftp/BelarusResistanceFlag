package com.egoriku.belarusresistanceflag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.flags.domain.usecase.FlagsUseCase
import com.egoriku.belarusresistanceflag.flags.domain.usecase.base.ResultOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val flagsUseCase: FlagsUseCase
) : ViewModel() {

    private val _flow = MutableStateFlow<Map<Areas, List<FlagModel>>>(emptyMap())
    val flow: StateFlow<Map<Areas, List<FlagModel>>> = _flow

    fun getByArea(area: Areas) = flow.value.entries
        .first { it.key == area }
        .value

    fun fetchFlags() {
        viewModelScope.launch {
            when (val resultOf = flagsUseCase(Unit)) {
                is ResultOf.Success -> {
                    _flow.value = resultOf.value
                }
                is ResultOf.Failure -> _flow.value = emptyMap()
            }
        }
    }
}
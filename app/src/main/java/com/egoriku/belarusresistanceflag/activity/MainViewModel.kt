package com.egoriku.belarusresistanceflag.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.egoriku.belarusresistanceflag.flags.domain.usecase.FlagsUseCase
import com.egoriku.belarusresistanceflag.flags.domain.usecase.base.ResultOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val flagsUseCase: FlagsUseCase
) : ViewModel() {

    private val _flow = MutableStateFlow<State>(State.Loading)
    val flow: StateFlow<State> = _flow

    fun getByArea(area: Areas) = when (val state: State = flow.value) {
        is State.Success -> {
            state.categories.entries
                .first { it.key == area }
                .value
        }
        else -> throw IllegalStateException()
    }

    fun fetchFlags() {
        _flow.value = State.Loading

        viewModelScope.launch {
            when (val resultOf = flagsUseCase(Unit)) {
                is ResultOf.Success -> {
                    _flow.value = State.Success(resultOf.value)
                }
                is ResultOf.Failure -> _flow.value = State.Error
            }
        }
    }
}
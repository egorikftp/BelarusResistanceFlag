package com.egoriku.belarusresistanceflag.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egoriku.belarusresistanceflag.domain.model.Areas
import com.egoriku.belarusresistanceflag.domain.usecase.FlagsUseCase
import com.egoriku.belarusresistanceflag.domain.usecase.base.ResultOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlagsViewModel(
    private val flagsUseCase: FlagsUseCase
) : ViewModel() {

    private val _flow = MutableStateFlow<CategoriesState>(CategoriesState.Loading)
    val flow: StateFlow<CategoriesState> = _flow

    init {
        fetchFlags()
    }

    fun getByArea(area: Areas) = when (val categoriesState: CategoriesState = flow.value) {
        is CategoriesState.Success -> {
            categoriesState.categories.entries
                .first { it.key == area }
                .value
        }
        else -> throw IllegalStateException("unknown type ${flow.value}")
    }

    private fun fetchFlags() {
        _flow.value = CategoriesState.Loading

        viewModelScope.launch {
            when (val resultOf = flagsUseCase(Unit)) {
                is ResultOf.Success -> {
                    _flow.value = CategoriesState.Success(resultOf.value)
                }
                is ResultOf.Failure -> _flow.value = CategoriesState.Error
            }
        }
    }
}
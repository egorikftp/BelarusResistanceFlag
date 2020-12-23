package com.egoriku.belarusresistanceflag.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egoriku.belarusresistanceflag.domain.model.FlagArea
import com.egoriku.belarusresistanceflag.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.domain.usecase.FlagsUseCase
import com.egoriku.belarusresistanceflag.domain.usecase.base.ResultOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlagsViewModel(
    private val flagsUseCase: FlagsUseCase
) : ViewModel() {

    private val _flagState = MutableStateFlow<List<FlagModel>>(emptyList())

    private val _categoriesFlow = MutableStateFlow<CategoriesState>(CategoriesState.Loading)
    val categoriesFlow: StateFlow<CategoriesState> = _categoriesFlow

    init {
        fetchFlags()
    }

    fun getByArea(area: FlagArea): List<FlagModel> = _flagState.value
        .filter { it.area == area }

    fun getFlagId(id: Int): FlagModel =
        _flagState.value
            .find { it.id == id }
            ?: throw IllegalArgumentException("FlagModel with $id not found")

    private fun fetchFlags() {
        _categoriesFlow.value = CategoriesState.Loading

        viewModelScope.launch {
            when (val resultOf = flagsUseCase(Unit)) {
                is ResultOf.Success -> {
                    _flagState.value = resultOf.value
                    _categoriesFlow.value = CategoriesState.Success(getAreas())
                }
                is ResultOf.Failure -> {
                    _categoriesFlow.value = CategoriesState.Error
                }
            }
        }
    }

    private fun getAreas(): List<FlagArea> = _flagState.value
        .map { it.area }
        .toSet()
        .toList()
}
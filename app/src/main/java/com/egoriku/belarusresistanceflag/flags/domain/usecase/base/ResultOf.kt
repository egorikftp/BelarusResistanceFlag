package com.egoriku.belarusresistanceflag.flags.domain.usecase.base

sealed class ResultOf<out T> {
    class Success<out T>(val value: T) : ResultOf<T>()
    class Failure(val throwable: Throwable) : ResultOf<Nothing>()
}
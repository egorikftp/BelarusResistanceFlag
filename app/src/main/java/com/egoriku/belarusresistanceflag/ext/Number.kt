package com.egoriku.belarusresistanceflag.ext

fun <T> T.isInRange(minimumValue: T, maximumValue: T): Boolean
        where T : Number, T : Comparable<T> {
    if (minimumValue > maximumValue) {
        throw IllegalArgumentException("Cannot compare value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    }
    return this < maximumValue && this > minimumValue
}

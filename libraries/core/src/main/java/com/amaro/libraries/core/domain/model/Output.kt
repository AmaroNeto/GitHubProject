package com.amaro.libraries.core.domain.model

sealed class Output<T> {

    data class Success<T>(val data: T?): Output<T>()

    data class Fail<T>(val error: Error): Output<T>()
}
package com.amaro.libraries.core.domain.model

sealed class Error {

    abstract val originalException: Throwable

    data class NetWork(override val originalException: Throwable): Error()

    data class NotFound(override val originalException: Throwable): Error()

    data class UseCaseError(override val originalException: Throwable): Error()

    data class ServiceUnavailable(override val originalException: Throwable): Error()

    data class AccessDenied(override val originalException: Throwable) : Error()

    data class Unknown(override val originalException: Throwable) : Error()
}
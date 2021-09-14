package com.amaro.feature.list.plugin

import org.mockito.Mockito

fun <T> nonOptionalAny(): T {
    Mockito.any<T>()
    return uninitialized()
}

private fun <T> uninitialized(): T = null as T

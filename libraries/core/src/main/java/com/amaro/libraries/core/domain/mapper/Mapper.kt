package com.amaro.libraries.core.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}
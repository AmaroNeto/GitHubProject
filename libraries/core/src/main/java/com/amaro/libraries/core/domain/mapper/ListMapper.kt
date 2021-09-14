package com.amaro.libraries.core.domain.mapper

interface ListMapper<I, O>: Mapper<List<I>, List<O>>

interface NullableInputListMapper<I, O>: Mapper<List<I>?, List<O>>

interface NullableOutputListMapper<I, O>: Mapper<List<I>, List<O>?>
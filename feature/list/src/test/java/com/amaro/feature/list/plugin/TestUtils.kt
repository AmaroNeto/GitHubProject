package com.amaro.feature.list.plugin

import com.amaro.libraries.core.domain.executor.RXFlowableUseCase
import com.amaro.libraries.core.domain.executor.RXMaybeUseCase
import com.amaro.libraries.core.domain.executor.RXSingleUseCase
import com.amaro.libraries.core.domain.model.Output
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.mockito.Mockito
import org.mockito.kotlin.eq

fun <P, R> RXSingleUseCase<P, R>.mockWith(
    param: P?,
    output: Output<R>
    ) {
    Mockito.`when`(this.invoke(eq(param), nonOptionalAny(), nonOptionalAny(), nonOptionalAny()))
        .thenAnswer {
            Single.fromCallable {
                output
            }.subscribeOn(Schedulers.trampoline()).subscribe()
        }
}

fun <P, R> RXMaybeUseCase<P, R>.mockWith(
    param: P?,
    output: Output<R>
) {
    Mockito.`when`(this.invoke(eq(param), nonOptionalAny(), nonOptionalAny(), nonOptionalAny()))
        .thenAnswer {
            Maybe.fromCallable {
                output
            }.subscribeOn(Schedulers.trampoline()).subscribe()
        }
}

fun <P, R> RXFlowableUseCase<P, R>.mockWith(
    param: P?,
    output: Output<R>
) {
    Mockito.`when`(this.invoke(eq(param), nonOptionalAny(), nonOptionalAny(), nonOptionalAny()))
        .thenAnswer {
            Flowable.fromCallable {
                output
            }.subscribeOn(Schedulers.trampoline()).subscribe()
        }
}
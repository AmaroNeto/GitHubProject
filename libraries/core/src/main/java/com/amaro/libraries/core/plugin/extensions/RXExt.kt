package com.amaro.libraries.core.plugin.extensions

import com.amaro.libraries.core.domain.executor.RXFlowableUseCase
import com.amaro.libraries.core.domain.executor.RXMaybeUseCase
import com.amaro.libraries.core.domain.executor.RXSingleUseCase
import com.amaro.libraries.core.domain.model.Output
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T> Single<T>.toResult(): Single<Output<T>> {
    return this.map {
        Output.Success(it) as Output<T>
    }.onErrorReturn {
        //TODO
        Output.Fail(com.amaro.libraries.core.domain.model.Error.UseCaseError(it))
    }
}

fun <T> Maybe<T>.toResult(): Maybe<Output<T>> {
    return this.map {
        Output.Success(it) as Output<T>
    }.onErrorReturn {
        Output.Fail(com.amaro.libraries.core.domain.model.Error.UseCaseError(it))
    }
}

fun <T> Flowable<T>.toResult(): Flowable<Output<T>> {
    return this.map {
        Output.Success(it) as Output<T>
    }.onErrorReturn {
        Output.Fail(com.amaro.libraries.core.domain.model.Error.UseCaseError(it))
    }
}

fun <P, R> RXSingleUseCase<P, R>.assert(param: P?, assertion: (Output<R>) -> Unit = {}) {
    invokeUseCase(param, assertion)
}

fun <P, R> RXMaybeUseCase<P, R>.assert(param: P?, assertion: (Output<R>) -> Unit = {}) {
    invokeUseCase(param, assertion)
}

fun <P, R> RXFlowableUseCase<P, R>.assert(param: P?, assertion: (Output<R>) -> Unit = {}) {
    invokeUseCase(param, assertion)
}

private fun <P, R> RXSingleUseCase<P, R>.invokeUseCase(
    param: P? = null,
    assertion: (Output<R>) -> Unit = {}
) {
    invoke(
        param,
        Schedulers.trampoline(),
        Schedulers.trampoline(),
        assertion
    )
}

private fun <P, R> RXMaybeUseCase<P, R>.invokeUseCase(
    param: P? = null,
    assertion: (Output<R>) -> Unit = {}
) {
    invoke(
        param,
        Schedulers.trampoline(),
        Schedulers.trampoline(),
        assertion
    )
}

private fun <P, R> RXFlowableUseCase<P, R>.invokeUseCase(
    param: P? = null,
    assertion: (Output<R>) -> Unit = {}
) {
    invoke(
        param,
        Schedulers.trampoline(),
        Schedulers.trampoline(),
        assertion
    )
}
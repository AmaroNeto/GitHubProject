package com.amaro.libraries.core.domain.executor

import androidx.annotation.VisibleForTesting
import com.amaro.libraries.core.domain.model.Error
import com.amaro.libraries.core.domain.model.Output
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class RXMaybeUseCase<P, R> {
    operator fun invoke(param: P?,
                        subscribe: Scheduler = Schedulers.io(),
                        observeOn: Scheduler = AndroidSchedulers.mainThread(),
                        result:(output: Output<R>) -> Unit) : Disposable {
        return process(param)
            .subscribeOn(subscribe)
            .observeOn(observeOn)
            .subscribe { output -> result(output) }
    }

    @VisibleForTesting
    internal fun process(param: P? = null): Maybe<Output<R>> {
        return execute(param).onErrorReturn { this.onError(it) }
    }

    protected abstract fun execute(param: P?): Maybe<Output<R>>

    private fun onError(t: Throwable) =
        Output.Fail<R>(Error.UseCaseError(t))
}
package com.amaro.feature.list.plugin.di

import com.amaro.feature.list.domain.interactor.GetMostStarredKotlinRepositoriesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMostStarredKotlinRepositoriesUseCase (get()) }
}
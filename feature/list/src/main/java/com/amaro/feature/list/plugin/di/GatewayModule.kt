package com.amaro.feature.list.plugin.di

import com.amaro.feature.list.gateway.ListViewModel
import org.koin.dsl.module

val gatewayModule = module {
    single { ListViewModel(get()) }
}
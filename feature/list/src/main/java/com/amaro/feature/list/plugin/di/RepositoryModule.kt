package com.amaro.feature.list.plugin.di

import android.content.ClipData
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.repository.GitHubRepository
import com.amaro.feature.list.plugin.mapper.ItemDTOListMapper
import com.amaro.feature.list.plugin.mapper.ItemDTOMapper
import com.amaro.feature.list.plugin.repository.GitHubRepositoryImpl
import com.amaro.libraries.core.domain.mapper.ListMapper
import com.amaro.libraries.core.domain.mapper.Mapper
import com.amaro.libraries.core.domain.mapper.NullableInputListMapper
import com.amaro.libraries.networking.domain.model.ItemDTO
import com.amaro.libraries.networking.plugin.NetworkUtils
import com.amaro.libraries.networking.plugin.RetrofitConfig
import com.amaro.libraries.networking.plugin.RetrofitConfigImpl
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single<GitHubRepository> { GitHubRepositoryImpl(get(),get()) }

    single<RetrofitConfig> { RetrofitConfigImpl() }
    single<ListMapper<ItemDTO, Item>> { ItemDTOListMapper() }
    single<Mapper<ItemDTO, Item>> { ItemDTOMapper() }

    single{ NetworkUtils() }
}
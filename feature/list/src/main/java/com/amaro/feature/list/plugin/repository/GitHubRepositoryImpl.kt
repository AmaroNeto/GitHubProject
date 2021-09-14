package com.amaro.feature.list.plugin.repository

import android.content.Context
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.repository.GitHubRepository
import com.amaro.libraries.core.domain.mapper.ListMapper
import com.amaro.libraries.core.domain.mapper.Mapper
import com.amaro.libraries.networking.domain.model.ItemDTO
import com.amaro.libraries.networking.plugin.NetworkUtils
import com.amaro.libraries.networking.plugin.RetrofitConfig
import io.reactivex.rxjava3.core.Flowable

const val LANGUAGE = "language:kotlin"
const val SORT = "stars"
class GitHubRepositoryImpl(
    private val retrofitConfig: RetrofitConfig,
    private val mapper: ListMapper<ItemDTO, Item>
): GitHubRepository {
    override fun getMostStartedKotlinRepositories(page: Int): Flowable<List<Item>> {
        return retrofitConfig.getGitHubAPI().getGitHubRepositories(LANGUAGE, SORT, page.toString()).map {
            mapper.map(it.items)
        }
    }
}
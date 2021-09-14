package com.amaro.feature.list.domain.repository

import com.amaro.feature.list.domain.model.Item
import io.reactivex.rxjava3.core.Flowable

interface GitHubRepository {
    fun getMostStartedKotlinRepositories(page: Int = 1): Flowable<List<Item>>
}
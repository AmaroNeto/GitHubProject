package com.amaro.feature.list.domain.interactor

import android.graphics.Movie
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.repository.GitHubRepository
import com.amaro.libraries.core.domain.executor.RXFlowableUseCase
import com.amaro.libraries.core.domain.model.Output
import com.amaro.libraries.core.plugin.extensions.toResult
import io.reactivex.rxjava3.core.Flowable

class GetMostStarredKotlinRepositoriesUseCase(
    private val gitHubRepository: GitHubRepository
) : RXFlowableUseCase<Nothing, List<Item>>() {
    override fun execute(param: Nothing?): Flowable<Output<List<Item>>> {
        return gitHubRepository.getMostStartedKotlinRepositories().toResult()
    }
}
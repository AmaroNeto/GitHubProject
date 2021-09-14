package com.amaro.feature.list.gateway

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amaro.feature.list.domain.interactor.GetMostStarredKotlinRepositoriesUseCase
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.plugin.mockWith
import com.amaro.feature.list.plugin.nonOptionalAny
import com.amaro.libraries.core.domain.model.Output
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ListViewTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var getMostStarredKotlinRepositoriesUseCase: GetMostStarredKotlinRepositoriesUseCase

    private lateinit var viewModel: ListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        viewModel = ListViewModel(getMostStarredKotlinRepositoriesUseCase)
    }

    @Test
    fun `when loadGitHubRepositories then should call GetMostStarredKotlinRepositoriesUseCase`() {
        val result = listOf<Item>()
        val data = Output.Success(result)

        getMostStarredKotlinRepositoriesUseCase.mockWith(null, data)

        viewModel.loadGitHubRepositories()

        Mockito.verify(getMostStarredKotlinRepositoriesUseCase, Mockito.times(1)).invoke(
            ArgumentMatchers.eq(null),
            nonOptionalAny(),
            nonOptionalAny(),
            nonOptionalAny()
        )
    }
}